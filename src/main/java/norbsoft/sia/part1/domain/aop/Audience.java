package norbsoft.sia.part1.domain.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("audience")
@Aspect
public class Audience {

	@Pointcut("execution (* norbsoft.sia.part1.domain.Performer.doPerform(..))")
	public void performance() {

	}

	@Before("performance()")
	public void takeSeats() {

		System.out.println("The audience is taking seats");
	}

	@Before("performance()")
	public void turnOffCellPhones() {

		System.out.println("The audience is turning off their cellphones");
	}

	@AfterReturning("performance()")
	public void applaud() {

		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	@AfterThrowing("performance()")
	public void demandRefund() {

		System.out.println("Boo! We want our money back!");
	}

	@Around("performance()")
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
