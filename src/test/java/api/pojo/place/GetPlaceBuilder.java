package api.pojo.place;

import java.util.Properties;

import core.api.GetAPITestData;

public class GetPlaceBuilder extends GetAPITestData {

	Properties data=GetAPITestData.getAPITestData("Place");
	public String GetData(String key)
	{
		return data.getProperty(key);
	}

}
