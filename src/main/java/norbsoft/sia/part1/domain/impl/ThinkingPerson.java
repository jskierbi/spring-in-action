package norbsoft.sia.part1.domain.impl;

import norbsoft.sia.part1.domain.ThinkingCreature;
import org.springframework.stereotype.Component;

@Component
public class ThinkingPerson implements ThinkingCreature {

	@Override public void thinkOf(String something) {

		System.out.println("Thinking of: " + something);
	}
}
