package com.jazz.deck.exception;

public class DeckException extends Exception {

	private static final long serialVersionUID = 7735177400986388537L;
	
	public DeckException () {
		super("General exception");
	}
	
	public DeckException (String message) {
		super(message);
	}
	
	public DeckException (String message, Object... args) {
		super(String.format(message, args));
	}
}
