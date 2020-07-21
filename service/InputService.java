package io.devjun.greenvsred.service;

import java.io.IOException;

public interface InputService {
	/**
	 * User input for Field's width and height.
	 * 
	 * @return Int array with the width and height for the Field.
	 * @throws IOException
	 */
	int[] getWidthAndHeight() throws IOException;

	/**
	 * User input for cells.
	 * 
	 * @param width  2D array's width.
	 * @param height 2D array's height.
	 * @return 2D array with the cells represented by their color.
	 * @throws IOException
	 */
	int[][] getCells(int width, int height) throws IOException;

	/**
	 * User input for target cell's x and y and generations.
	 * 
	 * @return Int array with 
	 * @throws IOException target cell's x and y and generations.
	 */
	int[] getTargetCellXYAndGenerations() throws IOException;
}
