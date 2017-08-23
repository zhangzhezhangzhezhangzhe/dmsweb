package org.dms.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.dms.dto.UserDto;
import org.dms.iservice.IUserService;
import org.dms.model.Role;
import org.dms.model.RoleType;
import org.dms.model.User;
import org.dms.util.Captcha;
import org.dms.web.CmsSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class LoginController {
	private IUserService userService;
	
	
	
	
	@RequestMapping({"/","/index"})
	public void index( HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.sendRedirect(request.getContextPath()+"/login");
		
		
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "admin/login";
	}
	
	public IUserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,String checkcode,Model model,HttpSession session) {
		
		String cc = (String)session.getAttribute("cc");
		System.out.println("输入的-----"+checkcode);
		System.out.println("系统生成的-------"+cc);
		
		if(cc==null){
			return "redirect:/login";
		}else{
			if(!cc.equals(checkcode)) {
				
				model.addAttribute("error","验证码出错，请重新输入");
				return "admin/login";
			}
			User loginUser = userService.login(username, password);
			session.setAttribute("loginUser", loginUser);
//			List<Role> rs = userService.listUserRoles(loginUser.getId());
//			boolean isAdmin = isRole(rs,RoleType.ROLE_ADMIN);
//			session.setAttribute("isAdmin", isAdmin);
//			if(!isAdmin) {
//				session.setAttribute("allActions", getAllActions(rs, session));
//				//session.setAttribute("isAudit", isRole(rs,RoleType.ROLE_AUDIT));
//				//session.setAttribute("isPublish", isRole(rs,RoleType.ROLE_PUBLISH));
//			}
			session.removeAttribute("cc");
			CmsSessionContext.addSessoin(session);
			return "redirect:/admin";
		}
		
	}
	

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		System.out.println(model);
		model.addAttribute("userDto",new UserDto());//user,user
		return "admin/register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@Valid UserDto userDto,BindingResult br,Model model) {
		System.out.println(userDto.getUsername());
		System.out.println(userDto.getPassword());
		System.out.println(userDto.getHyfh());
		System.out.println(userDto.getSex());
		System.out.println(userDto.getBore());
		System.out.println(userDto.getEmail());
		System.out.println(userDto.getIntroducer());
		System.out.println(userDto.getRealname());
		System.out.println(userDto.getAddress());
		System.out.println(userDto.getZwh());
		System.out.println(userDto.getPhone());
		
		if(br.hasErrors()) {
			System.out.println("有错误吗！！！！");
			
			System.out.println(br.hasErrors());
			return "admin/register";
		}
		userService.add(userDto.getUser(), null, null);
		
		return "redirect:/login";
	}
	
	
	
	@SuppressWarnings("unchecked")
	private Set<String> getAllActions(List<Role> rs,HttpSession session) {
		Set<String> actions = new HashSet<String>();
		Map<String,Set<String>> allAuths = (Map<String,Set<String>>)session.getServletContext().getAttribute("allAuths");
		actions.addAll(allAuths.get("base"));
		for(Role r:rs) {
			if(r.getRoleType()==RoleType.ROLE_ADMIN) continue;
			actions.addAll(allAuths.get(r.getRoleType().name()));
		}
		return actions;
	}
	
	
	private boolean isRole(List<Role> rs,RoleType rt) {
		for(Role r:rs) {
			if(r.getRoleType()==rt) return true;
		}
		return false;
	}
	
	
	@RequestMapping("/drawCheckCode")
	public void drawCheckCode(HttpServletResponse resp,HttpSession session) throws IOException {
		resp.setContentType("image/jpg");
		int width = 200;
		int height = 30;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("cc", checkcode);
		System.out.println(checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
	}
}
