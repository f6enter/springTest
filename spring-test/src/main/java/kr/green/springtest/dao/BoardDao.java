package kr.green.springtest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest.pagenation.Criteria;
import kr.green.springtest.vo.BoardVo;

public interface BoardDao {

	public List<BoardVo> getBoards();

	public void setBoard(@Param("board")BoardVo board);

	//public BoardVo getReads(Integer id);

	public BoardVo getBoard(@Param("id")Integer id);

	public void updateBoard(@Param("board")BoardVo board);
	
	public int getCountBoardLists(@Param("cri") Criteria cri);  //페이징처리시 필요

	public List<BoardVo> getBoardLists(@Param("cri") Criteria cri);   //페이징처리시 필요
}
