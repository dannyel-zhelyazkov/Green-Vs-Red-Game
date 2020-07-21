package io.devjun.greenvsred.service;

import java.io.IOException;

import io.devjun.greenvsred.consts.GameConstants;
import io.devjun.greenvsred.io.InputReader;

public class InputServiceImpl implements InputService {

	public InputServiceImpl() {
	}

	@Override
	public int[] getWidthAndHeight() throws IOException {
		String[] widthHeight = InputReader.readLine().split(GameConstants.SPLIT_PATTERN);

		int width = Integer.parseInt(widthHeight[0]);
		int height = Integer.parseInt(widthHeight[1]);

		return new int[] { width, height };
	}
	
	@Override
	public int[][] getCells(int width, int height) throws IOException {
		int[][] cells = new int[width][height];
		
		for (int i = 0; i < width; i++) {
			String line = InputReader.readLine();
			for (int j = 0; j < cells.length; j++) {
				cells[i][j] = line.charAt(j) - 48;
			}
		}
		
		return cells;
	}
	
	@Override
	public int[] getTargetCellXYAndGenerations() throws IOException {
		String[] targetCellXYAndGenerations = InputReader.readLine().split(GameConstants.SPLIT_PATTERN);
		
		int targetCellX = Integer.parseInt(targetCellXYAndGenerations[0]);
		int targetCellY = Integer.parseInt(targetCellXYAndGenerations[1]);
		int generations = Integer.parseInt(targetCellXYAndGenerations[2]);
		
		return new int[] { targetCellX, targetCellY, generations };
	}
}
