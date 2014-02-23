package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.Instrument;
import norbsoft.sia01.domain.PerformanceException;
import norbsoft.sia01.domain.Performer;

import java.util.Map;

public class OneManBandMapBased implements Performer {

	private Map<String, Instrument> instrumentMap;

	@Override public void doPerform() throws PerformanceException {

		System.out.println("=> OneManBand on MAP");
		for (String key : instrumentMap.keySet()) {
			System.out.print(key + ": ");
			instrumentMap.get(key).play();
		}
	}

	public void setInstrumentMap(Map<String, Instrument> instrumentMap) {

		this.instrumentMap = instrumentMap;
	}
}
