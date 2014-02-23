package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.Instrument;

public class Saxophone implements Instrument {

	@Override public void play() {

		System.out.println("Toot toot toot");
	}
}
