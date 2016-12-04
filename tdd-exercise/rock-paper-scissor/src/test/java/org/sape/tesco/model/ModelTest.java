package org.sape.tesco.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.sape.tesco.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ModelTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(ModelTest.class);

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
	
	@Test
	public void testAddSuperiorNullTool(){
		AbstractTool tool = new Scissor();
		try{
		tool.addSuperiorTool(null,"Stone Crushes scissor");
		fail("Null tool type should throw message");
		}catch(DataException e){
			LOG.info("Caught required error",e);
		}
		
	}
	
	@Test
	public void testAddSuperiorNullToolMessage(){
		AbstractTool tool = new Scissor();
		try{
		tool.addSuperiorTool(ToolType.STONE,null);
		fail("Null message should throw message");
		}catch(DataException e){
			LOG.info("Caught required error",e);
		}
		
	}
	
	
	

}
