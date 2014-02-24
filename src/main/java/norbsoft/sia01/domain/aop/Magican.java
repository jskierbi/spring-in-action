package norbsoft.sia01.domain.aop;

import org.springframework.stereotype.Component;

@Component
public class Magican {

	public void readThoughts(String thoughts) {

		System.out.println("Magician: reaing thoughts! " + thoughts);
	}
}
