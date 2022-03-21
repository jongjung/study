package core.fw.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


@Controller
public class InBoundController extends AbstractController{
	
	private static final Logger logger = LoggerFactory.getLogger(InBoundController.class);
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   // TODO Auto-generated method stub
		   String plainText = this.getBody(request);
		   
			/*
			 * String jsonSample =
			 * "{\"commonData\":{\"guid\":\"111112222333\",\"trx_datetime\":\"2021111101012120000\",\"request_type\":\"S\",\"response_type\":\"\",\"system_code\":\"cor\",\"service_code\":\"scormm0001\"\r\n"
			 * +
			 * "},\"bizData\":{\"custom_id\":\"11111\",\"account_no\":\"1234-5678-22\",\"trans_start_date\":\"20210201\",\"trans_end_date\":\"20220201\"}}";
			 */
		   logger.debug("plainText : " + plainText);
		   
		   // TODO 전문파싱 하는부분 추가(commonData / bizData)
		   Gson gson = new Gson();
		   HashMap<String, Object> originData = gson.fromJson(plainText, new HashMap<String, Object>().getClass());
		   
		   String commData = originData.get("commonData").toString();
		   String bizData =  originData.get("bizData").toString();	   
		   
		   logger.debug("commData : " + commData);
		   logger.debug("bizData : " + bizData);
		   
		   // TODO 입력데이터 로깅 / DB에 데에터 저장 (transaction관리) 
		   		  
		   
		   // TODO 공통부 변환 및 내부데이터셋에 적재 (CommonDataUtil 개발자들이 get할수 있도록 생성해서 추가)
		   
		   
		   
		   // TODO BusinessControler 호출 
		   ModelAndView mv = new ModelAndView();		   
		   mv.setViewName("forward:/businessController");
		   
		   Map paramMap = new HashMap<String, Object>();		   
		   mv.addObject("bizData", bizData);
		   
		   return mv;
		    
	}
	
	
	public static String getBody(HttpServletRequest request) throws IOException {
		 
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
 
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
 
        body = stringBuilder.toString();
        return body;
    }
	
	
}
