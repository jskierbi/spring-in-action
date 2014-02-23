package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.Instrument;
import norbsoft.sia01.domain.PerformanceException;
import norbsoft.sia01.domain.Performer;

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
