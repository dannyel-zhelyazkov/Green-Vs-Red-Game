package io.devjun.greenvsred.models;

public class TargetCell extends Cell {

	private static TargetCell instance;
	private int timesBeingGreen;

	public static TargetCell init(int color, int x, int y) {
		if (instance == null) {
			return new TargetCell(color, x, y);
		}

		return instance;
	}

	private TargetCell(int color, int x, int y) {
		super(color, x, y);
		this.timesBeingGreen = 0;
	}

	public int getTimesBeingGreen() {
		return timesBeingGreen;
	}

	public void setTimesBeingGreen(int timesBeingGreen) {
		this.timesBeingGreen = timesBeingGreen;
	}
}
