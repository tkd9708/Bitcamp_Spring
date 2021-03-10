package board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.service.BoardServiceInter;

@Controller
public class BoardContentController {

	@Autowired	
	private BoardServiceInter serviceInter;	

	@GetMapping("/board/content")
	public ModelAndView goContent(
			@RequestParam String num, 
			@RequestParam String pageNum, 
			@RequestParam(required=false) String key, // required=false >> �ʼ��Է¾ƴ�, null�����
				HttpServletRequest request) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("dto", serviceInter.getData(num));
		mview.addObject("pageNum", pageNum);
		
		if(key != null)
			serviceInter.updateReadCount(num);
		
		
		ArrayList<String> imguploads = new ArrayList<>();
		
		String[] s = serviceInter.getData(num).getUpload().split(",");
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/save");
		String ext = "jpg,jpeg,png,gif";
		for(String myfile : s){
			// Ȯ���� ���
			int dot = myfile.indexOf(".");
			String fileExt = myfile.substring(dot + 1);
			
			// ����Ȯ���ڰ� �̹��� Ȯ������ ��쿡�� ����ϱ�
			if(ext.contains(fileExt.toLowerCase())){
				// �̹����� ���ϼ����� ������ ��쿡�� ���
				
				if(serviceInter.getData(num).isFile(path, myfile)){
					
					imguploads.add(myfile);
					
				}
			}
		}
		mview.addObject("imguploads", imguploads);
		
		ArrayList<String> fileuploads = new ArrayList<String>();
		
		if(!serviceInter.getData(num).getUpload().equals("no")){
			for(String myfile : s){
				if(serviceInter.getData(num).isFile(path, myfile)){
					
					fileuploads.add(myfile);
				} 
			}
		}
		mview.addObject("fileuploads", fileuploads);
		
		mview.setViewName("/sub/board/content");
		return mview;
	}
	
	//�ܺμ����� ������ �� ��ǻ�ͷ� �ٿ�ε��ϴ¼ҽ�
 	@GetMapping("/download")
 	public void download(HttpServletRequest request,
 			HttpServletResponse response,
 			@RequestParam String clip)
 	{
 		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/save");
 		File file=new File(path+"\\"+clip);
 		System.out.println("���� ���:"+file);
 		setHeaderType(response, request, file);
  
 		try {
 			transport(new FileInputStream(file),
 					response.getOutputStream(), file);
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}  
 	}
 	
 	private void setHeaderType(HttpServletResponse response,
 			HttpServletRequest request, File file)
 	{
 		String mime = request.getSession().getServletContext().getMimeType(file.toString());
 		if(mime != null)
 			mime = "application/octet-stream";
 		response.setContentType(mime);
 		response.setHeader("Content-Disposition", "attachment;filename=" + toEng(file.getName()));
 		response.setHeader("Content-Length", "" + file.length());
 	}

 	private void transport(InputStream in, OutputStream out, File file) throws IOException
 	{
 		BufferedInputStream bin = null;
 		BufferedOutputStream bos = null;

 		try{
 			bin = new BufferedInputStream(in);
 			bos = new BufferedOutputStream(out);

 			byte[] buf=new byte[(int)file.length()];
 			int read=0;
 			while((read = bin.read(buf)) != -1)
 			{
 				bos.write(buf, 0, read);   //��ü, ����(offset), ����
 			}
 		}catch(Exception e){
 			System.out.println("transport error : " + e);
 		}finally{
 			bos.close();
 			bin.close();
 		}
 	}
 	//////////////////////////////////////////////////////////////
 	public String toEng(String str)
 	{
 		String tmp=null;
 		try{
 			tmp = new String(str.getBytes("utf-8"), "8859_1");
 		}catch(Exception e){}
 		return tmp;
 	}         
}
