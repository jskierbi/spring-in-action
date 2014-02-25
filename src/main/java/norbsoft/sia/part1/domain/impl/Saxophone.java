package norbsoft.sia.part1.domain.impl;

import norbsoft.sia.part1.domain.Instrument;

public class Saxophone implements Instrument {

	@Override public void play() {

		System.out.println("Toot toot toot");
	}
}
