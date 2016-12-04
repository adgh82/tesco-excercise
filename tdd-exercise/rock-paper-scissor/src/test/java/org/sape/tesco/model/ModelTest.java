package org.sape.tesco.model;

import static org.junit.Assert.assertNotNull;
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
	

}
