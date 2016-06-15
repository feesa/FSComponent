package com.fesa.component.utils;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageRunnable implements Runnable {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	MessageCreator msgCreator=new MessageCreator() {
		
		@Override
		public Message createMessage(Session session) throws JMSException {
			TextMessage msg=session.createTextMessage();
			String tmp="{\"reportTime\" : \"YYYY-mm-DD HH:MM:SS\",\"app\" : \"NGCNYTS-All\",\"serviceType\" : \"1\",\"serviceCategory\" : \"监控中间指标\",\"serviceDescription\" : \"[EffectiveOnTradingDate]NmbrOfSCPYieldCurveReceived\",\"reportInfo\" : \"10\",\"alertLevel\" : \"1\",\"reportDetail\" : \"[本币交易日有效]本币接收的SCP收益率曲线条数为10。\",\"unit\" : \"条\"}";
			msg.setText("测试消息"+(new Date()).toString()+":"+tmp);
			return msg;
		}
	};
	@Override
	public void run() {
		jmsTemplate.send(msgCreator);
	}

}
