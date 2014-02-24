package norbsoft.sia01.domain.aop;

/**
 * Created by jakub on 02/24/2014.
 */
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

}
