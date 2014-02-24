package norbsoft.sia01;

import norbsoft.sia01.domain.PerformanceException;
import norbsoft.sia01.domain.Performer;
import norbsoft.sia01.domain.TicketAlreadyValidatedException;
import norbsoft.sia01.domain.impl.Instrumentalist;
import norbsoft.sia01.domain.impl.PoorPerformer;
import norbsoft.sia01.domain.impl.Stage;
import norbsoft.sia01.domain.impl.Ticket;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		// domainStatic();
		// domainSpel();
		//annotationConfig();

//		// XML based config
//		domainStatic(new ClassPathXmlApplicationContext("SpringConfig.xml"));
//		// XML entrypoint, class based config
//		domainStatic(new ClassPathXmlApplicationContext("AnnotationConfig.xml"));
//		// JAVA only config
//		domainStatic(new AnnotationConfigApplicationContext(Config.class));

		domainStatic(new ClassPathXmlApplicationContext("AspectConfig.xml"));
	}

	private static void domainStatic(ApplicationContext context) {

		Performer performer = (Performer) context.getBean("duke");
		Performer poemPerformer = (Performer) context.getBean("poeticDuke");
		Performer poemPerformer2 = (Performer) context.getBean("poeticDuke2");
		Performer instumentalistKenny = (Performer) context.getBean("kenny");
		Performer multiInstrumentalist = (Performer) context.getBean("hank");
		Performer hankMap = (Performer) context.getBean("hankMap");
		Performer propPerf = (Performer) context.getBean("propsPerformer");
		Performer poorPerformer = (Performer) context.getBean("poorPerformer");
		Stage stage = (Stage) context.getBean("theStage");

		Ticket ticket1 = (Ticket) context.getBean("ticket");
		Ticket ticket2 = (Ticket) context.getBean("ticket");

		System.out.println("Ticket validation start...");
		try {
			ticket1.validateTicket();
			ticket2.validateTicket();
		} catch (TicketAlreadyValidatedException e) {
			System.out.println(">> WARNING: Ticket validation problem...");
		} finally {
			System.out.println("Validation done.");
		}

		try {
			stage.curtainsUp();
			performer.doPerform();
			poemPerformer.doPerform();
			poemPerformer2.doPerform();
			instumentalistKenny.doPerform();
			multiInstrumentalist.doPerform();
			hankMap.doPerform();
			propPerf.doPerform();
			poorPerformer.doPerform();
		} catch (PerformanceException e) {
			e.printStackTrace();
		} finally {
			stage.curtainsDown();
		}
	}

	private static void domainSpel() {

		ApplicationContext context = new ClassPathXmlApplicationContext("SpelConfig.xml");
		Performer kenny = (Performer) context.getBean("kenny");
		Performer carl = (Performer) context.getBean("carl");

		Performer song1 = (Performer) context.getBean("song1");
		Performer song2 = (Performer) context.getBean("song2");
		Performer song3 = (Performer) context.getBean("song3");
		Performer song4 = (Performer) context.getBean("song4");

		try {
			System.out.println("=>>> Kenny:");
			kenny.doPerform();
			System.out.println("=>>> Carl:");
			carl.doPerform();
			System.out.println("=>>> Song1:");
			song1.doPerform();
			System.out.println("=>>> Song2:");
			song2.doPerform();
			System.out.println("=>>> Song3:");
			song3.doPerform();
			System.out.println("=>>> Song4:");
			song4.doPerform();
		} catch (PerformanceException e) {
			e.printStackTrace();
		}
	}

	private static void annotationConfig() {

		ApplicationContext context = new ClassPathXmlApplicationContext("AnnotationConfig.xml");
		Performer juggler = (Performer) context.getBean("namedJuggler");
		Performer instrumentalist = (Performer) context.getBean(Instrumentalist.class);

		try {
			System.out.println("=== JUGGLER PERFORMANCE ===");
			juggler.doPerform();
			System.out.println("=== INSTRUMENTALIST PERFORMANCE ===");
			instrumentalist.doPerform();
		} catch (PerformanceException e) {
			e.printStackTrace();
		}
	}
}
