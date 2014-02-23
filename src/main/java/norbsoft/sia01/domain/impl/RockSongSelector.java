package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.SongSelector;

public class RockSongSelector implements SongSelector {

	private final String[] songs = {
			"Highway to hell", "Sweet home alabama", null
	};

	private int nextSong = 0;

	@Override public String selectSong() {

		return songs[nextSong == songs.length ? (nextSong = 0) : nextSong++];
	}
}
