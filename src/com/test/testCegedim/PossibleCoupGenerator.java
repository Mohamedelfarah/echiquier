package com.test.testCegedim;

import java.util.ArrayList;
import java.util.List;

public class PossibleCoupGenerator {

	public static void main(String[] args) {
		List<String> validCoup = new ArrayList<>();
		EchiquierService echiquierService = new EchiquierService();

		Echiquier echiquier = new Echiquier();
		echiquier.setTourPositionLine(4);
		echiquier.setTourPositionColumn(3);
		echiquier.setEnemyPosition(6, 3);
		echiquier.setFriendPosition(1, 3);
		echiquier.setFriendPosition(4, 6);
		echiquierService.generatePossibleCoup(validCoup, echiquier);
		System.out.print(validCoup.toString());

	}

}
