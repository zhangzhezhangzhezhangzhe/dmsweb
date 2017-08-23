package org.dms.controller;

import javax.servlet.http.HttpSession;

import org.dms.auth.AuthClass;
import org.dms.auth.AuthMethod;
import org.dms.web.CmsSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class AdminController {
	
	@RequestMapping("/admin")
	@AuthMethod
	public String index(){
		return "admin/index";
	}
	
	@RequestMapping("/admin/logout")
	@AuthMethod
	public String logout(HttpSession session) {
		session.invalidate();
		//这个是为了解决uplaoddiy上传失败的问题
		CmsSessionContext.removeSession(session);
		System.out.println("移除了session:"+session);
		return "redirect:/login";
		
	}
	
}
