package kr.green.springtest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.springtest.pagenation.Criteria;
import kr.green.springtest.pagenation.PageMaker;
import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/bbs/list", method=RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, Criteria cri) {
//		List<BoardVo> list = boardService.getBoards();
//		model.addAttribute("list",list);
		
		 /*페이징처리*/
	    PageMaker pageMaker = boardService.getPageMaker(cri,5); //블록의 갯수 5개로처리
	    List<BoardVo> list = boardService.getBoardp(cri);
	    model.addAttribute("cri", cri);
	    model.addAttribute("list", list);
	    model.addAttribute("pageMaker", pageMaker);

		
		return "bbs/list";
	}
	
	@RequestMapping(value="/bbs/register", method=RequestMethod.GET)
	public String registerGet(Model model) {
		
		return "bbs/register";
	}
	
	@RequestMapping(value="/bbs/register", method=RequestMethod.POST)
	public String registerPost(Model model, BoardVo board) {
		boardService.registerBoard(board);
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value="/bbs/detail", method=RequestMethod.GET)
	public String detailGet(Model model, Integer id) {
		// 1. 전달받은 id값을 콘솔에 출력
		//System.out.println(id);
		// 2. 서비스에서 id값을 이용하여 해당 게시글을 가져오는 메소드 호출
		BoardVo board = boardService.detailBoard(id);
		//System.out.println(board);
		if(board == null)
			return "redirect:/bbs/list";
		//boardService.read(board);
		// 3. 해당 게시글을 jsp로 전달
		model.addAttribute("board", board);
		return "bbs/detail";
	}
	
	@RequestMapping(value="/bbs/delete", method=RequestMethod.GET)
	public String deleteGet(Model model, Integer id, HttpServletRequest request) {
		// request에서 session정보를 가져와서 session에 저장된 user 정보를 가져옴
		HttpSession session = request.getSession();
		// 삭제 권한이 없는 user가 URI를 통해 삭제를 시도할 수 있기 때문에
		// 권한이 없는 user가 삭제를 시도하면 막아주기 위해서 게시판 id와 현재 로그인한 user정보 전달.
		AccountVo user = (AccountVo)session.getAttribute("user");
		boardService.deleteBoard(id, user);
		return "redirect:/bbs/list";
	}
	
	
	
	@RequestMapping(value="/bbs/modify", method=RequestMethod.GET)
	public String modifyGet(Model model, Integer id) {
		BoardVo board = boardService.detailBoard(id);
		if(board == null)
			return "redirect:/bbs/list";
		model.addAttribute("board", board);
		return "bbs/modify";
	}
	
	@RequestMapping(value="/bbs/modify", method=RequestMethod.POST)
	public String modifyPost(Model model, BoardVo board, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AccountVo user = (AccountVo)session.getAttribute("user");
		//System.out.println("id:"+board.getId());
		if(!boardService.modifyBoard(board, user))
			return "redirect:/bbs/list";
		
		model.addAttribute("id", board.getId());
		return "redirect:/bbs/detail";
	}
	
}
