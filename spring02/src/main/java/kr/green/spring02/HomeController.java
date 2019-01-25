package kr.green.spring02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, String id, String pw) {
		System.out.println(id+pw);
		model.addAttribute("hi", "hello" );
		return "home";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Model model, Boolean signup) {
		// model.addAttribute("signup", signup); // 회원가입에 실패 했을때 /signup(GET)으로 들어가서 signup == false 가 됨.
		// System.out.println(signup);
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Model model) {
		return "redirect:/signup";
	}
	
}
