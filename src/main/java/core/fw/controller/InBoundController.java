package core.fw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class InBoundController extends AbstractController{
		
	BusinessController businessController;
	
	public void InBoundController(){
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(BusinessController.class); 
		//businessController = (BusinessController) ctx.getBean("businessController");

	
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   // TODO Auto-generated method stub
		   String plainText = (String) request.getAttribute("data");
		   String plainText2 = (String) request.getParameter("data");
		
		   System.out.println("plainText : " + plainText);
		   System.out.println("plainText2 : " + plainText2);
		   
		   // TODO 전문파싱 하는부분 추가(commonData / bizData) 	   
		   
		   // TODO 입력데이터 로깅 / DB에 데에터 저장 (transaction관리) 
		   		  
		   
		   // TODO 공통부 변환 및 내부데이터셋에 적재 (CommonDataUtil 개발자들이 get할수 있도록 생성해서 추가)
		   
		   
		   // TODO BusinessControler 호출 
		   
		   
		   
		   
		   ModelAndView mv = new ModelAndView();
		   
		   mv.setViewName("forward:/businessController");
		   
		   Map paramMap = new HashMap<String, Object>();		   
		   mv.addObject("param", paramMap);
		   
		   return mv;
		   //return new ModelAndView();
	        
	}
	
	
}
