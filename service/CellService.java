package io.devjun.greenvsred.service;

import io.devjun.greenvsred.models.Cell;
import io.devjun.greenvsred.models.TargetCell;

public interface CellService {
	/**
	 * Creates a new {@link Cell}.
	 * 
	 * @param color Color of the cell.
	 * @param x     Cell's x coordinate;
	 * @param y     Cell's y coordinate.
	 * @return Created cell.
	 */
	Cell createCell(int color, int x, int y);

	/**
	 * Creates a new {@link TargetCell}.
	 * 
	 * @param color Color of the cell.
	 * @param x     TargetCell's x coordinate;
	 * @param y     TargetCell's y coordinate.
	 * @return Created cell.
	 */
	TargetCell createTargetCell(int color, int x, int y);

	/**
	 * Connect all current cell's neighbours with the currrent cell.
	 * 
	 * @param x Current cell's x coodrinate.
	 * @param y Current cell's y coordinate.
	 */
	void addNeighbours(int x, int y);

	/**
	 * Chech if the current cell is ready to swap its color;
	 * 
	 * @param x Current cell's x coordinate.
	 * @param y Current cell's y coordinate.
	 * @return True if it is ready or false if it is not.
	 */
	boolean isForSwap(int x, int y);

	/**
	 * Swap the current cell's color.
	 * 
	 * @param x Current cell's x coordinate.
	 * @param y Current cell's y coordinate.
	 */
	void swapColor(int x, int y);
}
