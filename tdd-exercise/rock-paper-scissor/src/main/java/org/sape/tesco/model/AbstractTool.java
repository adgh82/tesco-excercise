package org.sape.tesco.model;

import java.util.HashMap;
import java.util.Map;

import org.sape.tesco.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.sape.tesco.util.Constants.TOOL_INFERIOR;
import static org.sape.tesco.util.Constants.TOOL_SUPERIOR;
import static org.sape.tesco.util.Constants.TOOL_TIE;

public class AbstractTool {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractTool.class);
	
	private ToolType tool;
	private Map<String,String> superiorTool;
	private Map<String,String> inferiorTool;
	
	private static final String TIE_MESSAGE = "It's a tie";
	
	protected AbstractTool(ToolType toolType){
		
		tool = toolType;
		superiorTool = new HashMap<String,String>();
		inferiorTool = new HashMap<String,String>();
	}
	
	public ToolType getToolType(){
		return tool;
	}
	
	public String toString(){
		return tool.getName();
	}

	public void addSuperiorTool(ToolType toolType, String message) throws DataException {
		if(null==toolType){
			throw new DataException("Tool type cannot be null");
		}
		if(null==message){
			throw new DataException("Message cannot be null");
		}
		superiorTool.put(toolType.getName(), message);		
	}
	
	public void addInferiorTool(ToolType toolType, String message) throws DataException {
		
		inferiorTool.put(toolType.getName(), message);		
	}

	public boolean isSameTool(AbstractTool anotherTool) {
		if(this.toString().equals(anotherTool.toString())){
			LOG.info(TIE_MESSAGE);
			return true;
		}else{
			return false;
		}
		
	}

	public int checkSuperiority(AbstractTool tool) throws DataException {
		
		if(inferiorTool.containsKey(tool.toString())){
			LOG.info("This is a superior tool,...{}",inferiorTool.get(tool.toString()));
			return TOOL_SUPERIOR;
		}else if(superiorTool.containsKey(tool.toString())){
			LOG.info("This is an inferior tool,...{}",inferiorTool.get(tool.toString()));
			return TOOL_INFERIOR;
		}else if(isSameTool(tool)){
			return TOOL_TIE;
		}else {
			throw new DataException("Tool not found");
		}
		
	}
	
	
	

}
