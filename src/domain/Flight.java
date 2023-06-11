package domain;


public class Flight {

	private String numFlight;
	private String departureCity;
	private String departureDateTime;
	private String arrivalCity;
	private String arrivalDateTime;
	private String flight;
	private String seat;
	private int amount;
	
	public Flight() {}
	
	public Flight(String numFlight, String departureCity, String departureDateTime, String arrivalCity,
			String arrivalDateTime, String flight, String seat,int amount) {
		super();
		this.numFlight = numFlight;
		this.departureCity = departureCity;
		this.departureDateTime = departureDateTime;
		this.arrivalCity = arrivalCity;
		this.arrivalDateTime = arrivalDateTime;
		this.flight = flight;
		this.seat=seat;
		this.amount = amount;
	}

	public String getNumFlight() {
		//ram numero
		return numFlight;
	}

	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDepartureDateTime() {
		//generar automatico
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(String arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public int getAmount(String typeSeat) {
		if (typeSeat=="Clase Ejecutiva") {
			return 48429;
		}else if (typeSeat=="Clase Turista") {
			return 16143;
		}else {
			return 5381;
		}
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String[] getDataName() {//son mis etiquetas de apertura y cierre
		String[] dataName = {"numFlight","departureCity","departureDateTime",
				"arrivalCity","arrivalDateTime","flight","seat","amount"};
		return dataName;
	}
	public String[] getData() {
		String[] data = {numFlight,departureCity,departureDateTime,
				arrivalCity,arrivalDateTime,flight,seat,String.valueOf(amount)};
		return data;
	}
	@Override
	public String toString() {
		return numFlight + "-" + departureCity + "-"+ departureDateTime + "-" + arrivalCity + "-"
				+ arrivalDateTime+ "-" + flight + "-" + seat + "-" + amount;
	}
	
	
}
