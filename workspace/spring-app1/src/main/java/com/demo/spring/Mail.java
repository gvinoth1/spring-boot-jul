package com.demo.spring;

public class Mail {

	private String fromAddr;
	private String toAddress;
	private Message message;
	public String getFromAddr() {
		return fromAddr;
	}
	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
