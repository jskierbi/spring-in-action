package norbsoft.sia01;

public class Ticket {

	private boolean ticketValidated = false;

	public void validateTicket() throws TicketAlreadyValidatedException {

		if (ticketValidated) {
			throw new TicketAlreadyValidatedException();
		}

		ticketValidated = true;
	}

	public boolean isTicketValidated() {

		return ticketValidated;
	}
}
