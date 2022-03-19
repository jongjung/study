package core.fw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class BusinessController  extends AbstractController{
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		   String plainText = (String) request.getAttribute("data");
		   String plainText2 = (String) request.getParameter("data");
		
		   System.out.println("bu plainText : " + plainText);
		   System.out.println("bu plainText2 : " + plainText2);
		
		System.out.println("aaaa");
		return null;
	}
	
	@RequestMapping()
	
	

}
