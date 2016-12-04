package org.sape.tesco.model;

import java.util.HashMap;
import java.util.Map;

public class AbstractTool {
	
	private ToolType toolName;
	private Map<ToolType,String> superiorTool;
	
	protected AbstractTool(ToolType toolType){
		
		toolName = toolType;
		superiorTool = new HashMap<ToolType,String>();
	}
	
	public String toString(){
		return toolName.getName();
	}

	public void addSuperiorTool(ToolType toolType, String string) {
		superiorTool.put(toolType, string);		
	}
	
	

}
