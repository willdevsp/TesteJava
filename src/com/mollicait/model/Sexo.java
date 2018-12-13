package com.mollicait.model;

public enum Sexo {
	
	M("masculino"),
	F("feminino");
	String value;	
	

	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	Sexo(String sexo){
		this.value= sexo;
	}
	
}
