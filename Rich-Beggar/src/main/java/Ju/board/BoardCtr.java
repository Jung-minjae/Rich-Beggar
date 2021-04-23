package Ju.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardCtr {

	@Autowired
	private BoardSvc boardSvc;

	@RequestMapping(value = "boardList")
	public String BoardList(HttpServletRequest req, PageVO pv, ModelMap modelMap) {

		int pageNumber = 1;
		String pageNumber_ = req.getParameter("pageNumber");
		if(pageNumber_ != null && !pageNumber_.equals("")) {
			pageNumber = Integer.parseInt(pageNumber_);
		}
		int start = 1 + (pageNumber - 1) * 10;
		int end = pageNumber * 10;
		
		
		
		pv.setPageNumber(pageNumber);
		pv.setStart(start);
		pv.setEnd(end);
		
		String sql = "";
		String f = req.getParameter("f");
		String q = req.getParameter("q");
		
		if(q != null && !q.equals("")) {
			sql = " where " + f +"='"+ q + "' ";
		}
		
		pv.setSql(sql);

		int count = 0;
		
		count= boardSvc.selectBoardCount(pv);
		List<?> listView = boardSvc.selectBoardList(pv);
		
		modelMap.addAttribute("count", count);
		modelMap.addAttribute("pageNumber", pageNumber);
		modelMap.addAttribute("lv", listView);
		return "board/boardList";
	}

	@RequestMapping(value = "boardView")
	public String boardView(HttpServletRequest req, ModelMap modelMap) {

		int contentID = Integer.parseInt(req.getParameter("contentID"));

		List<BoardVO> bv = boardSvc.selectBoardView(contentID);

		modelMap.addAttribute("bv", bv);

		return "board/boardView";
	}

	@RequestMapping(value = "boardRead", method = RequestMethod.GET)
	public String boardRead(HttpServletRequest request, ModelMap modelMap) {

		String code = request.getParameter("code");
		List<CommentVO> cv = boardSvc.selectcommnet(code);
		if (cv != null) {
			modelMap.addAttribute("cv", cv);
		}
		modelMap.addAttribute("code", code);
		return "board/boardRead";
	}

	@RequestMapping(value = "boardRead", method = RequestMethod.POST)
	public String boardinsert(HttpServletRequest request, ModelMap modelMap) {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userID");
		String code = request.getParameter("code");
		String comment = request.getParameter("comment");

		CommentVO CV = new CommentVO(id, comment, code);
		boardSvc.selectinsertComment(CV);

		return "redirect:boardRead?code=" + code;
	}

//
	@RequestMapping(value="boardWrite", method=RequestMethod.GET)
	public String boardwrite(HttpServletRequest request, ModelMap modelMap) {
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String boardupload(HttpServletRequest request, ModelMap modelMap, BoardVO bv) {		
		boardSvc.selectBoardWrite(bv);
		
		
		return "redirect:boardList";
	}
	
	@RequestMapping(value = "boardUpdate", method = RequestMethod.GET)
	public String boardUpdate(HttpServletRequest request, ModelMap modelMap) {
		String contentID = request.getParameter("contentID");

		modelMap.addAttribute("contentID", contentID);
		return "board/boardUpdate";
	}

	@RequestMapping(value = "boardUpdate", method = RequestMethod.POST)
	public String boardUpdateinsert(HttpServletRequest request, BoardVO Bv, ModelMap modelMap) {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int contentID = Integer.parseInt(request.getParameter("contentID"));

		Bv.setTitle(title);
		Bv.setContent(content);
		Bv.setContentID(contentID);
		boardSvc.selectBoardUpdate(Bv);
		return "redirect:boardView?contentID=" + contentID;
	}
	
	@RequestMapping(value = "boardDelete")
	public String boardDelete(HttpServletRequest request, ModelMap modelMap) {

		int contentID = Integer.parseInt(request.getParameter("contentID"));
		boardSvc.selectBoardDelete(contentID);
		return "redirect:boardList";
	}
}
