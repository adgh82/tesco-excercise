package org.sape.tesco.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ModelTest {

	@Test
	public void testCreateScissorTool() {
		AbstractTool scissor = new Scissor();
		assertNotNull("Failed to create scissor Tool", scissor);		
	}
	
	@Test
	public void testCreateStoneTool(){
		AbstractTool stone = new Stone();
		assertNotNull("Failed to create scissor Tool", stone);	
	}
	
	@Test
	public void testCreatePaperTool(){
		AbstractTool paper = new Paper();
		assertNotNull("Failed to create scissor Tool", paper);	
	}
	
	@Test
	public void testToolFactoryForScissor(){
		AbstractTool tool = ToolFactory.getTool(ToolType.SCISSOR);
		assertEquals(tool.toString(),ToolType.SCISSOR.getName());
	}
	

}
