package core.fw.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
//@RequestMapping("/businessController")	
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
	
	/*
	 * @RequestMapping(method = RequestMethod.GET) public ModelAndView list() {
	 * 
	 * ModelAndView mv = new ModelAndView(); // mv.setViewName("emp/list"); //
	 * mv.addObject("list", empBO.getEmpList());
	 * System.out.println("businessController"); return mv; }
	 */
	/*public String businessController(Map paramMap) {
		
		System.out.println("businessController");
		
		return "aaa";
		
	}*/
	
	

}
