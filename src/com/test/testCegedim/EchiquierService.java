package com.test.testCegedim;

import java.util.List;

public class EchiquierService {

	public void generatePossibleCoup(List<String> validCoup, Echiquier echiquier) {
		iterateOnTourPositionColumn(echiquier.getEchiquier(), echiquier.getTourPositionLine(),
				echiquier.getTourPositionColumn(), validCoup);

		iterateOnTourPositionLine(echiquier.getEchiquier(), echiquier.getTourPositionLine(),
				echiquier.getTourPositionColumn(), validCoup);

	}

	private void iterateOnTourPositionLine(int[][] echiqier, int currentPositionLine, int currentPositionColumn,
			List<String> validCoup) {
		iterateOnTourPositionRight(echiqier, currentPositionLine, currentPositionColumn, validCoup);

		iterateOnTourPositionLeft(echiqier, currentPositionLine, currentPositionColumn, validCoup);
	}

	private void iterateOnTourPositionColumn(int[][] echiqier, int currentPositionLine, int currentPositionColumn,
			List<String> validCoup) {
		iterateTourPositionBelow(echiqier, currentPositionLine, currentPositionColumn, validCoup);
		iterateTourPositionOver(echiqier, currentPositionLine, currentPositionColumn, validCoup);

	}

	private void iterateTourPositionBelow(int[][] echiqier, int currentPositionLine, int currentPositionColumn,
			List<String> validCoup) {
		int i;
		i = checkOfEnemyAndFriendsAndAddEnemyPostionAsValidCoupForBelowPositions(echiqier, currentPositionLine,
				currentPositionColumn, validCoup);
		addOtherPositionAsValidCoupForBelowPositions(currentPositionLine, currentPositionColumn, validCoup, i);
	}

	private void iterateOnTourPositionRight(int[][] echiqier, int currentPositionLine, int currentPositionColumn,
			List<String> validCoup) {
		int j;
		j = checkOfEnemyAndFriendPieceAndAddEnemyPostionAsValidCoupForRightPositions(echiqier, currentPositionLine,
				currentPositionColumn, validCoup);

		addOtherPositionAsValidCoupForRightPositions(currentPositionLine, currentPositionColumn, validCoup, j);
	}

	private void iterateTourPositionOver(int[][] echiqier, int currentPositionLine, int currentPositionColumn,
			List<String> validCoup) {
		int i;
		i = checkOfEnemyAndFiendsPositionsAndAddEnemyPostionAsValidCoupForOverPositions(echiqier, currentPositionLine,
				currentPositionColumn, validCoup);
		addOtherPositionsAsValidCoupForOverPositions(currentPositionLine, currentPositionColumn, validCoup, i);
	}

	private void iterateOnTourPositionLeft(int[][] echiqier, int currentPositionLine, int currentPositionColumn,
			List<String> validCoup) {
		int j;
		j = checkOfEnemyAndFriendsPositionsAndAddEnemyPostionAsValidCoupForLeftPosition(echiqier, currentPositionLine,
				currentPositionColumn, validCoup);

		addOtherPositionAsValidCoupForLeftPositions(currentPositionLine, currentPositionColumn, validCoup, j);
	}

	private int checkOfEnemyAndFriendsAndAddEnemyPostionAsValidCoupForBelowPositions(int[][] echiqier,
			int currentPositionLine, int currentPositionColumn, List<String> validCoup) {
		int i;
		for (i = currentPositionLine - 1; 0 <= i; i--) {

			if (echiqier[i][currentPositionColumn] == 2) {
				validCoup.add("T" + mapToCorrespondentLetter(currentPositionColumn) + "" + (currentPositionLine) + "x"
						+ mapToCorrespondentLetter(currentPositionColumn) + "" + (i + 1));

				break;
			}

			if (echiqier[i][currentPositionColumn] == 1) {

				break;
			}

		}
		return i;
	}

	private int checkOfEnemyAndFriendPieceAndAddEnemyPostionAsValidCoupForRightPositions(int[][] echiqier,
			int currentPositionLine, int currentPositionColumn, List<String> validCoup) {
		int j;
		for (j = currentPositionColumn + 1; j < 8; j++) {

			if (echiqier[currentPositionLine][j] == 2) {
				validCoup.add("T" + mapToCorrespondentLetter(currentPositionColumn) + "" + (currentPositionLine + 1)
						+ "x" + mapToCorrespondentLetter(j) + "" + (currentPositionLine + 1));

				break;
			}
			if (echiqier[currentPositionLine][j] == 1) {

				break;
			}
		}
		return j;
	}

	private int checkOfEnemyAndFiendsPositionsAndAddEnemyPostionAsValidCoupForOverPositions(int[][] echiqier,
			int currentPositionLine, int currentPositionColumn, List<String> validCoup) {
		int i;
		for (i = currentPositionLine + 1; i < 8; i++) {

			if (echiqier[i][currentPositionColumn] == 2) {
				validCoup.add("T" + mapToCorrespondentLetter(currentPositionColumn) + "" + (currentPositionLine + 1)
						+ "x" + mapToCorrespondentLetter(currentPositionColumn) + "" + (i + 1));

				break;
			}
			if (echiqier[i][currentPositionColumn] == 1) {

				break;
			}
		}
		return i;
	}

	private int checkOfEnemyAndFriendsPositionsAndAddEnemyPostionAsValidCoupForLeftPosition(int[][] echiqier,
			int currentPositionLine, int currentPositionColumn, List<String> validCoup) {
		int j;
		for (j = currentPositionColumn - 1; 0 <= j; j--) {

			if (echiqier[currentPositionLine][j] == 2) {
				validCoup.add("T" + mapToCorrespondentLetter(currentPositionColumn) + "" + (currentPositionLine + 1)
						+ "x" + mapToCorrespondentLetter(j) + "" + (currentPositionLine + 1));

				break;
			}

			if (echiqier[currentPositionLine][j] == 1) {

				break;
			}

		}
		return j;
	}

	private void addOtherPositionsAsValidCoupForOverPositions(int currentPositionLine, int currentPositionColumn,
			List<String> validCoup, int i) {
		int s;
		for (s = currentPositionLine + 1; s < i; s++) {
			validCoup.add("T" + mapToCorrespondentLetter(currentPositionColumn) + "" + (currentPositionLine + 1) + "-"
					+ mapToCorrespondentLetter(currentPositionColumn) + "" + (s + 1));
		}
	}

	private void addOtherPositionAsValidCoupForBelowPositions(int currentPositionLine, int currentPositionColumn,
			List<String> validCoup, int i) {
		int s;
		for (s = currentPositionLine - 1; i < s; s--) {

			validCoup.add("T" + mapToCorrespondentLetter(currentPositionColumn) + "" + (currentPositionLine + 1) + "-"
					+ mapToCorrespondentLetter(currentPositionColumn) + "" + (s + 1));

		}
	}

	private void addOtherPositionAsValidCoupForRightPositions(int currentPositionLine, int currentPositionColumn,
			List<String> validCoup, int j) {
		int t;
		for (t = currentPositionColumn + 1; t < j; t++) {
			validCoup.add("T" + mapToCorrespondentLetter(currentPositionColumn) + "" + (currentPositionLine + 1) + "-"
					+ mapToCorrespondentLetter(t) + "" + (currentPositionLine + 1));
		}
	}

	private void addOtherPositionAsValidCoupForLeftPositions(int currentPositionLine, int currentPositionColumn,
			List<String> validCoup, int j) {
		int t;
		for (t = currentPositionColumn - 1; j < t; t--) {

			validCoup.add("T" + mapToCorrespondentLetter(currentPositionColumn) + "" + (currentPositionLine + 1) + "-"
					+ mapToCorrespondentLetter(t) + "" + (currentPositionLine + 1));

		}
	}

	private char mapToCorrespondentLetter(int a) {
		char result = '\0';
		switch (a) {

		case 0:
			result = 'a';
			break;
		case 1:
			result = 'b';
			break;
		case 2:
			result = 'c';
			break;
		case 3:
			result = 'd';
			break;
		case 4:
			result = 'e';
			break;
		case 5:
			result = 'f';
			break;
		case 6:
			result = 'g';
			break;

		case 7:
			result = 'h';
			break;
		}
		return result;
	}

}
