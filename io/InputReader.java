package io.devjun.greenvsred.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InputReader {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));;
	
	public static String readLine() throws IOException {
		return bufferedReader.readLine();
	}
}
