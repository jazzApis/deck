package com.jazz.deck.repository;

import java.util.Date;

public class LogEntity {
	
	private Integer id;
    private Date cTime;
    private String code;
    private String text;
    
    public LogEntity() {}
    
    public LogEntity(String code, String text) {
    	setCode(code);
    	setText(text);
    }
    
    public LogEntity(Integer id, Date cTime, String code, String text) {
    	setId(id);
    	setcTime(cTime);
    	setCode(code);
    	setText(text);
    }
    
    public Integer getId() {
 		return id;
 	}

 	public void setId(Integer id) {
 		this.id = id;
 	}

 	public Date getcTime() {
 		return cTime;
 	}

 	public void setcTime(Date cTime) {
 		this.cTime = cTime;
 	}

 	public String getCode() {
 		return code;
 	}

 	public void setCode(String code) {
 		this.code = code;
 	}

 	public String getText() {
 		return text;
 	}

 	public void setText(String text) {
 		this.text = text;
 	}

	@Override
	public String toString() {
		return "LogEntity [id=" + id + ", cTime=" + cTime + ", code=" + code + ", text=" + text + "]";
	}
}