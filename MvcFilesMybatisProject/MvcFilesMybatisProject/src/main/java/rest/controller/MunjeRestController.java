package rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import spring.dao.FoodDao;
import spring.dto.FoodDto;
import upload.util.SpringFileWriter;

@Controller
public class MunjeRestController {
	
	@Autowired
	FoodDao dao;
	
	String photoName;
	MultipartFile uploadfile;
	
	@GetMapping("/munje")
	public String munjeStart() {
		return "/sub/munje/food";
	}
	
	@PostMapping("/munje/photo")
	public @ResponseBody void updatePhoto(MultipartFile upload) {
		this.uploadfile = upload;
		
	}
	
	@PostMapping("/munje/insert")
	public @ResponseBody void insertFood(@ModelAttribute FoodDto dto, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		SpringFileWriter writer = new SpringFileWriter();
		
		if(uploadfile != null) {
			photoName = writer.chageFilename(uploadfile.getOriginalFilename());
			writer.writeFile(uploadfile, photoName, path);
		}
		dto.setPhotoname(photoName);
		dao.insert(dto);
		photoName = null;
	}
	
	@GetMapping("/munje/getlist")
	public @ResponseBody List<FoodDto> getList(){
		return dao.getAllDatas();
	}
}
