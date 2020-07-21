package io.devjun.greenvsred.service;

import java.util.stream.Collectors;

import io.devjun.greenvsred.models.Cell;
import io.devjun.greenvsred.models.TargetCell;

public class CellServiceImpl implements CellService {

	private final FieldService fieldService;

	public CellServiceImpl(FieldService fieldService) {
		this.fieldService = fieldService;
	}

	@Override
	public Cell createCell(int color, int x, int y) {
		return new Cell(color, x, y);
	}

	@Override
	public TargetCell createTargetCell(int color, int x, int y) {
		return TargetCell.init(color, x, y);
	}
	
	@Override
	public void addNeighbours(int x, int y) {
		this.fieldService.getCell(x, y).setNeighbours(this.fieldService.getAllCells().stream().filter(c -> {
			return (c.getX() == x && c.getY() == y - 1) || (c.getX() == x && c.getY() == y + 1)
					|| (c.getX() == x - 1 && c.getY() == y) || (c.getX() == x + 1 && c.getY() == y)
					|| (c.getX() == x - 1 && c.getY() == y - 1) || (c.getX() == x - 1 && c.getY() == y + 1)
					|| (c.getX() == x + 1 && c.getY() == y - 1) || (c.getX() == x + 1 && c.getY() == y + 1);
		}).collect(Collectors.toList()));
	}

	@Override
	public boolean isForSwap(int x, int y) {
		int sum = this.fieldService.getCell(x, y).getNeighbours().stream().filter(c -> c != null)
				.collect(Collectors.summingInt(Cell::getColor));

		if (this.fieldService.getCell(x, y).getColor() == 0) {
			if (sum == 3 || sum == 6) {
				return true;
			}
		} else {
			if (sum != 2 && sum != 3 && sum != 6) {
				return true;
			}
		}

		return false;

	}

	@Override
	public void swapColor(int x, int y) {
		int color = this.fieldService.getCell(x, y).getColor() == 1 ? 0 : 1;
		this.fieldService.getCell(x, y).setColor(color);
	}
}
