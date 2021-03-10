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
	
	// 이미지명을 저장할 멤버변수
	String photoName;
	
	// 수정시 저장할 파일객체
	MultipartFile updateFile;
	
	@PostMapping("/board/photo")
	public Map<String, String> savePhoto(@RequestParam MultipartFile upload, HttpServletRequest request) {
		// 저장할 pass구하기
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
		
		// 이미지명은 변경해서 db에 저장한다.
		SpringFileWriter sfw = new SpringFileWriter();
		// 멤버변수에 업로드한 파일이름에 시간을 붙여서 저장
		photoName = sfw.chageFilename(upload.getOriginalFilename());
		// save폴더에 이미지 저장
		sfw.writeFile(upload, photoName, path);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("photo", photoName);
		
		return map;
	}
	
	// 수정카메라
	@PostMapping("/board/updatephoto")
	public void updateAnswer(@RequestParam MultipartFile upload, HttpServletRequest request) {
		System.out.println("수정파일명 : " + upload.getOriginalFilename());
		this.updateFile=upload;
	}
	
	@PostMapping("/board/answerupdate")
	public void updateAnswer(@ModelAttribute ReAnswerDto dto, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		
		// 기존이미지 삭제
		String deleteFile = dao.getData(dto.getIdx()).getPhotoname();
		if(deleteFile!=null) {
			File file = new File(path + "\\" + deleteFile);
			if(file.exists()) 
				file.delete();
			
		}
		
		SpringFileWriter writer = new SpringFileWriter();
		
		if(updateFile != null) { // 이미지 선택안했을경우에는 저장안함
			photoName = writer.chageFilename(updateFile.getOriginalFilename());
			writer.writeFile(updateFile, photoName, path);
		}
		dto.setPhotoname(photoName);
		dao.updateAnswer(dto);
		
		// 파일객체 초기화
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
