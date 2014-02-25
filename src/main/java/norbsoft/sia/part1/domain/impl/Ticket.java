package norbsoft.sia.part1.domain.impl;

import norbsoft.sia.part1.domain.TicketAlreadyValidatedException;

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
