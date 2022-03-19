package core.fw.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

@Component
public class CacheApplicationListener implements ApplicationListener{

	

	/*
	 * @EventListener public void onApplicationEvent(ContextRefreshedEvent event) {
	 * System.out.println("CacheApplicationListener"); }
	 */
	 
	
	
	 //스프링이 제공하는 기본 이벤트1 - ContextRefreshedEvent
    @EventListener
    public void eventHandleMethod(ContextRefreshedEvent event) {
        //어플리케이션 컨택스트가 초기화되거나 리프레쉬 될때 발생하는 이벤트
        System.out.println("aaa" + event.getApplicationContext().toString());
        
        event.getApplicationContext();
        
        System.out.println("kkk" + event.getClass().toString());
    }

    //스프링이 제공하는 기본 이벤트2 - ContextClosedEvent
    @EventListener
    public void eventHandleMethod2(ContextClosedEvent event) {
        //어플리케이션 컨택스트가 closed되어 소멸될때 발생하는 이벤트
        System.out.println("bbb" + event.getApplicationContext().toString());
    }

    //스프링이 제공하는 기본 이벤트3 - ContextStartedEvent
    @EventListener
    public void eventHandleMethod3(ContextStartedEvent event) {
        //어플리케이션 컨택스트를 start()해서 라이프사이클 빈들이 시작 신호를 받으면 발생하는 이벤트
        System.out.println("ccc"+ event.getApplicationContext().toString());
    }

    //스프링이 제공하는 기본 이벤트4 - ContextStoppedEvent
    @EventListener
    public void eventHandleMethod4(ContextStartedEvent event) {
        //어플리케이션 컨택스트를 stop()하여 라이프사이클 빈이 정지하면 발생하는 이벤트
        System.out.println("ddd" + event.getApplicationContext().toString());
    }
    
    //스프링이 제공하는 기본 이벤트5 - RequestHandledEvent
    @EventListener
    public void eventHandleMethod5(RequestHandledEvent event) {
        //HTTP 요청을 처리했을 때 발생하는 이벤트
        System.out.println("처리완료");
    }

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		
	}
	 
}
	  