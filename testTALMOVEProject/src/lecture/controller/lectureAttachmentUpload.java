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

/**
 * Servlet implementation class lectureAttachmentUpload
 */
@WebServlet("/attach-upload.do")
public class lectureAttachmentUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lectureAttachmentUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("save버튼으로 서블렛진입");
		RequestDispatcher view = null;
		int maxSize = 1024 * 1024 * 10;
		String savePath = request.getSession().getServletContext().getRealPath("/resources/lecture_upfiles");
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		Lecture lecture = new Lecture();
		System.out.println("lectureNo : "+mrequest.getParameter("lectureNo"));
		lecture.setLectureNo(Integer.parseInt(mrequest.getParameter("lectureNo")));
		
		System.out.println("content : "+mrequest.getParameter("content") );
		lecture.setLectureContent(mrequest.getParameter("content"));

		System.out.println("비디오해쉬 :"+mrequest.getParameter("videoHash"));
		if(mrequest.getParameter("videoHash")==null ||mrequest.getParameter("videoHash")=="undefined" ) {
			System.out.println("videoHash=null");
		}else {
			lecture.setLectureOFileName(mrequest.getParameter("videoHash"));
			System.out.println("vedioHash="+mrequest.getParameter("videoHash"));
			}
		System.out.println("courseNo : "+ mrequest.getParameter("courseNumber") );
		int courseNo =Integer.parseInt(mrequest.getParameter("courseNumber"));
		
	//	lecture.setAttachmentOfileName(mrequest.getParameter("attach-name"));
		
		String oFileName = mrequest.getFilesystemName("file");
		lecture.setAttachmentOfileName(oFileName);
		System.out.println(oFileName);
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
				System.out.println(lecture.toString());
				fin.close();
				fout.close();	
				oFile.delete();
				System.out.println("파일저장완료");
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
