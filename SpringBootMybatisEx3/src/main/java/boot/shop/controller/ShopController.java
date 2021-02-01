package boot.shop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.shop.data.MysqlShopMapper;
import boot.shop.data.ShopDto;

@Controller
public class ShopController {

	@Autowired
	MysqlShopMapper mapper;
	
	@GetMapping({"/", "/list"})
	public ModelAndView list() {
		ModelAndView mview = new ModelAndView();
		mview.setViewName("shoplist");
		int totalCount = mapper.getTotalCount();
		mview.addObject("totalCount", totalCount);
		
		List<ShopDto> list = mapper.getAllDatas();
		mview.addObject("list", list);
		
		mview.setViewName("shoplist");
		
		return mview;
	}
	
	@GetMapping("/form")
	public String form() {
		return "addform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ShopDto dto, @RequestParam MultipartFile photo, HttpServletRequest request) {
		// 이미지 저장경로
		String path = request.getSession().getServletContext().getRealPath("/photo");
		System.out.println(path);
				
		// 이미지의 확장자 가져오기
		int pos = photo.getOriginalFilename().lastIndexOf("."); // 마지막 도트의 위치
		String ext = photo.getOriginalFilename().substring(pos); // 예 [.jpg] 형태로 얻음
				
		// 저장할 이미지명 변경하기
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = "photo" + sdf.format(date) + ext;

		dto.setPhotoname(fileName); // db에 저장할 파일명 (실제 업로드된 파일명)
		
		// 이미지를 photo 폴더에 저장하기
		try {
			photo.transferTo(new File(path + "\\" + fileName));
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		// db에 저장
		mapper.insertShop(dto);
		
		return "redirect:list";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String num) {
		
		mapper.deleteShop(num);
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public ModelAndView updateform(@RequestParam String num) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("dto", mapper.getData(num));
		mview.setViewName("updateform");
		
		return mview;
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute ShopDto dto, @RequestParam MultipartFile photo, HttpServletRequest request) {
		//System.out.println(photo.getOriginalFilename());
		if(photo.getOriginalFilename().equals("")) {
			dto.setPhotoname("no");
		}
		else {
			// 이미지 저장경로 구하기
			String path = request.getSession().getServletContext().getRealPath("/photo");
			System.out.println(path);
				
			// 이미지의 확장자 가져오기
			int pos = photo.getOriginalFilename().lastIndexOf("."); // 마지막 도트의 위치
			String ext = photo.getOriginalFilename().substring(pos); // 예 [.jpg] 형태로 얻음
					
			// 저장할 이미지명 변경하기
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String fileName = "photo" + sdf.format(date) + ext;
					
			dto.setPhotoname(fileName); // db에 저장할 파일명 (실제 업로드된 파일명)
					
			// 이미지를 photo 폴더에 저장하기
			try {
				photo.transferTo(new File(path + "\\" + fileName));
					
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		mapper.updateShop(dto);
		return "redirect:list";
	}
}
