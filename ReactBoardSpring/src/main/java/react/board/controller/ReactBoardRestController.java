package react.board.controller;

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

import react.board.data.ReactBoardDao;
import react.board.data.ReactBoardDto;

@RestController
@CrossOrigin
public class ReactBoardRestController {

	@Autowired
	ReactBoardDao dao;
	
	// 이미지 업로드시 생성한 이미지 이름
	String photoname;
	
	@GetMapping("/board/list")
	public List<ReactBoardDto> getList(){
		return dao.getList();
	}
	
	@PostMapping(value = "/board/upload", consumes = {"multipart/form-data"})
	public Map<String, String> fileUpload(@RequestParam MultipartFile uploadFile, HttpServletRequest request){
		String uploadPath = request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(uploadPath);
		
		// 이미지의 확장자 가져오기
		int pos = uploadFile.getOriginalFilename().lastIndexOf("."); // 마지막 도트의 위치
		String ext = uploadFile.getOriginalFilename().substring(pos);
		
		// 저장할 이미지명 변경하기
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		photoname = "react" + sdf.format(date) + ext;
		
		// 저장폴더에 저장
		try {
			uploadFile.transferTo(new File(uploadPath + "\\" + photoname));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("photoname", photoname);
		return map;
	}
	
	@PostMapping("/board/insert")
	public void insertBoard(@RequestBody ReactBoardDto dto) {
		
		// 이미지명 dto에 넣기
		if(photoname == null)
			dto.setPhotoname("no");
		else
			dto.setPhotoname(photoname);
		
		dao.insertBoard(dto);
		
		// insert 후 포토명 초기화
		photoname = null;
	}
	
	@GetMapping("/board/select")
	public ReactBoardDto getData(@RequestParam String num, @RequestParam(defaultValue = "no") String key) {
		// 목록에서 클릭한 경우는 조회수 증가
		if(!key.equals("no"))
			dao.updateReadCount(num);
		return dao.getData(num);
	}
	
	@PostMapping("/board/update")
	public void updateBoard(@RequestBody ReactBoardDto dto) {
		dto.setPhotoname(photoname);
		
		dao.updateBoard(dto);
		
		this.photoname = null;
	}
	
	@DeleteMapping("/board/delete")
	public void deleteBoard(@RequestParam String num, HttpServletRequest request) {
		String uploadPath = request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(uploadPath);
		
		// db에 저장된 이미지명 얻기
		String pname = dao.getData(num).getPhotoname();
		// 삭제
		File file = new File(uploadPath + "\\" + pname);
		if(file.exists())
			file.delete();
		
		// db삭제
		dao.deleteBoard(num);
	}
}
