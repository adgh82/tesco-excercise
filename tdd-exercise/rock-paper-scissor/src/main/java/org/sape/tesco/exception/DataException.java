package org.sape.tesco.exception;

public class DataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2710056607979267636L;
	
	private String message;
	
	public DataException(String message) {
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}

}
