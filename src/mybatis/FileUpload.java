package mybatis;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Page;

public class FileUpload {
	static public String upload = "C:/Users/SamSung/eclipse-workspace/1907-spring/WebContent/upload/";
	String tempDir = "C:/Temp/"; //실제로 Temp폴더가 있어야함.
	
	int maxSize = 1024*1024*50;
	HttpServletRequest req;
	HttpServletResponse resp;
	
	public FileUpload(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	
	public boolean uploadFormCheck() { //form이 enctype="multipart/form-data" 인지 확인하는 메소드.
		boolean flag = ServletFileUpload.isMultipartContent(req);
		
		return flag;
	}
	
	public HttpServletRequest uploading() {
		BoardVo vo = new BoardVo();
		List<AttVo> attList = new ArrayList<AttVo>(); //첨부파일목록
		List<AttVo> delList = new ArrayList<AttVo>(); //삭제파일목록
		Page p = new Page();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096); //버퍼
		factory.setRepository(new File(tempDir)); //파일이 업로드 되는 중간중간에 임시로 저장되는 공간.
		
		ServletFileUpload sf = new ServletFileUpload(factory);
		sf.setHeaderEncoding("utf-8");
		sf.setFileSizeMax(maxSize); //파일업로드 최대크기.
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<FileItem> list = sf.parseRequest(req); //form태그에 있는 link태그들을 parse해서 list에 넣음.
			for(FileItem fi : list) {
				String v = fi.getString("utf-8");
				String k = fi.getFieldName();
				
				if(fi.isFormField()) {
					switch(k) {
					case "id" : //<input type='text' name='mId' />
						vo.setId(v);
						break;
					case "pwd" :
						vo.setPwd(v);
						break;
					case "subject" :
						vo.setSubject(v);
						break;
					case "content" :
						vo.setContent(v);
						break;
					case "mDate" :
						vo.setmDate(v);
						break;
					case "serial" :
						vo.setSerial(Integer.parseInt(v));
						break;
					case "pSerial" :
						vo.setpSerial(Integer.parseInt(v));
						break;
					case "delFile" :
						AttVo attVo = new AttVo();
						attVo.setSysFile(v);
						delList.add(attVo);
						break;
					case "findStr" :
						p.setFindStr(v);
						break;
					case "nowPage" :
						p.setNowPage(Integer.parseInt(v));
						break;
					}
				}else { //<input type='file' />
					if(fi.getSize() > 0) { 
						String f = fi.getName();
						String sysFile = new Date().getTime() + "-" + f;
						AttVo attVo = new AttVo();
						attVo.setOriFile(f);
						attVo.setSysFile(sysFile);
						attList.add(attVo);
						File file = new File(upload + sysFile);
						fi.write(file);
						
						fi.delete(); //c:/Temp에 들어있는 임시파일을 지움.
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("vo", vo);
		req.setAttribute("attList", attList);
		req.setAttribute("delList", delList);
		req.setAttribute("p", p);
		return req;
	}
}
