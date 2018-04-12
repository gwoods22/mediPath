package data_mangement;

import java.util.*;
/**
 * Processing Class that handles the request
 * @author Graeme Woods
 */
public class Processor {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	/**
	 * Processor
	 * Reads data from parameters passed in fom the IO file and then
	 * calls the ShortPath algorithm to return the resulting hospitals
	 * formatted in html ready to be displayed on the Java Server Page.
	 * 
	 * @param surgery - full surgery name
	 * @param address - address of user
	 * @param zipcode - zipcode of user
	 * @return Returns the list of hospitals
	 */
	public List process(String surgery, String address, String zipcode) {
		List content = new ArrayList();
		int surg = Integer.parseInt(surgery.substring(0, 3));
		String result = ClientCode.ShortPath(surg, address, zipcode);
		content.add(result);
//		content.add(surgery + "<br>" + address  + "<br>" +  zipcode);
		return content;
	}
}