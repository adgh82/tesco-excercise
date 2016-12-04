package org.sape.tesco.model;

public enum ToolType {
	SCISSOR("scissor"),
	STONE("stone"),
	PAPER("paper");
	
	private final String name;
	
	private ToolType(String name) {
		this.name=name;
	}
	
	public String getName(){
		return name;
	}

}
