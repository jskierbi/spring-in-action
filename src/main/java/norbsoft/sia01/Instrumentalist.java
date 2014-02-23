package norbsoft.sia01;

public class Instrumentalist implements Performer {

	private Instrument instrument;
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
