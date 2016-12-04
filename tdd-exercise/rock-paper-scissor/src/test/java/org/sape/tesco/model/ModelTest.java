package org.sape.tesco.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.sape.tesco.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.sape.tesco.util.Constants.TOOL_INFERIOR;
import static org.sape.tesco.util.Constants.TOOL_SUPERIOR;
import static org.sape.tesco.util.Constants.TOOL_TIE;


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
	
	@Test 
	public void testAddInferiorTool(){
		AbstractTool tool = new Scissor();
		try{
		tool.addInferiorTool(ToolType.PAPER,"Scissor cuts paper");
		}catch(Exception e){
			fail("Failed top add inferior tool");
		}
	}
	
	@Test
	public void testIsSameTool(){
		LOG.debug("Testing is same tool");
		AbstractTool scissor = new Scissor();
		AbstractTool anotherScissor = new Scissor();
		assertTrue(scissor.isSameTool(anotherScissor));
	}
	
	@Test
	public void testIsSameToolFailure(){
		LOG.debug("Testing is same tool false scenario");
		AbstractTool scissor = new Scissor();
		AbstractTool stone = new Stone();
		assertFalse(scissor.isSameTool(stone));
	}
	
	@Test
	public void testSuperioritySuperior(){
		LOG.debug("testing isSuperiorTool");
		AbstractTool scissor = new Scissor();
		AbstractTool paper = new Paper();
		try {
			scissor.addInferiorTool(ToolType.PAPER, "scissor cuts paper");
			assertTrue(TOOL_SUPERIOR==scissor.checkSuperiority(paper));
		} catch (DataException e) {
			fail("Issue ocurred adding inferior tool");
		}
	}
	
	@Test
	public void testSuperiorityInferior(){
		LOG.debug("testing isSuperiorTool");
		AbstractTool scissor = new Scissor();
		AbstractTool stone = new Stone();
		try {
			scissor.addSuperiorTool(ToolType.STONE, "Stone Breaks scissor");
			assertTrue(TOOL_INFERIOR==scissor.checkSuperiority(stone));
		} catch (DataException e) {
			fail("Issue ocurred adding inferior tool");
		}
	}
	
	
	
	
	

}
