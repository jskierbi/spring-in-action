package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.Instrument;
import norbsoft.sia01.domain.PerformanceException;
import norbsoft.sia01.domain.Performer;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Component
public class Instrumentalist implements Performer {

	@Inject
	@Named("guitar")
	private Instrument instrument;

	@Inject
	@Named("song")
	private String song;

	@Override public void doPerform() throws PerformanceException {

		System.out.println("Playing song: " + song);
		instrument.play();
	}

	public void setInstrument(Instrument instrument) {

		this.instrument = instrument;
	}

	public String screamSong() {

		return song;
	}

	public String getSong() {

		return song;
	}

	public void setSong(String song) {

		this.song = song;
	}
}
