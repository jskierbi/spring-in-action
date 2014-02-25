package norbsoft.sia.part1.domain.impl;

import norbsoft.sia.part1.domain.Instrument;
import norbsoft.sia.part1.domain.PerformanceException;
import norbsoft.sia.part1.domain.Performer;

import java.util.Collection;

public class OneManBand implements Performer {

	private Collection<Instrument> instrumentCollection;

	@Override public void doPerform() throws PerformanceException {

		System.out.println("=> One man band!");
		for (Instrument instrument : instrumentCollection) {
			instrument.play();
		}
	}

	public void setInstrumentCollection(Collection<Instrument> instrumentCollection) {

		this.instrumentCollection = instrumentCollection;
	}
}
