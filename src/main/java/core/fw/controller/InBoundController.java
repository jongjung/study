package core.fw.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
public class InBoundController extends AbstractController{
	
	
	/*
	 * BusinessController businessController;
	 * 
	 * public void InBoundController(){ ApplicationContext ctx = new
	 * AnnotationConfigApplicationContext(BusinessController.class);
	 * businessController = (BusinessController) ctx.getBean("businessController");
	 * 
	 * 
	 * }
	 */
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   // TODO Auto-generated method stub
		   String plainText = (String) request.getAttribute("data");
		   String jsonSample = "{\"commonData\":{\"guid\":\"111112222333\",\"trx_datetime\":\"2021111101012120000\",\"request_type\":\"S\",\"response_type\":\"\",\"system_code\":\"cor\",\"service_code\":\"scormm0001\"\r\n"
		   		+ "},\"bizData\":{\"custom_id\":\"11111\",\"account_no\":\"1234-5678-22\",\"trans_start_date\":\"20210201\",\"trans_end_date\":\"20220201\"}}";
		   
		   System.out.println("plainText : " + plainText);
		   System.out.println("plainText2 : " + jsonSample);
		   
		   // TODO 전문파싱 하는부분 추가(commonData / bizData) 	   
		
		   Gson gson = new Gson();
		   HashMap<String, Object> originData = gson.fromJson(jsonSample, new HashMap<String, Object>().getClass());
		   
			/*
			 * Iterator it = originData.keySet().iterator();
			 * 
			 * while(it.hasNext()) { String key = (String) it.next(); System.out.println(
			 * String.format("키 : %s, 값 : %s", key, originData.get(key)) ); }
			 */
		   
		   String commData = originData.get("commonData").toString();
		   String bizData =  originData.get("bizData").toString();	   
		   
		   System.out.println("commData : " + commData);
		   System.out.println("bizData : " + bizData);
		   
		   // TODO 입력데이터 로깅 / DB에 데에터 저장 (transaction관리) 
		   		  
		   
		   // TODO 공통부 변환 및 내부데이터셋에 적재 (CommonDataUtil 개발자들이 get할수 있도록 생성해서 추가)
		   
		   
		   // TODO BusinessControler 호출 
		   
		   
		   
		   
		   ModelAndView mv = new ModelAndView();
		   
		   mv.setViewName("forward:/businessController");
		   
		   Map paramMap = new HashMap<String, Object>();		   
		   mv.addObject("param", paramMap);
		   
		   return mv;
		    
	}
	
	
}
