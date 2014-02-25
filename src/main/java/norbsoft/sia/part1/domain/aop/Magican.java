package norbsoft.sia.part1.domain.aop;

import norbsoft.sia.part1.domain.IntroducedInterface;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Magican {

	@DeclareParents(
			value = "norbsoft.sia.part1.domain.ThinkingCreature+", // classes that are instaceof ThinkingCreature will be introduced
			defaultImpl = IntroducedImpl.class) //Which implementaiton to introduce
	public static IntroducedInterface introducedInterface; // Which interface will be introduced

	@Pointcut("execution(* norbsoft.sia.part1.domain.ThinkingCreature.thinkOf(String))" +
			"&& args(thoughts)")
	public void thinking(String thoughts) {

	}

	@After("thinking(thoughts)")
	public void readThoughts(String thoughts) {

		System.out.println("Magician: reaing thoughts! " + thoughts);
	}
}
