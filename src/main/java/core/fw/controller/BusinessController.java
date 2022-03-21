package core.fw.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.context.request.async.WebAsyncUtils;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.util.NestedServletException;

import core.biz.dep.mm.vo.AccountTransCondVo;
import core.fw.util.ServiceCacheUtil;
import core.fw.util.SpringBeanUtils;
import core.fw.util.SpringFactoryUtil;
import core.fw.util.vo.ServiceVo;

@Component("businessController")	
public class BusinessController  extends AbstractController{
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		   String plainText = (String) request.getAttribute("bizData");
		   logger.debug("bu plainText : " + plainText);
		   
		   //TO-DO BIZ 서비스 호출 		   
		   invokeMethod();
		   
		   
		// TODO BusinessControler 호출 
		   ModelAndView mv = new ModelAndView();		   
		   mv.setViewName("forward:/outBoundController");
		   
		   Map paramMap = new HashMap<String, Object>();		   
		   
		   return mv;
	}

	private void invokeMethod() {
		// TODO Auto-generated method stub
		   ServiceVo service = ServiceCacheUtil.getInstance().getServiceSpec("SDPSMM0001");			
		   Object objClassBean = (Object)SpringFactoryUtil.getBean(service.getClassName());
		   
		   logger.debug("invoke method : " + objClassBean.toString());
		   
		   try {
			   Method method = findMethod(objClassBean , service.getMethodName());
			   
			   logger.debug("method : " + method.getName());
			   AccountTransCondVo temp = new AccountTransCondVo();
			   
			   temp.setAccountNo("aaaa");
				
			   Object result = method.invoke(objClassBean , temp);
				
			   logger.debug("sucess");
			//Method method = objClass.getClass().getMethod(service.getMethodName(),  Class<AccountTransCondVo>);		
			//method.invoke(objClass, new AccountTransCondVo());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		   
		   
	}
	
	private Method findMethod(Object bean, String methodName) throws Exception{
	
		Method[] methods = bean.getClass().getMethods();
	  
	      for(int i = 0 ; i < methods.length ; i++) {
	    	  if( methods[i].getName().equals(methodName)) {
	    		  return methods[i];
	    	  }
	      }
	
	    return null;
	}
}


