package core.fw.util;

import java.util.HashMap;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import core.fw.util.vo.ServiceVo;

public class ServiceCacheUtil {

	private static ServiceCacheUtil sInstance;
	
	private static HashMap<String, Object> serviceMap; 
	
	public synchronized static ServiceCacheUtil getInstance() {
		if(sInstance == null) {
			sInstance = new ServiceCacheUtil();
			initalize();
		}
		return sInstance;
	}
	
	private static void initalize() {
		// TODO Auto-generated method stub
		serviceMap = new HashMap<String, Object>();		
		ServiceVo service1 = new ServiceVo();
		
		service1.setClassName("core.biz.dep.mm.AccountTransBcImpl");
		service1.setMethodName("retrieveAccountTransHistory");
		service1.setInputVoName("AccountTransCondVo");
		service1.setOutputVoName("AccountTransHisVo");
		
		serviceMap.put("SDPSMM0001", service1);
	}

	public ServiceVo getServiceSpec(String serviceName) {
		
		return (ServiceVo) serviceMap.get(serviceName);
	}
	
	
	
}
