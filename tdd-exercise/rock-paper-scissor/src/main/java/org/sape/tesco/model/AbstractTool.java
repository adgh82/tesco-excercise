package org.sape.tesco.model;

public class AbstractTool {
	
	private ToolType toolName;
	protected AbstractTool(ToolType toolType){
		
		toolName = toolType;
	}
	
	public String toString(){
		return toolName.getName();
	}

}
