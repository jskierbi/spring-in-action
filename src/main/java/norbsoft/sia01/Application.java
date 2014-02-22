package norbsoft.sia01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		Performer performer = (Performer) context.getBean("duke");
		Performer poemPerformer = (Performer) context.getBean("poeticDuke");
		Performer poemPerformer2 = (Performer) context.getBean("poeticDuke2");
		Stage stage = (Stage) context.getBean("theStage");

		Ticket ticket1 = (Ticket) context.getBean("ticket");
		Ticket ticket2 = (Ticket) context.getBean("ticket");

		System.out.println("Ticket validation start...");
		try {
			ticket2.validateTicket();
			ticket1.validateTicket();
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
			stage.curtainsDown();
		} catch (PerformanceException e) {
			e.printStackTrace();
		}
	}
}
