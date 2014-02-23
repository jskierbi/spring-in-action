package norbsoft.sia01;

public class Juggler implements Performer{

	private int beanBags = 3;

	public Juggler() {

	}

	public Juggler (int beanBags) {

		this.beanBags = beanBags;
	}

	@Override public void doPerform() throws PerformanceException {

		System.out.println("Juggling " + beanBags + " bags!");
	}
}