package org.sape.tesco.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.sape.tesco.util.Constants.PLAYER_LOSER;
import static org.sape.tesco.util.Constants.PLAYER_WINNER;
import static org.sape.tesco.util.Constants.PLAYER_TIE;

import org.junit.Before;
import org.junit.Test;
import org.sape.tesco.exception.DataException;
import org.sape.tesco.model.AbstractTool;
import org.sape.tesco.model.ToolFactory;
import org.sape.tesco.model.ToolType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerTest {
	
	private static final Logger LOG  = LoggerFactory.getLogger(PlayerTest.class);
	
	private AbstractTool scissor;
	private AbstractTool paper;
	private AbstractTool stone;
	
	@Before
	public void setUp(){
		scissor = ToolFactory.getTool(ToolType.SCISSOR);
		paper =  ToolFactory.getTool(ToolType.PAPER);
		stone =  ToolFactory.getTool(ToolType.STONE);
		try{
		scissor.addInferiorTool(ToolType.PAPER, "Scissor cuts paper");
		scissor.addSuperiorTool(ToolType.STONE, "Stone crushes scissor");
		paper.addInferiorTool(ToolType.STONE, "Paper covers stone");
		paper.addSuperiorTool(ToolType.SCISSOR, "Scissor cuts paper");
		stone.addInferiorTool(ToolType.SCISSOR, "Stone crushes scissor");
		stone.addSuperiorTool(ToolType.PAPER, "Paper covers stone");
		}catch(DataException e){
			LOG.error("Exception occurred....",e);
		}		
	}

	@Test
	public void testCreatePlayerWithScissor() {
		Player player = new Player(scissor);
		assertNotNull(player);
	}
	
	@Test
	public void testCreatePlayerWithStone() {
		Player player = new Player(stone);
		assertNotNull(player);
	}
	
	@Test
	public void testCreatePlayerWithPaper() {
		Player player = new Player(paper);
		assertNotNull(player);
	}
	
	@Test
	public void testPlayerGetTool() {
		Player player = new Player(paper);
		assertEquals(ToolType.PAPER.getName(),player.getToolName());
	}
	
	@Test
	public void testDetermineWinnerWinCase(){
		Player firstPlayer = new Player(paper);
		Player secondPlayer = new Player(stone);
		try {
			assertTrue(PLAYER_WINNER==firstPlayer.getWinner(secondPlayer));
		} catch (DataException e) {
			LOG.error("Error Occured while comparison",e);
		}
	}
	
	@Test
	public void testDetermineWinnerLooseCase(){
		Player firstPlayer = new Player(stone);
		Player secondPlayer = new Player(paper);
		try {
			assertTrue(PLAYER_LOSER==firstPlayer.getWinner(secondPlayer));
		} catch (DataException e) {
			LOG.error("Error Occured while comparison",e);
		}
	}
	
	@Test
	public void testDetermineWinnerTieCase(){
		Player firstPlayer = new Player(stone);
		Player secondPlayer = new Player(stone);
		try {
			assertTrue(PLAYER_TIE==firstPlayer.getWinner(secondPlayer));
		} catch (DataException e) {
			LOG.error("Error Occured while comparison",e);
		}
	}
	
	

}
