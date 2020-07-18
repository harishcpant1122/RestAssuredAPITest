package api.pojo.place;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import core.api.GetAPITestData;

public class AddPlaceBuilder extends GetAPITestData
{
	Properties data=GetAPITestData.getAPITestData("Place");
	public AddPlace AddPlacePayload(String name, String language, String address)
	{
	
		AddPlace postPayload=new AddPlace();
		AddPlace_location l=new AddPlace_location();
			l.setLat(-38.383494);
			l.setLng(33.427362);
		postPayload.setLocation(l);
		postPayload.setAccuracy(50);
		postPayload.setName(data.getProperty(name));
		postPayload.setPhone_number("(+91) 983 893 3937");
		postPayload.setAddress(data.getProperty(address));
		List<String> myList=new ArrayList<String>();
			myList.add("shoe park");
			myList.add("shop");
		postPayload.setTypes(myList);
		postPayload.setWebsite("http://google.com");
		postPayload.setLanguage(data.getProperty(language));
		
		return postPayload;
	}
}


 class AddPlace 
 {
	private AddPlace_location location;
	private int accuracy;
	private String name;
	private String phone_number;
	private String address;
	private List<String> types;
	private String website;
	private String language;

	public AddPlace() {
		// TODO Auto-generated constructor stub
	}
	public AddPlace_location getLocation() {
		return location;
	}
	public void setLocation(AddPlace_location location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
 
 class AddPlace_location {
		
		private double lat;
		private double lng;
		
		public double getLat() {
			return lat;
		}
		public void setLat(double lat) {
			this.lat = lat;
		}
		public double getLng() {
			return lng;
		}
		public void setLng(double lng) {
			this.lng = lng;
		}
	}

