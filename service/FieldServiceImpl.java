package io.devjun.greenvsred.service;

import java.util.List;

import io.devjun.greenvsred.consts.GameConstants;
import io.devjun.greenvsred.models.Cell;
import io.devjun.greenvsred.models.Field;
import io.devjun.greenvsred.models.TargetCell;

public class FieldServiceImpl implements FieldService {

	private Field field;

	public FieldServiceImpl() {
		this.field = Field.getInstance();
	}

	@Override
	public void init(int width, int height) {
		this.field.setHeight(height);
		this.field.setWidth(width);
	}

	@Override
	public void addCell(Cell cell) {
		this.field.getCells().add(cell);
	}

	private void validateTargetCellXY(int x, int y) {
		if (x < 0 || x >= this.field.getWidth()) {
			throw new IllegalArgumentException(GameConstants.IVALID_TARGET_CELL_X_COORDINATE);
		} else if (y < 0 || y >= this.field.getHeight()) {
			throw new IllegalArgumentException(GameConstants.IVALID_TARGET_CELL_Y_COORDINATE);
		}
	}

	@Override
	public void addTargetCell(TargetCell targetCell) {

		validateTargetCellXY(targetCell.getX(), targetCell.getY());

		this.field.setTargetCell(targetCell);

		this.field.getCells().add(targetCell);
	}

	@Override
	public Cell getCell(int x, int y) {
		return this.field.getCells().get(x * this.field.getWidth() + y);
	}

	@Override
	public TargetCell getTargetCell() {
		return this.field.getTargetCell();
	}

	@Override
	public List<Cell> getAllCells() {
		return this.field.getCells();
	}
}
