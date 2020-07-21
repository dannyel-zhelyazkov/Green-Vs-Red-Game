package io.devjun.greenvsred.models;

public class TargetCell extends Cell {
	/* instance of the singleton declaration */
	private volatile static TargetCell INSTANCE;
	
	private int timesBeingGreen;

	/* Access point to the unique instance of the singleton */
	public static TargetCell getInstance(int color, int x, int y) {
		if (INSTANCE == null) {
			synchronized (Field.class) {
				if (INSTANCE == null) {
					INSTANCE = new TargetCell(color, x, y);
				}
			}
		}

		return INSTANCE;
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
