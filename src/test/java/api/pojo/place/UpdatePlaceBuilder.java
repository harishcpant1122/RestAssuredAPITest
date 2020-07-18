package api.pojo.place;

import java.util.Properties;

import core.api.GetAPITestData;
public class UpdatePlaceBuilder extends GetAPITestData 
{
	Properties data=GetAPITestData.getAPITestData("Place");
	public UpdatePlace UpdatePlacePayload(String placeId,String updatedAddress,String key)
	{
		UpdatePlace updatePlacePayload=new UpdatePlace();
		updatePlacePayload.setPlace_id(placeId);
		updatePlacePayload.setAddress(data.getProperty(updatedAddress));
		updatePlacePayload.setKey(data.getProperty(key));
		return updatePlacePayload;
	}
}

class UpdatePlace 
{
	private String place_id;
	private String address;
	private String key;
	
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
