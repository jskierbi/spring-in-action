package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.Instrument;
import org.springframework.stereotype.Component;

@Component("guitar")
public class Guitar implements Instrument {

	@Override public void play() {

		System.out.println("Riff riff riff");
	}
}
