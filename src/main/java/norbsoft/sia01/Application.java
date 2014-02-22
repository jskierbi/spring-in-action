package norbsoft.sia01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		Performer performer = (Performer) context.getBean("duke");
		Performer poemPerformer = (Performer) context.getBean("poeticDuke");
		Performer poemPerformer2 = (Performer) context.getBean("poeticDuke2");

		try {
			performer.doPerform();
			poemPerformer.doPerform();
			poemPerformer2.doPerform();
		} catch (PerformanceException e) {
			e.printStackTrace();
		}
	}
}
