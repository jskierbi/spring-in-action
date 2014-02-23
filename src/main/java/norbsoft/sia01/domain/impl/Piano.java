package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.Instrument;

/**
 * Created by jakub on 02/23/2014.
 */
public class Piano implements Instrument {

	@Override public void play() {

		System.out.println("Plink plink plink");
	}

	public void onInit() {

		System.out.println("Piano: onInit()");
	}

	public void onDestroy() {

		System.out.println("Piano: onDestroy()");
	}
}
