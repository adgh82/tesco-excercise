package org.sape.tesco.model;

import java.util.HashMap;
import java.util.Map;

import org.sape.tesco.exception.DataException;

public class AbstractTool {
	
	private ToolType toolName;
	private Map<ToolType,String> superiorTool;
	private Map<ToolType,String> inferiorTool;
	
	protected AbstractTool(ToolType toolType){
		
		toolName = toolType;
		superiorTool = new HashMap<ToolType,String>();
		inferiorTool = new HashMap<ToolType,String>();
	}
	
	public String toString(){
		return toolName.getName();
	}

	public void addSuperiorTool(ToolType toolType, String message) throws DataException {
		if(null==toolType){
			throw new DataException("Tool type cannot be null");
		}
		if(null==message){
			throw new DataException("Message cannot be null");
		}
		superiorTool.put(toolType, message);		
	}
	
	public void addInferiorTool(ToolType toolType, String message) throws DataException {
		
		inferiorTool.put(toolType, message);		
	}
	
	
	

}
