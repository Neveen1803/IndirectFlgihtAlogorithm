package Main;

import java.util.ArrayList;
import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import FlightDetails.Flight;
import FlightDetails.FromToDetails;

public class MainMethod {
	
	public static void main(String[] args) {
		FromToDetails obj=new FromToDetails();
		List<Flight> arr=obj.getFlightInfo();
		System.out.println(arr);
		Scanner sc=new Scanner(System.in);
		MainMethod mainobj=new MainMethod();
		System.out.println("Enter the departure");
		String Departure=sc.nextLine();
		System.out.println("Enter the Arrival");
		String Arrival=sc.nextLine();
		Flight flight=new Flight();
		List<List<Flight>> FlightArray=flight.GetConnectingFlight(arr, Departure, Arrival);
		for(List<Flight> flightArray:FlightArray) {
			for(Flight flightobj:flightArray) {
				System.out.print(flightobj+" ->");
			}
			System.out.println();
		}
//		System.out.println(mainobj.ConnectingFlight(arr,Departure,Arrival,2));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	Set<Flight> TotalFlight=new LinkedHashSet<Flight>();
//	
//	public Set<Flight> searchFlight(List<Flight> flightarr,String Dep,String Arr) {
//		Set<Flight> list=new LinkedHashSet<Flight>();
//		if(Dep.equals(Arr)) {
//			
//	
//			list.addAll(DepDetails);
//			Collections.reverse(ArrDetails);
//			list.addAll(ArrDetails); 
//			return list;
//		}
//		String Departure="";
//		String Arrival="";
//		for(int i=0;i<flightarr.size();i++) {
//			for(int j=0;j<flightarr.size();j++) {
//			if(flightarr.get(i).getDeparture().equals(Dep) && flightarr.get(i).getArrival().equals(flightarr.get(j).getDeparture()) && !DepDetails.contains(flightarr.get(i))) {
//				DepDetails.add(flightarr.get(i));
//				Departure=flightarr.get(i).getArrival();
//			}
//			else if(flightarr.get(i).getArrival().equals(Arr) && flightarr.get(i).getDeparture().equals(flightarr.get(j).getArrival()) && !ArrDetails.contains(flightarr.get(i))) {
//				ArrDetails.add(flightarr.get(i));
//				Arrival=(flightarr.get(i).getDeparture());
//	
//			}
//			}
//		}
//		TotalFlight.addAll(DepDetails);
//		TotalFlight.addAll(ArrDetails);		
//			return searchFlight(flightarr, Departure, Arrival);
//	}
//	public boolean checkForDirecrFlight(List<Flight> flightarr,String Dep,String Arr) {
//		for(int i=0;i<flightarr.size();i++) {
//			if(flightarr.get(i).getDeparture().equals(Dep) && flightarr.get(i).getArrival().equals(Arr)) {
//				return true;
//			}
//		}
//		return false;
//	}
		


	}
		

