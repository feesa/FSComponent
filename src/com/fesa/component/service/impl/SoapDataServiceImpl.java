package com.fesa.component.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.fesa.component.service.SoapDataService;
import com.fesa.component.utils.MessageRunnable;

public class SoapDataServiceImpl implements SoapDataService {

	private static final Log log=LogFactory.getLog(SoapDataServiceImpl.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public String parseSoap(String data) {
		return null;
	}
	
	public void receiveMessage() throws JMSException{
		TextMessage message= (TextMessage)jmsTemplate.receive();
		while(message!=null){
			String msg=message.getText();
			log.info("获取消息:"+msg);
			message=(TextMessage)jmsTemplate.receive();
		}
		log.info("接收完毕！");
	}
	public void sendMessage(){
		log.info("消息开始发送");
//		ExecutorService service=Executors.newFixedThreadPool(10);
//		for(int i=0;i<1000;i++){
//			service.execute(new MessageRunnable());
//		}
//		service.shutdown();
		log.info("消息发送完毕");
	}
}
