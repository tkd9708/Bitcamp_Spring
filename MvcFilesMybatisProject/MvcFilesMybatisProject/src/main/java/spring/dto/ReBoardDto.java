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
	
	private int cnt; // ��� ���� ����
	
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
	
	// �̹��������� �ϳ��� ������ true��ȯ
		public boolean isFileInPicture() {
			boolean b = false;
			String[] ext = {"jpg", "png", "jpeg", "gif"};
			String[] files = this.getUpload().split(",");
			
			exit:
			for(String file:files) {
				// Ȯ���� e�� ������� true : Ȯ���ڰ� �빮���ΰ�쵵 �����Ƿ�
				// ���ϸ��� �ϴ� ������ ��� �ҹ��ڷ� ������ ���� Ȯ���ڷ� �������� Ȯ���ϱ�
				for(String e:ext) {
					if(file.toLowerCase().endsWith(e)) {
						b = true;
						break exit; // �ΰ��� for���� �Ѳ����� ����������
					}
				}
			}
			
			return b;
		}
		
		// �̹��������� �����ϰ� �Ϲ������� �Ѱ��� ������� true
		public boolean isFileInGeneral() {
			boolean b = false;
			String ext = "jpg,png,jpeg,gif";
			String[] files = this.getUpload().split(",");

			for(String file:files) {
				// Ȯ���� ���
				int dot = file.indexOf(".");
				String fileExt = file.substring(dot + 1);
				//String fileExt = file.split(".")[1];
				
				// ���� Ȯ���ڰ� ext�ȿ� �ִ��� Ȯ��
				// �̹����� ������� true�̹Ƿ� �ݴ�� �̹����� �ƴҰ�� false�� �ȴ�.
				// false �϶� ��ȯ�� �Ϲ������� �ִٴ� �ǹ̷� true ��ȯ
				boolean find = ext.contains(fileExt.toLowerCase());
				if(!find) {
					b = true;
					break;
				}
			}
			return b;
		}
		
		// �ش� path�� ������ �����ϸ� true ����
		public boolean isFile(String path, String fileName) {
			boolean flag = false;
			File file = new File(path + "\\" + fileName);
			flag = file.exists(); // �����ϸ� true, �������� ������ false
			
			return flag;
		}
		
		
		// ������� �Ͻ� ��
		/* 
		 * public boolean isImage(String filename) { int dotIdx = filename.indexOf(".");
		 * String ext = filename.substring(dotIdx+1); if(ext.equalsIgnoreCase("png")||
		 * ext.equalsIgnoreCase("jpg") ||
		 * ext.equalsIgnoreCase("jpeg")||ext.equalsIgnoreCase("gif")) return true; else
		 * return false; }
		 */
	
}
