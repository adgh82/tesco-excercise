package org.sape.tesco.model;

public class ToolFactory {

	public static AbstractTool getTool(ToolType toolType) {
		AbstractTool tool=null;
		if(toolType.name().equals(ToolType.SCISSOR.name())){
			tool = new Scissor();
		}else if(toolType.name().equals(ToolType.STONE.name())){
			tool = new Stone();
		}else if(toolType.name().equals(ToolType.PAPER.name())){
			tool = new Paper();
		}
		return tool;
	}

}
