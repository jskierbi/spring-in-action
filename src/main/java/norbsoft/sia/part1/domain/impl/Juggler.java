package norbsoft.sia.part1.domain.impl;

import norbsoft.sia.part1.domain.PerformanceException;
import norbsoft.sia.part1.domain.Performer;
import org.springframework.stereotype.Component;

@Component
public class Juggler implements Performer {

	private int beanBags = 3;

	public Juggler() {

	}

	public Juggler(int beanBags) {

		this.beanBags = beanBags;
	}

	@Override public void doPerform() throws PerformanceException {

		System.out.println("Juggling " + beanBags + " bags!");
	}
}
