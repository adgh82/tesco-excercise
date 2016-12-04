package org.sape.tesco.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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
	
	@Test
	public void testToolFactoryForStone(){
		AbstractTool tool = ToolFactory.getTool(ToolType.STONE);
		assertEquals(tool.toString(),ToolType.STONE.getName());
	}
	
	@Test
	public void testToolFactoryForPaper(){
		AbstractTool tool = ToolFactory.getTool(ToolType.PAPER);
		assertEquals(tool.toString(),ToolType.PAPER.getName());
	}
	
	@Test
	public void testAddSuperiorTool(){
		AbstractTool tool = new Scissor();
		try{
		tool.addSuperiorTool(ToolType.STONE,"Stone Crushes scissor");
		}catch(Exception e){
			fail("Failed top add superior tool");
		}
	}
	
	
	

}
