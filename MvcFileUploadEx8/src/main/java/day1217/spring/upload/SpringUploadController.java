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
		
		// �̹����� ������ ��� ���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(path);
		
		// ���ε� ������ �����ϱ�
		SpringFileWriter writer = new SpringFileWriter();
		
		// �̹����� �ڿ� ���糯¥���� �ú��ʸ� �����ؼ� �ٿ� ����
		String fileName = writer.chageFilename(photo.getOriginalFilename());
		writer.writeFile(photo, fileName, path);
		
		// �𵨿� ���ϸ� �����ϱ�
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

		// �̹����� ������ ��� ���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(path);
		
		// ����� �̹������� ������ ����Ʈ ����
		List<String> fileNames = new ArrayList<String>();
		SpringFileWriter writer = new SpringFileWriter();
		
		// �̹��� ������ŭ �ݺ���
		for(MultipartFile f : photos) {
			// �̹����� ����
			String changeFilename = writer.chageFilename(f.getOriginalFilename());
			
			// ����� �̹����� ����Ʈ�� ����
			fileNames.add(changeFilename); // jsp���� ��¸���
			
			// path�� ����
			writer.writeFile(f, changeFilename, path);
		}
		
		model.addObject("list", fileNames);
		model.setViewName("result2");
		return model;
	}
}
