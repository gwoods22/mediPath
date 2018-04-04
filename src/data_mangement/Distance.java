package data_mangement;

import java.io.*;
import java.net.*;
import java.util.*;

public class Distance {
	
	private static double getDistance(String originAddress, String originZip, String destAddress, String destZip ) {
		double distance = 0;
		ArrayList<String> data = getJSON(originAddress, originZip, destAddress, destZip);
		
		int index = 0;
		
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i).length() > 9 && data.get(i).substring(1, 9).equals("distance")) {
				index = i;
				break;
			}
		}
		
		index++;
		int length = data.get(index).length();
		distance = Double.parseDouble(data.get(index).substring(8, length-4).replace(",", ""));
		return distance;
	}

	public static double getDistance(ProviderDataObject start, String destAddress, String destZip) {
		return getDistance(start.getProviderAddress(), start.getProviderZipStr(), destAddress, destZip);
	}
	
	public static double getDistance(ProviderDataObject start, ProviderDataObject dest) {
		return getDistance(start.getProviderAddress(), start.getProviderZipStr(), dest.getProviderAddress(), dest.getProviderZipStr());
	}
	
	public static void setDistances(Iterable<Object> hospitals, String destAddress, String destZip) {
		Iterator<Object> itr = hospitals.iterator();
		while(itr.hasNext()){
			ProviderDataObject temp = (ProviderDataObject) itr.next();
			temp.setDistance(getDistance(temp,destAddress,destZip));
		}
	}

	private static ArrayList<String> getJSON(String originAddress, String originZip, String destAddress, String destZip) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		String data = "ERROR: Data could not be loaded";
		String address;
		
		String[] temp;
		temp = originAddress.split(" ");
		String newOA = temp[0];
		for(int i = 1; i < temp.length; i++) {
			newOA = newOA + "+" + temp[i];
		}
		
		temp = destAddress.split(" ");
		String newDA = temp[0];
		for(int i = 1; i < temp.length; i++) {
			newDA = newDA + "+" + temp[i];
		}
		
		// + "&key=AIzaSyAd6Dl_urDCt6ockL52VaIm1_QC6vcwfuU"
		
		address = "https://maps.googleapis.com/maps/api/directions/json?origin=" + newDA.toLowerCase() + ",+" + destZip + "&destination=" + newOA.toLowerCase() + ",+" + originZip + "&key=AIzaSyAd6Dl_urDCt6ockL52VaIm1_QC6vcwfuU";
		
		try {

			URL url = new URL(address);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			System.out.println("Sending GET request to URL: " + address);
			
			BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while ((line = input.readLine()) != null) {
				result.add(line.replaceAll("\\s+", ""));
			}
			input.close();
			data = result.toString();

		}catch(Exception e) {
			System.out.println(data);
		}

		return result;
	}
}