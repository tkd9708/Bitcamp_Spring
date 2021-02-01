package boot.react;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import boot.shop.data.MysqlShopMapper;
import boot.shop.data.ShopDto;

@CrossOrigin
@RestController
public class ReactShopController {

	@Autowired
	MysqlShopMapper mapper;
	
	MultipartFile multi;
	String uploadPath;
	String photoName;
	
	// 목록
	@GetMapping("/shop/list")
	public List<ShopDto> getList(){
		return mapper.getAllDatas();
	}
	
	// 이미지 업로드 - 멤버변수에 저장만 해두고 insert 시에 실제 업로드
	@PostMapping(value = "/shop/upload", consumes = {"multipart/form-data"})
	public Map<String, String> fileUpload(@RequestParam MultipartFile uploadFile, HttpServletRequest request){
		// 이미지 저장경로 구하기
		uploadPath = request.getSession().getServletContext().getRealPath("/photo");
		System.out.println(uploadPath);
				
		// 이미지의 확장자 가져오기
		int pos = uploadFile.getOriginalFilename().lastIndexOf("."); // 마지막 도트의 위치
		String ext = uploadFile.getOriginalFilename().substring(pos); // 예 [.jpg] 형태로 얻음
				
		// 저장할 이미지명 변경하기
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		photoName = "react" + sdf.format(date) + ext;
		
		// MultipartFile도 멤버변수에 저장
		//this.multi = uploadFile;
		// 이미지 업로드 폴더 photo에 실제 업로드 하기
		try {
			uploadFile.transferTo(new File(uploadPath + "\\" + photoName));
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("photoname", photoName); // 저장할 파일명 리턴
		
		return map;
	}
	
	// insert
	@PostMapping("/shop/insert")
	public Map<String, String> insert(@RequestBody ShopDto dto, HttpServletRequest request){
		// dto에 실제 업로드할 이미지명 저장
		dto.setPhotoname(photoName);
		
		// 이미지 업로드 폴더 photo에 실제 업로드 하기
//		try {
//			multi.transferTo(new File(uploadPath + "\\" + photoName));
//			
//		} catch (IllegalStateException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// db에 insert
		mapper.insertShop(dto);
		
		// 리턴할 메세지 (형식적으로)
		Map<String, String> map = new HashMap<String, String>();
		map.put("mes", "Insert Success"); 
		return map;
	}
	
	@GetMapping("/shop/detail")
	public ShopDto getData(@RequestParam String num) {
		return mapper.getData(num);
	}
	
	@DeleteMapping("/shop/delete")
	public void delete(@RequestParam String num) {
		mapper.deleteShop(num);
	}
	
	@PostMapping("/shop/update")
	public void update(@RequestBody ShopDto dto) {
		dto.setPhotoname("no");
		mapper.updateShop(dto);
	}
}
