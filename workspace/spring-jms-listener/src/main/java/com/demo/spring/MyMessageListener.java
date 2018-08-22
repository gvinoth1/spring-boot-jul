package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component
public class MyMessageListener {

	@JmsListener(destination="myqueue",containerFactory="factory")
	public void getMessage(Message message) throws JMSException{
		TextMessage tm=(TextMessage)message;
		System.out.println("received : "+tm.getText());
	}
}
