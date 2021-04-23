package Ju.Join;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinCtr {

	@Autowired
	private JoinSvc JoinSvc;

	@RequestMapping(value = "/join")
	public String join() {

		return "User/join";
	}

	@RequestMapping(value = "/joininsert")
	public String joininsert(HttpServletRequest request, HttpServletResponse response, JoinVO Join, ModelMap modelMap) {

		JoinSvc.joininsert(Join);

		HttpSession session = request.getSession();
		session.setAttribute("userID", Join.getUserID());

		return "redirect:/index";
	}

}
