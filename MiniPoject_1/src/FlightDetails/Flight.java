package FlightDetails;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Flight {
	String FlightNumber;
	String Departure;
	String Arrival;
	Time Departure_TIme;
	Time Arrival_Time;
	double Price;
	public Flight(String flightNumber, String departure, String arrival, Time departure_TIme, Time arrival_Time,
			 double price) {
		super();
		FlightNumber = flightNumber;
		Departure = departure;
		Arrival = arrival;
		Departure_TIme = departure_TIme;
		Arrival_Time = arrival_Time;
		Price = price;
	}
	public Flight(String departure,String arrival) {
		Departure = departure;
		Arrival = arrival;
	}
	public Flight() {
		
	}
	public String getFlightNumber() {
		return FlightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		FlightNumber = flightNumber;
	}
	public String getDeparture() {
		return Departure;
	}
	public void setDeparture(String departure) {
		Departure = departure;
	}
	public String getArrival() {
		return Arrival;
	}
	public void setArrival(String arrival) {
		Arrival = arrival;
	}
	public Time getDeparture_TIme() {
		return Departure_TIme;
	}
	public void setDeparture_TIme(Time departure_TIme) {
		Departure_TIme = departure_TIme;
	}
	public Time getArrival_Time() {
		return Arrival_Time;
	}
	public void setArrival_Time(Time arrival_Time) {
		Arrival_Time = arrival_Time;
	}

	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "FlightNumber=" + FlightNumber + ", Departure=" + Departure + ", Arrival=" + Arrival;
//				+ ", Departure_TIme=" + Departure_TIme + ", Arrival_Time=" + Arrival_Time + ", Price=" + Price ;
	}
	public void getFlightInfo(List<Flight> arr,String Dep,String Arr) {
		for(int i=0;i<arr.size();i++) {
			for(int j=0;j<arr.size();j++) {
				if(arr.get(i).getDeparture().equals(Dep) && arr.get(i).getArrival().equals(arr.get(j).getDeparture()) && arr.get(j).getArrival().equals(Arr) && arr.get(i).getArrival_Time().before(arr.get(j).getDeparture_TIme())) {
					System.out.println(arr.get(i)+","+arr.get(j));
				}
			}
		}
	}
	public List<List<Flight>> GetConnectingFlight(List<Flight> AvailableFlight,String Departure,String Arrival){
		List<List<Flight>> flightarr=new ArrayList<>();
		Random rand=new Random();
		int num=rand.nextInt(8);
		for(int i=0;i<num;i++) {
			int num1=rand.nextInt(4);
			flightarr.add(ConnectingFlight(AvailableFlight,Departure,Arrival,num1));
		}
		return flightarr;
		
	}
	
	public List<Flight> ConnectingFlight(List<Flight> AvailableFlight,String Departure,String Arrival,int i){
		List<Flight> FlightOfFlight=new ArrayList<>();
	int a=i;
		List<Flight> DepartureList =new ArrayList<>();
		for(Flight flight1:AvailableFlight) {
			if(flight1.getDeparture().equals(Departure)) {
				DepartureList.add(flight1);
			}
		}
		do {
		Random rand=new Random();
		int num=rand.nextInt(7);
		Departure=DepartureList.get(num).getArrival();
		FlightOfFlight.add(DepartureList.get(num));
		}
		while(Departure==Arrival); 
		i=a;
		a:
		for(Flight flight1:AvailableFlight) {
				if(flight1.getDeparture().equals(Departure) && i>0 && !flight1.getArrival().equals(Arrival)) {
					Departure=flight1.getArrival();
//					System.out.println(flight1);
					FlightOfFlight.add(flight1);
					i--;
				}
				for(Flight flight2:AvailableFlight) {
				if(i==0 && flight2.getArrival().equals(Arrival) && flight2.getDeparture().equals(Departure)) {
//					System.out.println(flight2);
					FlightOfFlight.add(flight2);

					break a;
				}
				}
		}
		return FlightOfFlight;
	}
	
 


}
