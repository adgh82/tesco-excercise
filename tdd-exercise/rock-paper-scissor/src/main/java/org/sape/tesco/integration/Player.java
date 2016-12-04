package org.sape.tesco.integration;

import org.sape.tesco.model.AbstractTool;
import org.sape.tesco.model.ToolFactory;
import org.sape.tesco.model.ToolType;

public class Player {
	
	private AbstractTool toolPicked;

	public Player(ToolType toolType) {
		toolPicked = ToolFactory.getTool(toolType);
	}
	
	public String getToolName(){
		return toolPicked.toString();
	}

}
