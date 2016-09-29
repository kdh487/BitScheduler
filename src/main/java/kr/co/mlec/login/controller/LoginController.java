package kr.co.mlec.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mlec.jspboard.service.BoardService;
import kr.co.mlec.jspboard.service.BoardServiceImpl;
import kr.co.mlec.member.Member;

@Controller//("kr.co.mlec.login.controller.LoginController")
public class LoginController
{
	@Autowired
	private BoardService service;
	public LoginController()
	{
		this.service = new BoardServiceImpl();
	}
	
//	@RequestMapping("/login/login.do")
//	public String login(HttpServletRequest request) throws Exception
//	{
//		request.setCharacterEncoding("utf-8");
//		
//		// 로그인 처리 
//		// 사용자 입력 파라미터 얻기
//		Member loginUser = new Member();
//		loginUser.setId(request.getParameter("id"));
//		loginUser.setPass(request.getParameter("pass"));
//		// id = a, pass = 1 이 경우 로그인 성공
//		// 메인페이지로 이동
//		// 세션에 정보를 설정한다.
//		Member m = service.loginUser(loginUser);		
//		if (m != null) {
////			m.setId(id);
////			m.setPass(pass);
////			m.setName("테스터");
////			m.setEmail("sbc@a.com");
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("user", m);
////			return "redirect:" + request.getContextPath() + "/index.jsp";
//			return "redirect:" + "/index.jsp";
//		}
//		// 로그인 실패
//		// 로그인 폼 페이지로 이동
//		else {		
//			return "redirect:loginForm.do";
//		}
//	}
//	@RequestMapping("/login/loginForm.do")
//	public void loginForm()	throws ServletException, IOException {}
//	
//	@RequestMapping("/login/logout.do")
//	public String execute(HttpServletRequest request) throws Exception, IOException 
//	{
//		HttpSession session = request.getSession();
//		session.invalidate();
//		
////		return "redirect:"+request.getContextPath()+"/index.jsp";
//		return "redirect:" + "/index.jsp";
//	}
}
















