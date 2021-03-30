package mx.daro.facebooklogin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import mx.daro.facebooklogin.GetUserDetails;

@Controller
public class LoginController {	
	
	@RequestMapping("/index")
	public String star() {
		return "index";
	}
	
	@RequestMapping("/login")
	@ResponseStatus(value = HttpStatus.OK) 
	public String sing(HttpServletRequest request) {
		String access_token = (String) request.getParameter("access_token");
	    GetUserDetails obj_Get_User_Details = new GetUserDetails();
		obj_Get_User_Details.Get_Profile_info(access_token);
		return null;
	}
	
}
