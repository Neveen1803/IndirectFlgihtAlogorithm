package FlightDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FromToDetails {
	 String Departure;
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
	String Arrival;
	public FromToDetails(String departure, String arrival) {
		super();
		Departure = departure;
		Arrival = arrival;
	}
	public FromToDetails() {
	}
	public List<Flight> getFlightInfo() {
		List<Flight> flightArray=new ArrayList<Flight>();
		Connection con=dbconnection.getDBConnection();
		try {
			PreparedStatement psmt=con.prepareStatement("select * from Flights");
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				Flight flight=new Flight(rs.getString(1),rs.getString(3),rs.getString(4),rs.getTime(5),rs.getTime(6),rs.getDouble(8));
				flightArray.add(flight);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flightArray;
	}
}
