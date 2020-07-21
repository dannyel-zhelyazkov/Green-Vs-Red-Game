package io.devjun.greenvsred.service;

import java.util.List;

import io.devjun.greenvsred.models.Cell;
import io.devjun.greenvsred.models.TargetCell;

public interface FieldService {
	/**
	 * Initialize Field's width and height.
	 * 
	 * @param width  Field's width.
	 * @param height Field's heigjt.
	 */
	void init(int width, int height);

	/**
	 * Add cell to Field.
	 * 
	 * @param cell The cell that goint to be added.
	 */
	void addCell(Cell cell);

	/**
	 * Add the target cell to the Field.
	 * 
	 * @param targetCell The target cell that going to be added.
	 */
	void addTargetCell(TargetCell targetCell);

	/**
	 * Found and return cell from the Field.
	 * 
	 * @param x Cell's x coordinate.
	 * @param y Cell's y coordinate.
	 * @return Cell.
	 */
	Cell getCell(int x, int y);

	/**
	 * 
	 * @return The target cell.
	 */
	TargetCell getTargetCell();

	/**
	 * 
	 * @return All cells in the Field.
	 */
	List<Cell> getAllCells();
}
