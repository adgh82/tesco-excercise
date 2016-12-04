package org.sape.tesco.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sape.tesco.model.ToolType;

public class PlayerTest {

	@Test
	public void testCreatePlayerWithScissor() {
		Player player = new Player(ToolType.SCISSOR);
		assertNotNull(player);
	}
	
	@Test
	public void testCreatePlayerWithStone() {
		Player player = new Player(ToolType.STONE);
		assertNotNull(player);
	}
	
	@Test
	public void testCreatePlayerWithPaper() {
		Player player = new Player(ToolType.PAPER);
		assertNotNull(player);
	}
	
	@Test
	public void testPlayerGetTool() {
		Player player = new Player(ToolType.PAPER);
		assertEquals(ToolType.PAPER.getName(),player.getToolName());
	}
	
	

}
