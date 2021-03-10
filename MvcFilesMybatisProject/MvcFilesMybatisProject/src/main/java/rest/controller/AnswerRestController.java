package rest.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import board.dao.AnswerDao;
import spring.dto.ReAnswerDto;
import upload.util.SpringFileWriter;

@RestController
public class AnswerRestController {
	
	@Autowired
	AnswerDao dao;
	
	// �̹������� ������ �������
	String photoName;
	
	// ������ ������ ���ϰ�ü
	MultipartFile updateFile;
	
	@PostMapping("/board/photo")
	public Map<String, String> savePhoto(@RequestParam MultipartFile upload, HttpServletRequest request) {
		// ������ pass���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
		
		// �̹������� �����ؼ� db�� �����Ѵ�.
		SpringFileWriter sfw = new SpringFileWriter();
		// ��������� ���ε��� �����̸��� �ð��� �ٿ��� ����
		photoName = sfw.chageFilename(upload.getOriginalFilename());
		// save������ �̹��� ����
		sfw.writeFile(upload, photoName, path);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("photo", photoName);
		
		return map;
	}
	
	// ����ī�޶�
	@PostMapping("/board/updatephoto")
	public void updateAnswer(@RequestParam MultipartFile upload, HttpServletRequest request) {
		System.out.println("�������ϸ� : " + upload.getOriginalFilename());
		this.updateFile=upload;
	}
	
	@PostMapping("/board/answerupdate")
	public void updateAnswer(@ModelAttribute ReAnswerDto dto, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		
		// �����̹��� ����
		String deleteFile = dao.getData(dto.getIdx()).getPhotoname();
		if(deleteFile!=null) {
			File file = new File(path + "\\" + deleteFile);
			if(file.exists()) 
				file.delete();
			
		}
		
		SpringFileWriter writer = new SpringFileWriter();
		
		if(updateFile != null) { // �̹��� ���þ�������쿡�� �������
			photoName = writer.chageFilename(updateFile.getOriginalFilename());
			writer.writeFile(updateFile, photoName, path);
		}
		dto.setPhotoname(photoName);
		dao.updateAnswer(dto);
		
		// ���ϰ�ü �ʱ�ȭ
		updateFile = null;
		photoName = null;
	}
	
	@PostMapping("/board/answersave")
	public void insertAnswer(@RequestParam String msg, @RequestParam String num) {
		ReAnswerDto dto = new ReAnswerDto();
		dto.setNum(num);
		dto.setMsg(msg);
		dto.setPhotoname(photoName);
		
		dao.insertAnswer(dto);
		photoName = null;
	}
	
	@GetMapping("/board/answerlist")
	public List<ReAnswerDto> getAnswerList(@RequestParam String num){
		return dao.getAnswerList(num);
	}
	
	@GetMapping("/board/answerdelete")
	public void deleterAnswer(@RequestParam String idx, HttpServletRequest request) {
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		String deleteFile = dao.getData(idx).getPhotoname();
		if(deleteFile!=null) {
			File file = new File(path + "\\" + deleteFile);
			if(file.exists()) 
				file.delete();
			
		}
			
		dao.deleteAnswer(idx);
	}
	
	@GetMapping("/board/answerdata")
	public ReAnswerDto getData(@RequestParam String idx) {
		return dao.getData(idx);
	}
}
