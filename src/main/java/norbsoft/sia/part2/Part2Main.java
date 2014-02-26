package norbsoft.sia.part2;

import norbsoft.sia.part2.db.JDBCConfig;
import norbsoft.sia.part2.db.JPAConfig;
import norbsoft.sia.part2.db.SpitterDao;
import norbsoft.sia.part2.domain.Spitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Part2Main {

	public static void runPart2() {

		runJPAConnection();
	}

	private static void runJDBCConnection() {

		ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
		// DataSource basicDataSource = context.getBean(BasicDataSource.class);
		SpitterDao dao = (SpitterDao) context.getBean("jdbcSpitterDAO");
		Spitter readObj = dao.getSpitterById(1);

		System.out.println("Read object: " + readObj.getFullName());

		Spitter newSpitter = new Spitter();
		newSpitter.setUsername("NextBigThing");
		newSpitter.setPassword("kkk");
		newSpitter.setFullName("N-?>Big-<<THING");
		newSpitter.setEmail("nbs@mail.com");
		newSpitter.setUpdatedByEmail(false);

		dao.addSpitter(newSpitter);
		System.out.println("New id: " + newSpitter.getId());

		System.out.println("Basic data source created ok!");
	}

	private static void runJPAConnection() {

		ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
		SpitterDao dao = (SpitterDao) context.getBean("jpaSpitterDao");
		Spitter readObj = dao.getSpitterById(1);

		System.out.println("Read object: " + readObj.getFullName());

		Spitter newSpitter = new Spitter();
		newSpitter.setUsername("NextBigThing");
		newSpitter.setPassword("kkk");
		newSpitter.setFullName("N-?>Big-<<THING");
		newSpitter.setEmail("nbs@mail.com");
		newSpitter.setUpdatedByEmail(false);

		dao.addSpitter(newSpitter);
		System.out.println("New id: " + newSpitter.getId());
	}
}
