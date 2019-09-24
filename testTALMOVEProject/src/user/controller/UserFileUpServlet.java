package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import user.model.service.UserService;
import user.model.vo.User;
import util.SHA256;


/**
 * Servlet implementation class UserFileUpServlet
 */
@WebServlet("/ufileup")
public class UserFileUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFileUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // 프로필사진 저장용 컨트롤러
	      RequestDispatcher view = null;
	      if (!ServletFileUpload.isMultipartContent(request)) {
	            
	      }

	      int maxSize = 1024 * 1024 * 10;

	      String savePath = request.getSession().getServletContext().getRealPath("/views/mypage/images/fileimg");

	      MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
	                  new DefaultFileRenamePolicy());

	      User user = new User();
		
	      String uemail = mrequest.getParameter("uemail");
/*	      int userNo = mrequest.getParameter("userNo");*/
	      String FileName = mrequest.getFilesystemName("profileImg");
	      UserService uservice = new UserService();
	      int result = uservice.updateUserProfile(uemail, FileName);

	      if (result > 0) {
	    	  HttpSession session = request.getSession(false);
	    	  User loginUser = (User)session.getAttribute("loginUser");
	         //메인으로 이동
	         response.setContentType("text/html;charset=utf-8");
	         PrintWriter out= response.getWriter();

	          response.sendRedirect("index.jsp"); 
	         
	      } else {
	         
	         response.setContentType("text/html;charset=utf-8");
	         PrintWriter out= response.getWriter();
	         out.println("<script>");
	         out.println("alert('다시 시도해주세요.')");
	         out.println("history.back();");
	         out.println();
	         out.println("</script>");
	         
	         
	      }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
