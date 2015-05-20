package com.jdk.util;

import java.util.Locale;

import org.springframework.context.support.MessageSourceAccessor;

public class messageUtil {
	
	private MessageSourceAccessor msAcc = null;
	private static Locale locale = null;
	
	public void setMsAcc(MessageSourceAccessor msAcc) {
		this.msAcc = msAcc;
		locale = Locale.KOREAN;
	}
	
	public String getMessage(String key){
		return msAcc.getMessage(key, Locale.KOREAN);
	}
	
	public String getMessage(String key, String[] param){
		return msAcc.getMessage(key, param, Locale.KOREAN);
	}
}
