package norbsoft.sia.part1.domain.aop;

import norbsoft.sia.part1.domain.IntroducedInterface;

/**
 * Created by jakub on 02/24/2014.
 */
public class IntroducedImpl implements IntroducedInterface {

	@Override public String getValueFromIntroducedMethod() {

		return "Introduced value";
	}
}
