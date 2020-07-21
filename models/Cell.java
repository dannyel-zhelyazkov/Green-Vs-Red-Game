package io.devjun.greenvsred.models;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private int color;
	private int x;
	private int y;
	private List<Cell> neighbours;
	
	public Cell(int color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.neighbours = new ArrayList<>();
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public List<Cell> getNeighbours() {
		return neighbours;
	}
	
	public void setNeighbours(List<Cell> neighbours) {
		this.neighbours = neighbours;
	}
}
