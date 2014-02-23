package norbsoft.sia01;

import norbsoft.sia01.domain.PerformanceException;
import norbsoft.sia01.domain.Performer;
import norbsoft.sia01.domain.TicketAlreadyValidatedException;
import norbsoft.sia01.domain.impl.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		// domainStatic();
		domainSpel();
	}

	private static void domainStatic() {

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		Performer performer = (Performer) context.getBean("duke");
		Performer poemPerformer = (Performer) context.getBean("poeticDuke");
		Performer poemPerformer2 = (Performer) context.getBean("poeticDuke2");
		Performer instumentalistKenny = (Performer) context.getBean("kenny");
		Performer multiInstrumentalist = (Performer) context.getBean("hank");
		Performer hankMap = (Performer) context.getBean("hankMap");
		Performer propPerf = (Performer) context.getBean("propsPerformer");
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
			instumentalistKenny.doPerform();
			multiInstrumentalist.doPerform();
			hankMap.doPerform();
			propPerf.doPerform();
			stage.curtainsDown();
		} catch (PerformanceException e) {
			e.printStackTrace();
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
}
