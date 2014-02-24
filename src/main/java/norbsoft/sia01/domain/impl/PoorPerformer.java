package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.PerformanceException;
import norbsoft.sia01.domain.Performer;
import org.springframework.stereotype.Component;

@Component
public class PoorPerformer implements Performer {

	@Override public void doPerform() throws PerformanceException {

		throw new PerformanceException();
	}
}
