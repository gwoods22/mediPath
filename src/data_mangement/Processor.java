package data_mangement;

import java.util.*;

public class Processor {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getBrands(String surgery, String address, String zipcode) {
		List content = new ArrayList();
//		int surg = Integer.parseInt(surgery.substring(0, 3));
//		String result = ClientCode.ShortPath(surg, address, zipcode);
		content.add(surgery + "<br>" + address  + "<br>" +  zipcode);
		return content;
	}
}