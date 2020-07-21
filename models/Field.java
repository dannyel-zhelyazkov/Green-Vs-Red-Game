package io.devjun.greenvsred.models;

import java.util.ArrayList;
import java.util.List;

import io.devjun.greenvsred.consts.GameConstants;

public class Field {
	private static Field instance;
	private int width;
	private int height;
	private List<Cell> cells;
	private TargetCell targetCell;
	
	public static Field init() {
		if(instance == null) {
			return new Field();
		}
		
		return instance;
	}
	
	private Field() {
		this.cells = new ArrayList<>();
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width > GameConstants.FIELD_MAX_HEIGHT_AND_WIDTH || width <= 0 || width > this.height) {
			throw new IllegalArgumentException(GameConstants.INVALID_FIELD_WIDTH);
		}

		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height > GameConstants.FIELD_MAX_HEIGHT_AND_WIDTH || height <= 0) {
			throw new IllegalArgumentException(GameConstants.INVALID_FILED_HEIGHT);
		}

		this.height = height;
	}
	
	public List<Cell> getCells() {
		return this.cells;
	}
	
	public TargetCell getTargetCell() {
		return targetCell;
	}
	
	public void setTargetCell(TargetCell targetCell) {
		this.targetCell = targetCell;
	}
}
