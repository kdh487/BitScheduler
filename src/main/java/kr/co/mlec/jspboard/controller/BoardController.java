package kr.co.mlec.jspboard.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.jspboard.BoardVO;
import kr.co.mlec.jspboard.FileVO;
import kr.co.mlec.jspboard.ReplyVO;
import kr.co.mlec.jspboard.TestVO;
import kr.co.mlec.jspboard.service.BoardService;
import kr.co.mlec.jspboard.service.BoardServiceImpl;

@Controller//("kr.co.mlec.jspboard.controller.BoardController")
//@RequestMapping("/jspboard")
public class BoardController
{
	@Autowired
	private BoardService service;
	public BoardController()
	{
		this.service = new BoardServiceImpl();
	}
	
	@RequestMapping("/test.json")
	@ResponseBody
	public List<TestVO> testAjax()
	{
		List<TestVO> temp = service.testSelect();
		System.out.println(temp.get(0).getStartDate());
		return service.testSelect();
	}
	
//	@RequestMapping("/writeReply.json")
//	@ResponseBody
//	public List<ReplyVO> writeReplyAjax(int postNo, ReplyVO rVO) throws Exception, IOException
//	{
//		service.insertReply(rVO);
//		return service.replyList(postNo);	
//	}	
//	@RequestMapping("/deleteReply.json")
//	@ResponseBody
//	public List<ReplyVO> deleteReplyAjax(int postNo, int replyNo) throws Exception, IOException 
//	{		
//		service.replyDelete(replyNo);
//		
//		return service.replyList(postNo);
//	}
//	@RequestMapping("/updateReply.json")
//	@ResponseBody
//	public List<ReplyVO> updateReplyAjax(int postNo, int replyNo, String rContent) throws Exception, IOException 
//	{
//		ReplyVO rVO = new ReplyVO();
//		rVO.setPostNo(postNo);
//		rVO.setReplyNo(replyNo);
//		rVO.setrContent(rContent);
//		
//		service.updateReply(rVO);
//		return service.replyList(postNo);
//	}
//	@RequestMapping("/replyList.json")
//	@ResponseBody
//	public List<ReplyVO> replyListAjax(int postNo) throws Exception, IOException
//	{
//		return service.replyList(postNo);
//	}
//	@RequestMapping("/detail.do")
//	public ModelAndView detail(int postNo) throws Exception, IOException
//	{
//		BoardVO vo = service.selectOne(postNo);
//		FileVO fVo = service.selectFileByNo(postNo);
//		ModelAndView mav = new ModelAndView("jspboard/detail");
//		mav.addObject("vo", vo);
//		mav.addObject("fVo", fVo);
//		return mav;
//	}
//	@RequestMapping("/delete.do")
//	public String delete(int postNo) throws Exception, IOException
//	{
//		service.deleteBoard(postNo);
//		
//		return "redirect:/jspboard/list.do";
//	}
//	@RequestMapping("/list.do")
//	public ModelAndView list() throws Exception, IOException
//	{
//		List<BoardVO> list = service.list();
//		
//		ModelAndView mav = new ModelAndView("jspboard/list");
//		mav.addObject("list", list);
//		return mav;
//	}
//	@RequestMapping("/update.do")
//	public String update(BoardVO board) throws Exception, IOException
//	{
//		service.updateBoard(board);
//		
//		return "redirect:/jspboard/list.do";
//	}	
//	@RequestMapping("/updateForm.do")
//	public ModelAndView updateForm(int postNo) throws ServletException, IOException
//	{
//		BoardVO vo = new BoardVO();
//		
//		ModelAndView mav = new ModelAndView("jspboard/updateForm");
//		mav.addObject("vo", vo);
//		return mav;
//	}	
//	@RequestMapping(value="/write.do", method = RequestMethod.POST)
//	public ModelAndView write(MultipartHttpServletRequest mRequest) throws Exception, IOException
//	{				
//		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
//		String path = sdf.format(new Date());
//		ServletContext context = mRequest.getServletContext(); 
//		String realPath = context.getRealPath("/upload");
//		realPath = realPath + path;
//		
//		File f = new File(realPath);
//		if(!f.exists()){f.mkdirs();}				
//		
////		MultipartRequest mRequest = new MultipartRequest(
////				request, 
////				realPath,	
////				1024 * 1024 * 100,
////				"UTF-8",	
////				new BitFileRenamePolicy()	
////				);
//		
//		BoardVO board = new BoardVO();
//		board.setTitle(mRequest.getParameter("title"));
//		board.setWriter(mRequest.getParameter("writer"));
//		board.setContent(mRequest.getParameter("content"));
//		
//		int postNo = service.insertBoard(board);
//		
//		List<BoardVO> list = service.list();
//		ModelAndView mav = new ModelAndView("jspboard/list");
//		mav.addObject("list", list);
//		Iterator<String> iter = mRequest.getFileNames();
//		while(iter.hasNext())
//		{
//			String formFileName = iter.next();
//			// 폼에서 파일을 선택하지 않아도 객체 생성됨
//			MultipartFile mFile = mRequest.getFile(formFileName);
//
//			// 원본 파일명
//			String oriFileName = mFile.getOriginalFilename();
//			System.out.println("원본 파일명 : " + oriFileName);
//
//			if (oriFileName != null && !oriFileName.equals(""))
//			{
//				// 확장자 처리
//				String ext = "";
//				// 뒤쪽에 있는 . 의 위치
//				int index = oriFileName.lastIndexOf(".");
//				if (index != -1)
//				{
//					// 파일명에서 확장자명(.포함)을 추출
//					ext = oriFileName.substring(index);
//				}
//
//				// 파일 사이즈
//				long fileSize = mFile.getSize();
//				System.out.println("파일 사이즈 : " + fileSize);
//
//				// 고유한 파일명 만들기
//				String saveFileName = "mlec-" + UUID.randomUUID().toString() + ext;
//				System.out.println("저장할 파일명 : " + saveFileName);
//
//				// 임시저장된 파일을 원하는 경로에 저장
//				mFile.transferTo(new File(realPath + "/" + saveFileName));
//				
//				long size = mFile.getSize();
//				FileVO fVo = new FileVO();
//				fVo.setPath(path);
//				fVo.setPostNo(postNo);
//				fVo.setOriName(oriFileName);
//				fVo.setRealName(saveFileName);
//				fVo.setFileSize(size);
//				service.insertFile(fVo);
//			}
//		}
//		return mav;
//	}
//	@RequestMapping("/writeForm.do")
//	public void writeForm() throws ServletException, IOException {}
}
