package norbsoft.sia.part2;

import norbsoft.sia.part2.db.DBConfig;
import norbsoft.sia.part2.db.SpitterDAO;
import norbsoft.sia.part2.domain.Spitter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Part2Main {

	public static void runPart2() {

		ApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		// DataSource basicDataSource = context.getBean(BasicDataSource.class);
		SpitterDAO dao = (SpitterDAO) context.getBean("jdbcSpitterDAO");
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
}
