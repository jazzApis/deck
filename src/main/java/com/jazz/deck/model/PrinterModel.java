package com.jazz.deck.model;

public class PrinterModel {
	
	String code;
	String name;
	
	public PrinterModel() {}
	
	public PrinterModel(String code, String name) {
		setCode(code);
		setName(name);
	}
	
	public static String normalize(String text) {
		return text == null ? null : text.trim().toUpperCase(); 
	}
	public String getCodeNormalized() {
		return normalize(code);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PrinterModel [code=" + code + ", name=" + name + "]";
	}
}
