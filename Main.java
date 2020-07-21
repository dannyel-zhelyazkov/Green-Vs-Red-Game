package io.devjun.greenvsred;

import java.io.IOException;

import io.devjun.greenvsred.engine.GreenVsRedGame;

public class Main {
	public static void main(String[] args) throws IOException {
		// Engine class 
		GreenVsRedGame game = new GreenVsRedGame();
		
		// The main logic
		game.run();
	}
}
