package io.devjun.greenvsred.engine;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import io.devjun.greenvsred.io.OutputWriter;
import io.devjun.greenvsred.models.Cell;
import io.devjun.greenvsred.service.CellService;
import io.devjun.greenvsred.service.CellServiceImpl;
import io.devjun.greenvsred.service.FieldService;
import io.devjun.greenvsred.service.FieldServiceImpl;
import io.devjun.greenvsred.service.InputService;
import io.devjun.greenvsred.service.InputServiceImpl;

public class GreenVsRedGame {
	private final FieldService fieldService;
	private final CellService cellService;
	private final InputService inputService;

	public GreenVsRedGame() {
		this.fieldService = new FieldServiceImpl();
		this.cellService = new CellServiceImpl(this.fieldService);
		this.inputService = new InputServiceImpl();
	}

	/**
	 * Initializing Field class.
	 * 
	 * @param widthHeight Array containing the width and the height for the field.
	 * @throws IOException
	 */
	private void initField(int[] widthHeight) throws IOException {
		this.fieldService.init(widthHeight[0], widthHeight[1]);
	}

	/**
	 * Adds all cells to the field.
	 * 
	 * @param cells       2D array with all cells that going to be added to the
	 *                    field.
	 * @param targetCellX The target cell's x coordinate.
	 * @param targetCellY The target cell's y coordinate.
	 */
	private void populateField(int[][] cells, int targetCellX, int targetCellY) {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (i == targetCellX && j == targetCellY) {
					this.fieldService.addTargetCell(this.cellService.createTargetCell(cells[i][j], i, j));
				} else {
					this.fieldService.addCell(this.cellService.createCell(cells[i][j], i, j));
				}
			}
		}
	}
	
	public void run() throws IOException {

		// User input for field's width and height.
		int[] widthHeight = this.inputService.getWidthAndHeight();

		// Creating Field class.
		initField(widthHeight);
		
		// User input for all cells that are going to be added to the field
		int[][] cells = inputService.getCells(widthHeight[0], widthHeight[1]);

		// Target cells's x and y coordinates and generations.
		int[] targetCellXYAndGenerations = this.inputService.getTargetCellXYAndGenerations();
		
		int generations = targetCellXYAndGenerations[2];

		// Addidng the cells to the field.
		populateField(cells, targetCellXYAndGenerations[0], targetCellXYAndGenerations[1]);

		// Find all cell's neighbours
		this.fieldService.getAllCells().forEach(c -> {
			this.cellService.addNeighbours(c.getX(), c.getY());
		});

		// Collection containing the cells that will be changed for the next generation.
		Set<Cell> forSwap = new HashSet<>();

		while (generations != 0) {

			// Adding all cells that meet the conditions for swaping their color.
			forSwap.addAll(this.fieldService.getAllCells().stream()
					.filter(c -> this.cellService.isForSwap(c.getX(), c.getY())).collect(Collectors.toSet()));

			// If the collection is empty that means no cells for swap so the program ends
			if (forSwap.isEmpty()) {

				// If the target cells is green when the collection is empty that measn that the
				// target cell will still left green fo the rest of the generations.
				if (this.fieldService.getTargetCell().getColor() == 1) {
					this.fieldService.getTargetCell()
							.setTimesBeingGreen(this.fieldService.getTargetCell().getTimesBeingGreen() + generations);
				}

				break;
			}

			// Changing the color of all cells in the collection.
			forSwap.forEach(c -> this.cellService.swapColor(c.getX(), c.getY()));

			// Clear the collection to prepare it for the next generation.
			forSwap.clear();

			// Increase the target cell's times being green by 1.
			if (this.fieldService.getTargetCell().getColor() == 1) {
				this.fieldService.getTargetCell()
						.setTimesBeingGreen(this.fieldService.getTargetCell().getTimesBeingGreen() + 1);
			}

			generations--;
		}

		// Prints how many times the target cell was green.
		OutputWriter.printLine(this.fieldService.getTargetCell().getTimesBeingGreen());
	}
}
