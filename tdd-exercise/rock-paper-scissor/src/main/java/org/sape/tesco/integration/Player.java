package org.sape.tesco.integration;

import org.sape.tesco.exception.DataException;
import org.sape.tesco.model.AbstractTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.sape.tesco.util.Constants.TOOL_INFERIOR;
import static org.sape.tesco.util.Constants.TOOL_SUPERIOR;
import static org.sape.tesco.util.Constants.TOOL_TIE;
import static org.sape.tesco.util.Constants.PLAYER_LOSER;
import static org.sape.tesco.util.Constants.PLAYER_WINNER;
import static org.sape.tesco.util.Constants.PLAYER_TIE;

public class Player {
	
	private AbstractTool toolPicked;
	
	private static final Logger LOG = LoggerFactory.getLogger(Player.class);

	public Player(AbstractTool tool) {
		toolPicked = tool;
	}
	
	public String getToolName(){
		return toolPicked.toString();
	}
	
	public AbstractTool getTool(){
		return toolPicked;
	}

	public int getWinner(Player secondPlayer) throws DataException {
		
		int decision = toolPicked.checkSuperiority(secondPlayer.getTool());
		if(TOOL_INFERIOR==decision){
			LOG.info("Player 1 looses");
			return PLAYER_LOSER;
		}else if(TOOL_SUPERIOR==decision){
			LOG.info("Player 1 wins");
			return PLAYER_WINNER;
		}else if(TOOL_TIE==decision){
			LOG.info("Its a Tie");
			return PLAYER_TIE;
		} else {
			throw new DataException("Error comparing player Tools");
		}
		
		
	}

}
