package norbsoft.sia01.domain.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Magican {

	@Pointcut("execution(* norbsoft.sia01.domain.ThinkingCreature.thinkOf(String))" +
			"&& args(thoughts)")
	public void thinking(String thoughts) {

	}

	@After("thinking(thoughts)")
	public void readThoughts(String thoughts) {

		System.out.println("Magician: reaing thoughts! " + thoughts);
	}
}
