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
		
		// ��� dao�κ��� ��������
		List<MemberDto> list = dao.getAllDatas();
		// ��Ͽ����� ù �̹����� �۰� ���
		for(MemberDto dto:list) {
			// �̹����� no�� ��쿡�� �׳� no��� ���λ����� ����
			if(dto.getPhotos().equals("no"))
				dto.setMainphoto("no");
			else{ // no�� �ƴѰ�쿡�� �и��� ù�����̸��� ����
				String[] photos = dto.getPhotos().split(",");
				dto.setMainphoto(photos[0]);
			}
		}
		// model�� �����ϱ�
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
		
		//path ���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
				
		String photos = "";
		SpringFileWriter writer = new SpringFileWriter();
				
		// �̹��� ������ŭ �ݺ���
		for(MultipartFile f : dto.getUpload()) {
			
			// �̹����� ���ε带 ��������� photos�� no��� ����
			if(f.getOriginalFilename().length()==0) {
				photos = "no";
				break;
			}
			
			// �̹����� ����
			String changeFilename = writer.chageFilename(f.getOriginalFilename());
			
			photos += changeFilename + ",";
					
			// path�� ����
			writer.writeFile(f, changeFilename, path);			
		}
		
		if(!photos.equals("no")) {

			photos = photos.substring(0, photos.length()-1);		
		}
		
		// �̹��� ������ �̹������� �ĸ��� �����ؼ� photos�� ����
		dto.setPhotos(photos);
		
		// db insert
		dao.insertMember(dto);
		
		return "redirect:list";
	}
	
	// ������ ������
	@GetMapping("/member/detail")
	public ModelAndView detail(@RequestParam String num) {
		ModelAndView mview = new ModelAndView();
		MemberDto dto = dao.getData(num);
		mview.addObject("dto", dto);
		mview.setViewName("/member/memberdetail");
		
		return mview;
	}
	
	// ������
	@GetMapping("/member/updateform")
	public ModelAndView updateForm(@RequestParam String num) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("dto", dao.getData(num));
		mview.setViewName("/member/updateform");
		
		return mview;
	}
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto, HttpServletRequest request) {
		
		// ����� Ʋ����� ��ũ��Ʈ ����
		if(dao.getPassIsCheck(dto.getNum(), dto.getPass())==0)
			return "/member/passfail";
		
		//path ���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		System.out.println(path);
				
		String photos = "";
		SpringFileWriter writer = new SpringFileWriter();
				
		// �̹��� ������ŭ �ݺ���
		for(MultipartFile f : dto.getUpload()) {
			
			// �̹����� ���ε带 ��������� photos�� null ����
			if(f.getOriginalFilename().length()==0) {
				photos = null;
				break;
			}
			
			// �̹����� ����
			String changeFilename = writer.chageFilename(f.getOriginalFilename());
			
			photos += changeFilename + ",";
					
			// path�� ����
			writer.writeFile(f, changeFilename, path);			
		}
		
		if(photos != null) {

			photos = photos.substring(0, photos.length()-1);		
			
			// ���� �̹������� ���� ��ο��� �����ϱ�
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
		
		// �̹��� ������ �̹������� �ĸ��� �����ؼ� photos�� ����
		dto.setPhotos(photos); // �̹��� ���ε� ���Ѱ�� null�� �����
		
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
