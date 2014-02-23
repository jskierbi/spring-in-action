package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.PerformanceException;
import norbsoft.sia01.domain.Performer;

public class Juggler implements Performer {

	private int beanBags = 3;

	public Juggler() {

	}

	public Juggler (int beanBags) {

		this.beanBags = beanBags;
	}

	@Override public void doPerform() throws PerformanceException {

		System.out.println("Juggling " + beanBags + " bags!");
	}
}
