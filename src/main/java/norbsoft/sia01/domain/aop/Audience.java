package norbsoft.sia01.domain.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component("audience")
public class Audience {

	public void takeSeats() {

		System.out.println("The audience is taking seats");
	}

	public void turnOffCellPhones() {

		System.out.println("The audience is turning off their cellphones");
	}

	public void applaud() {

		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	public void demandRefund() {

		System.out.println("Boo! We want our money back!");
	}

	public void watchPerformance(ProceedingJoinPoint jointPoint) {

		try {
			takeSeats();
			turnOffCellPhones();
			jointPoint.proceed();
			applaud();
		} catch (Throwable t) {
			demandRefund();
		}
	}
}
