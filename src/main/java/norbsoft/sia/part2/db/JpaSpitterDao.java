package norbsoft.sia.part2.db;

import norbsoft.sia.part2.domain.Spitter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("jpaSpitterDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class JpaSpitterDao implements SpitterDao {

	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {

		this.em = em;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void addSpitter(Spitter spitter) {

		em.persist(spitter);
		em.flush();
	}

	@Override public Spitter getSpitterById(long id) {

		return em.find(Spitter.class, id);
	}

	@Override public void saveSpitter(Spitter spitter) {

		em.merge(spitter);
	}
}
