package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.ThinkingCreature;
import org.springframework.stereotype.Component;

@Component
public class ThinkingPerson implements ThinkingCreature {

	@Override public void thinkOf(String something) {

		System.out.println("Thinking of: " + something);
	}
}
