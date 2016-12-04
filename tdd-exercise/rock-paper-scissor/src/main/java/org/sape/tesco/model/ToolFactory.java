package org.sape.tesco.model;

public class ToolFactory {

	public static AbstractTool getTool(ToolType toolType) {
		AbstractTool tool=null;
		if(toolType.name().equals(ToolType.SCISSOR.name())){
			tool = new Scissor();
		}
		return tool;
	}

}
