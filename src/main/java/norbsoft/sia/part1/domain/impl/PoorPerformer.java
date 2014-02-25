package norbsoft.sia.part1.domain.impl;

import norbsoft.sia.part1.domain.PerformanceException;
import norbsoft.sia.part1.domain.Performer;
import org.springframework.stereotype.Component;

@Component
public class PoorPerformer implements Performer {

	@Override public void doPerform() throws PerformanceException {

		throw new PerformanceException();
	}
}
