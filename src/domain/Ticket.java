package domain;

public class Ticket {

	private String numTicket;
	private String passport;
	private String numFlight;
	
	public Ticket(String numTicket, String passport, String numFlight) {
		super();
		this.numTicket = numTicket;
		this.passport = passport;
		this.numFlight = numFlight;
	}

	public String getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getNumFlight() {
		return numFlight;
	}

	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}
	
	public boolean availability(String dato) {
		
		return true;
	}
	
	public boolean existTicket(String dato) {
		
		return true;
	}

	@Override
	public String toString() {
		return numTicket + "-" + passport + "-" + numFlight;
	}
	 
	
	}
