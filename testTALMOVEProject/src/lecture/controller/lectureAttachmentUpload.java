package lecture.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lecture.model.service.LectureService;
import lecture.model.vo.Lecture;

@WebServlet("/attach-upload.do")
public class lectureAttachmentUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public lectureAttachmentUpload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;

		int maxSize = 1024 * 1024 * 10;
		String savePath = request.getSession().getServletContext().getRealPath("/resources/lecture_upfiles");
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		Lecture lecture = new Lecture();
		if(mrequest.getParameter("videoHash").length()!=0) { System.out.println("널널");}else {System.out.println("낫널낫널");}
		int courseNo =Integer.parseInt(mrequest.getParameter("courseNumber"));
		lecture.setLectureNo(Integer.parseInt(mrequest.getParameter("lectureNo")));
		lecture.setLectureContent(mrequest.getParameter("content"));
		if(mrequest.getParameter("videoHash").length()!=0)
			lecture.setLectureOFileName(mrequest.getParameter("videoHash"));
	//	lecture.setAttachmentOfileName(mrequest.getParameter("attach-name"));
		
		String oFileName = mrequest.getFilesystemName("file");
		lecture.setAttachmentOfileName(oFileName);
		if(oFileName != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "." + oFileName.substring(oFileName.lastIndexOf('.') + 1);
			
			File oFile = new File(savePath + "/" + oFileName);
			File rFile = new File(savePath + "/" + rFileName);
			lecture.setAttachmentOfileName(oFileName);
			lecture.setAttachmentRfileName(rFileName);
			if(!oFile.renameTo(rFile)) {
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = new FileInputStream(oFile);
				FileOutputStream fout = new FileOutputStream(rFile);
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}

				fin.close();
				fout.close();	
				oFile.delete();

			}
		}
				LectureService lservice = new LectureService();
				lservice.updateLectureContent(lecture,courseNo);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
