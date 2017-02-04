package automobile.business.entities.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.GarageDetail;

public class JsonManager {
	
	public static String getJSONString(String name, Object object) throws Exception{
		StringBuilder re = new StringBuilder();
		if (object instanceof GarageDetail || object instanceof AutoMakerDetail) {
			// json方法，有key字段
			re.append("{\"")
			.append(name).append("\":")
			.append(object.toString()).append("}");
		} else {
			// toString方法，有full字段
			re.append("{\"")
			.append(name).append("\":")
			.append(new ObjectMapper().writeValueAsString(object)).append("}");
		}
		
		return re.toString();
    }

}
