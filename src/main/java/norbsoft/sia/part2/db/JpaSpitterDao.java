package norbsoft.sia.part2.db;

import norbsoft.sia.part2.domain.Spitter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("jpaSpitterDao")
@Transactional
public class JpaSpitterDao implements SpitterDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {

		this.em = em;
	}

	@Override public void addSpitter(Spitter spitter) {

		em.persist(spitter);
	}

	@Override public Spitter getSpitterById(long id) {

		return em.find(Spitter.class, id);
	}

	@Override public void saveSpitter(Spitter spitter) {

		em.merge(spitter);
	}
}