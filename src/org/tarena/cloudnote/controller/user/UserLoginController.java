package org.tarena.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.UserService;
import org.tarena.cloudnote.util.NoteResult;
@Controller
@RequestMapping("/user")
public class UserLoginController {
	@Resource
	private UserService service;

	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult execute(String name, String password) {
		NoteResult result = service.checkLogin(name, password);
		return result;
	}
}
