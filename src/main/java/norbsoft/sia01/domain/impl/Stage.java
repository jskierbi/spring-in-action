package norbsoft.sia01.domain.impl;

public class Stage {

	private static class StageSingletonHolder {

		static Stage instance = new Stage();
	}

	public static Stage getInstance() {

		return StageSingletonHolder.instance;
	}

	public void curtainsUp() {

		System.out.println("STAGE: Curtains up!");
	}

	public void curtainsDown() {

		System.out.println("STAGE: Curtains down!");
	}
}
