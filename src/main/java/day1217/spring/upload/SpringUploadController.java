package day1217.spring.upload;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import upload.util.SpringFileWriter;

@Controller
public class SpringUploadController {

	@GetMapping("/")
	public String start() {
		return "start";
	}
	
	@GetMapping("/upload/one")
	public String form1() {
		return "uploadform1";
	}
	
	@GetMapping("/upload/multi")
	public String form2() {
		return "uploadform2";
	}
	
	@PostMapping("/upload/saveone")
	public ModelAndView upload1(
			@RequestParam MultipartFile photo,
			HttpServletRequest request
			) {
		ModelAndView model = new ModelAndView();
		
		// 이미지를 저장할 경로 구하기
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(path);
		
		// 업로드 폴더에 저장하기
		SpringFileWriter writer = new SpringFileWriter();
		
		// 이미지명 뒤에 현재날짜에서 시분초를 추출해서 붙여 저장
		String fileName = writer.chageFilename(photo.getOriginalFilename());
		writer.writeFile(photo, fileName, path);
		
		// 모델에 파일명 저장하기
		model.addObject("photo", fileName);
		
		model.setViewName("result1");
		return model;
	}
	
	@PostMapping("/upload/savemulti")
	public ModelAndView upload2(
			@RequestParam ArrayList<MultipartFile> photos,
			HttpServletRequest request
			) {
		ModelAndView model = new ModelAndView();

		// 이미지를 저장할 경로 구하기
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(path);
		
		// 변경된 이미지명을 저장할 리스트 선언
		List<String> fileNames = new ArrayList<String>();
		SpringFileWriter writer = new SpringFileWriter();
		
		// 이미지 갯수만큼 반복문
		for(MultipartFile f : photos) {
			// 이미지명 변경
			String changeFilename = writer.chageFilename(f.getOriginalFilename());
			
			// 변경된 이미지를 리스트에 저장
			fileNames.add(changeFilename); // jsp에서 출력목적
			
			// path에 저장
			writer.writeFile(f, changeFilename, path);
		}
		
		model.addObject("list", fileNames);
		model.setViewName("result2");
		return model;
	}
}
