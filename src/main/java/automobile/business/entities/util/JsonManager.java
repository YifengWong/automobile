package automobile.business.entities.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.GarageDetail;

/**
 * @author CrazeWong
 * 
 * key关系
 * bigClass - smallClasses
 * smallClass - autosmiddles, wantedsmiddle, favorablesmiddle
 * autosmiddle - autoMaker
 * autoMaker - 
 * garage - 
 * discuss - autoMaker, garage
 * msg - autoMaker, garage
 * wantedsmiddle - wanted
 * favorablesmiddle - favorable
 * wanted - garage
 * favorable - automaker
 *
 *
 * full关系
 * bigClass - smallClasses
 * smallClass - 
 * autosmiddle - smallClass
 * autoMaker - autosmiddle
 * discuss - autoMaker, garage
 * garage - 
 * msg - autoMaker, garage
 * wantedsmiddle - smallClass
 * favorablesmiddle - smallClass
 * wanted - garage, wantedsmiddle
 * favorable - autoMaker, favorablesmiddle

 */
public class JsonManager {
	
	public static String getJSONString(String name, Object object) throws Exception{
		StringBuilder re = new StringBuilder();
		if (object instanceof GarageDetail || object instanceof AutoMakerDetail) {
			// full
			re.append("{\"")
			.append(name).append("\":")
			.append(getFullJsonString(object)).append("}");
		} else {
			// key
			re.append("{\"")
			.append(name).append("\":")
			.append(getKeyJsonString(object)).append("}");
		}
		
		return re.toString();
    }
	
	public static String getKeyJsonString(Object object) throws Exception {
		return new ObjectMapper().writeValueAsString(object);
	}
	
	public static String getFullJsonString(Object object) {
		return object.toString();
	}

}
