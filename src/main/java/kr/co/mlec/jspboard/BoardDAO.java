package kr.co.mlec.jspboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.mlec.member.Member;

@Repository
public class BoardDAO
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<TestVO> testSelect()
	{
		return sqlSessionTemplate.selectList("kr.co.mlec.DayDetailDAO.testSelect");
	}
	
//	public int deleteBoard(int delNo)
//	{
//		int result = sqlSessionTemplate.delete("jspboard.BoardDAO.deleteBoard", delNo);
//		return result;
//	}
//
//	public int insertBoard(BoardVO board)
//	{
//		sqlSessionTemplate.insert("jspboard.BoardDAO.insertBoard", board);
//		return board.getPostNo();
//	}
//	
//	public void insertFile(FileVO fVo)
//	{
//		sqlSessionTemplate.insert("jspboard.BoardDAO.insertFile", fVo);
//	}
//
//	public List<BoardVO> selectAll()
//	{
//		List<BoardVO> list = sqlSessionTemplate.selectList("jspboard.BoardDAO.getBoardListAll");
//		return list;
//	}
//
//	public int updateBoard(BoardVO board)
//	{
//		int result = sqlSessionTemplate.update("jspboard.BoardDAO.updateBoard", board);
//		return result;
//	}
//
//	public BoardVO selectOne(int findNo)
//	{
//		BoardVO vo = new BoardVO();
//		vo = sqlSessionTemplate.selectOne("jspboard.BoardDAO.getBoardListOne", findNo);
//		return vo;
//	}
//
//	public FileVO selectFileByNo(int findNo)
//	{
//		FileVO fVo = new FileVO();
//		fVo = sqlSessionTemplate.selectOne("jspboard.BoardDAO.getFileListOne", findNo);
//		return fVo;
//	}
//
//	public List<ReplyVO> selectAllReply(int postNo)
//	{
//		List<ReplyVO> list = sqlSessionTemplate.selectList("jspboard.BoardDAO.getReplyListAll", postNo);
//		return list;
//	}
//
//	public void insertReply(ReplyVO rVo)
//	{
//		sqlSessionTemplate.insert("jspboard.BoardDAO.insertReply", rVo);
//	}
//
//	public void deleteReply(int delNo)
//	{
//		sqlSessionTemplate.delete("jspboard.BoardDAO.deleteReply", delNo);
//	}
//
//	public void updateReply(ReplyVO rVo)
//	{
//		sqlSessionTemplate.update("jspboard.BoardDAO.updateReply", rVo);
//	}
//
//	public Member loginUser(Member loginUser)
//	{
//		return sqlSessionTemplate.selectOne("jspboard.BoardDAO.loginUser", loginUser);
//	}
//	
//	public BoardVO temp(int findNo)
//	{
//		BoardVO vo = new BoardVO();
//		vo = sqlSessionTemplate.selectOne("jspboard.BoardDAO.getBoardListOne", findNo);
//		return vo;
//	} 
}