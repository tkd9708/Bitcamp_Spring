package spring.dto;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReBoardDto {
	private String num;
	private String writer;
	private String pass;
	private String subject;
	private String content;
	private String upload;
	private List<MultipartFile> files;
	private int readcount;
	private int regroup;
	private int restep;
	private int relevel;
	private Timestamp writeday;
	
	private int cnt; // 댓글 갯수 저장
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRegroup() {
		return regroup;
	}
	public void setRegroup(int regroup) {
		this.regroup = regroup;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
	// 이미지파일이 하나라도 있으면 true반환
		public boolean isFileInPicture() {
			boolean b = false;
			String[] ext = {"jpg", "png", "jpeg", "gif"};
			String[] files = this.getUpload().split(",");
			
			exit:
			for(String file:files) {
				// 확장자 e로 끝날경우 true : 확장자가 대문자인경우도 있으므로
				// 파일명을 일단 무조건 모두 소문자로 변경후 위의 확장자로 끝나는지 확인하기
				for(String e:ext) {
					if(file.toLowerCase().endsWith(e)) {
						b = true;
						break exit; // 두개의 for문을 한꺼번에 빠져나간다
					}
				}
			}
			
			return b;
		}
		
		// 이미지파일을 제외하고 일반파일이 한개라도 있을경우 true
		public boolean isFileInGeneral() {
			boolean b = false;
			String ext = "jpg,png,jpeg,gif";
			String[] files = this.getUpload().split(",");

			for(String file:files) {
				// 확장자 얻기
				int dot = file.indexOf(".");
				String fileExt = file.substring(dot + 1);
				//String fileExt = file.split(".")[1];
				
				// 파일 확장자가 ext안에 있는지 확인
				// 이미지가 있을경우 true이므로 반대로 이미지가 아닐경우 false가 된다.
				// false 일때 반환은 일반파일이 있다는 의미로 true 반환
				boolean find = ext.contains(fileExt.toLowerCase());
				if(!find) {
					b = true;
					break;
				}
			}
			return b;
		}
		
		// 해당 path에 파일이 존재하면 true 리턴
		public boolean isFile(String path, String fileName) {
			boolean flag = false;
			File file = new File(path + "\\" + fileName);
			flag = file.exists(); // 존재하면 true, 존재하지 않으면 false
			
			return flag;
		}
		
		
		// 강사님이 하신 것
		/* 
		 * public boolean isImage(String filename) { int dotIdx = filename.indexOf(".");
		 * String ext = filename.substring(dotIdx+1); if(ext.equalsIgnoreCase("png")||
		 * ext.equalsIgnoreCase("jpg") ||
		 * ext.equalsIgnoreCase("jpeg")||ext.equalsIgnoreCase("gif")) return true; else
		 * return false; }
		 */
	
}
