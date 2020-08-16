package com.softhaxi.reflex.controller.common;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softhaxi.reflex.domain.account.User;
import com.softhaxi.reflex.service.account.UserService;

/**
 *
 * @author ivohutasoit
 * @since 1.0.0
 */
@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "common/index2";
	}

	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html")
	public String login(Model model, @RequestParam(name="errorMessage", required = false) String errorMessage) {
		model.addAttribute("errorMessage", errorMessage);
		return "common/login";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model) {
		return "common/main";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST, produces = "text/html")
	public String home(Model model, @RequestParam("username") String userName,
			@RequestParam("password") String password) {
		User user = new User();
		String message = "";
		user.setUsername(userName);
		//user.setPassword(EncryptPasswordUtil.encrytePassword(password));
		user.setPassword(password);
		Map<String, String> messageMap = userService.validateUser(user);
		if (null != messageMap.get("id")) {
			user = userService.getDetail(messageMap.get("id"));
			model.addAttribute("user", user);
		} else {
			message = messageMap.get("message");
			model.addAttribute("errorMessage", message);
			return "redirect:login?errorMessage="+message;
		}
		return "common/main";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET, produces = "text/html")
	public String menu(Model model) {
		return "common/menu";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        model.addAttribute("logoutMessage", "Logout successfully at: " + new Date());
        return "common/login";
    }
 
}
