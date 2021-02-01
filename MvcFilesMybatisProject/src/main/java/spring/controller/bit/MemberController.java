package spring.controller.bit;

import java.io.File;
import java.util.ArrayList;
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

import spring.dao.MemberDao;
import spring.dto.MemberDto;
import upload.util.SpringFileWriter;

@Controller
public class MemberController {
	
	@Autowired
	MemberDao dao;

	@GetMapping("/member/addform")
	public String goMemberForm() {
		
		return "/member/memberform";
	}
	
	@GetMapping("/member/list")
	public ModelAndView memberList() {
		ModelAndView model = new ModelAndView();
		
		// 목록 dao로부터 가져오기
		List<MemberDto> list = dao.getAllDatas();
		// 목록에서는 첫 이미지만 작게 출력
		for(MemberDto dto:list) {
			// 이미지가 no인 경우에는 그냥 no라고 메인사진에 저장
			if(dto.getPhotos().equals("no"))
				dto.setMainphoto("no");
			else{ // no가 아닌경우에는 분리후 첫사진이름을 저장
				String[] photos = dto.getPhotos().split(",");
				dto.setMainphoto(photos[0]);
			}
		}
		// model에 저장하기
		model.addObject("list", list);
		
		model.setViewName("/member/memberlist");
		return model;
	}
	
	@GetMapping("/member/idcheckfail")
	public ModelAndView idcheckfail() {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("/member/idcheckfail");
		return model;
	}
	
	@PostMapping("/member/savemember")
	public String insert(@ModelAttribute MemberDto dto, HttpServletRequest request) {
		
		if(dao.idCheck(dto.getMyid()) > 0)
			return "redirect:idcheckfail";
		
		//path 구하기
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
				
		String photos = "";
		SpringFileWriter writer = new SpringFileWriter();
				
		// 이미지 갯수만큼 반복문
		for(MultipartFile f : dto.getUpload()) {
			
			// 이미지를 업로드를 안했을경우 photos에 no라고 저장
			if(f.getOriginalFilename().length()==0) {
				photos = "no";
				break;
			}
			
			// 이미지명 변경
			String changeFilename = writer.chageFilename(f.getOriginalFilename());
			
			photos += changeFilename + ",";
					
			// path에 저장
			writer.writeFile(f, changeFilename, path);			
		}
		
		if(!photos.equals("no")) {

			photos = photos.substring(0, photos.length()-1);		
		}
		
		// 이미지 저장후 이미지명은 컴마로 연결해서 photos에 저장
		dto.setPhotos(photos);
		
		// db insert
		dao.insertMember(dto);
		
		return "redirect:list";
	}
	
	// 디테일 페이지
	@GetMapping("/member/detail")
	public ModelAndView detail(@RequestParam String num) {
		ModelAndView mview = new ModelAndView();
		MemberDto dto = dao.getData(num);
		mview.addObject("dto", dto);
		mview.setViewName("/member/memberdetail");
		
		return mview;
	}
	
	// 수정폼
	@GetMapping("/member/updateform")
	public ModelAndView updateForm(@RequestParam String num) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("dto", dao.getData(num));
		mview.setViewName("/member/updateform");
		
		return mview;
	}
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto, HttpServletRequest request) {
		
		// 비번이 틀릴경우 스크립트 실행
		if(dao.getPassIsCheck(dto.getNum(), dto.getPass())==0)
			return "/member/passfail";
		
		//path 구하기
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
				
		String photos = "";
		SpringFileWriter writer = new SpringFileWriter();
				
		// 이미지 갯수만큼 반복문
		for(MultipartFile f : dto.getUpload()) {
			
			// 이미지를 업로드를 안했을경우 photos에 null 저장
			if(f.getOriginalFilename().length()==0) {
				photos = null;
				break;
			}
			
			// 이미지명 변경
			String changeFilename = writer.chageFilename(f.getOriginalFilename());
			
			photos += changeFilename + ",";
					
			// path에 저장
			writer.writeFile(f, changeFilename, path);			
		}
		
		if(photos != null) {

			photos = photos.substring(0, photos.length()-1);		
			
			// 기존 이미지들은 실제 경로에서 삭제하기
			String deletePhotos = dao.getData(dto.getNum()).getPhotos();
			if(!deletePhotos.equals("no")) {
				String[] deleteFile = deletePhotos.split(",");
				for(String s:deleteFile) {
					File file = new File(path+"\\"+s);
					if(file.exists())
						file.delete();
					
					
				}
			}
		}
		
		// 이미지 저장후 이미지명은 컴마로 연결해서 photos에 저장
		dto.setPhotos(photos); // 이미지 업로드 안한경우 null값 저장됨
		
		// db insert
		dao.updateMember(dto);
		
		return "redirect:detail?num=" + dto.getNum();
	}
	
	@GetMapping("/member/deleteform")
	public ModelAndView deleteform(@RequestParam String num) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("dto", dao.getData(num));
		mview.setViewName("/member/deleteform");
		
		return mview;
	}
	
	@PostMapping("/member/delete")
	public String delete(HttpServletRequest request, @RequestParam String num, @RequestParam String pass) {
		if(dao.getPassIsCheck(num, pass)==0)
			return "/member/passfail";
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		String photos = dao.getData(num).getPhotos();
		
		if(!photos.equals("no")) {
			String[] files = photos.split(",");
			for(String s : files) {
				File file = new File(path+"\\"+s);
				if(file.exists())
					file.delete();
			}
		}
		dao.deleteMember(num);
			
		return "redirect:list";
	}
}
