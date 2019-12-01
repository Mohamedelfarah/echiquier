package com.test.testCegedim;

public class Echiquier {

	private int echiquier[][] = new int[8][8];
	private int tourPositionLine;
	private int tourPositionColumn;

	public void setEnemyPosition(int a, int b) {
		this.echiquier[a][b] = 2;

	}

	public void setFriendPosition(int a, int b) {
		this.echiquier[a][b] = 1;

	}

	public int[][] getEchiquier() {
		return echiquier;
	}

	public void setEchiquier(int[][] echiquier) {
		this.echiquier = echiquier;
	}

	public int getTourPositionLine() {
		return tourPositionLine;
	}

	public void setTourPositionLine(int tourPositionLine) {
		this.tourPositionLine = tourPositionLine;
	}

	public int getTourPositionColumn() {
		return tourPositionColumn;
	}

	public void setTourPositionColumn(int tourPositionColumn) {
		this.tourPositionColumn = tourPositionColumn;
	}

}
