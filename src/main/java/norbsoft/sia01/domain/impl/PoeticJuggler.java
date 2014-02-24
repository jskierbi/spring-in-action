package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.PerformanceException;
import norbsoft.sia01.domain.Poem;

/**
 * Created by jakub on 02/22/2014.
 */
public class PoeticJuggler extends Juggler {

	Poem poem;

	public PoeticJuggler(int beanBags) {

		super(beanBags);
	}

	public PoeticJuggler(int beanBags, Poem poem) {

		super(beanBags);
		this.poem = poem;
	}

	@Override public void doPerform() throws PerformanceException {

		super.doPerform();

		if (poem != null) {
			System.out.println("During juggling, reciting:");
			poem.recite();
		} else {
			System.out.print("Cannot remember any poem, just juggling...");
		}
	}
}
