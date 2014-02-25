package norbsoft.sia.part2;

import norbsoft.sia.part2.db.DBConfig;
import norbsoft.sia.part2.db.SpitterDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Part2Main {

	public static void runPart2() {

		ApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		// DataSource basicDataSource = context.getBean(BasicDataSource.class);
		SpitterDAO dao = (SpitterDAO) context.getBean("jdbcSpitterDAO");

		System.out.println("Basic data source created ok!");
	}
}
