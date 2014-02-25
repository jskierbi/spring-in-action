package norbsoft.sia.part1.domain.impl;

import norbsoft.sia.part1.domain.Instrument;
import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument {

	@Override public void play() {

		System.out.println("Riff riff riff");
	}
}
