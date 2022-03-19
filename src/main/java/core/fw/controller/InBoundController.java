package core.fw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class InBoundController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   // TODO Auto-generated method stub
		   String plainText = (String) request.getAttribute("data");
		
		   System.out.println("plainText : " + plainText);
		   
		   
		   
		   return new ModelAndView();
	        
	}
	
	
}
