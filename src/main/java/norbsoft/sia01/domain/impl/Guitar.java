package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.Instrument;

/**
 * Created by jakub on 02/23/2014.
 */
public class Guitar implements Instrument {

	@Override public void play() {

		System.out.println("Riff riff riff");
	}
}
