package kr.green.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDao;
import kr.green.springtest.pagenation.Criteria;
import kr.green.springtest.pagenation.PageMaker;
import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDao boardDao;

	@Override
	public List<BoardVo> getBoards() {
		return boardDao.getBoards();
	}

	@Override
	public void registerBoard(BoardVo board) {
		boardDao.setBoard(board);
		
	}

	@Override
	public BoardVo detailBoard(Integer id) {
		if(id == null)
			return null;
		return boardDao.getBoard(id);
	}

	@Override
	public void deleteBoard(Integer id, AccountVo user) {
		// 1. 해당 id를 가진 게시글이 없거나 이미 삭제된 경우이면 바로 종료
		// 2. 로그인한 유저가 게시판 작성자가 아닌 경우
		BoardVo board = boardDao.getBoard(id);
		if(board == null || !board.getWriter().equals(user.getId())) return;
		board.setState("D");
		boardDao.updateBoard(board); // update, delete기능이 같기 때문에 메소드 함께 사용.
	}

	@Override
	public boolean modifyBoard(BoardVo board, AccountVo user) {
		BoardVo oriBoard = boardDao.getBoard(board.getId());
		System.out.println(oriBoard);

		if(oriBoard == null || !oriBoard.getWriter().equals(user.getId()))
			return false;
		board.setRegistered_date(oriBoard.getRegistered_date());
		board.setState(oriBoard.getState());
		boardDao.updateBoard(board);
		return true;
	}
	
	  //페이징처리 메소드
	  @Override
	  public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
		  
	    int totalCount = boardDao.getCountBoardLists(cri);
	    
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCriteria(cri);
	    pageMaker.setDisplayPageNum(displayPageNum);
	    pageMaker.setTotalCount(totalCount);
	    
	    return pageMaker;
	  }

	  @Override  //페이징처리시 필요
	  public List<BoardVo> getBoardp(Criteria cri) {
	    return boardDao.getBoardLists(cri);
	  }

}
