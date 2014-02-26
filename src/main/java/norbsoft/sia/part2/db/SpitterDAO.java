package norbsoft.sia.part2.db;

import norbsoft.sia.part2.domain.Spitter;

public interface SpitterDao {

	public void addSpitter(Spitter spitter);

	public Spitter getSpitterById(long id);

	public void saveSpitter(Spitter spitter);
}
