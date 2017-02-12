package automobile.business.entities.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.GarageDetail;

/**
 * @author CrazeWong
 * 
 * key关系
 * bigClass - smallClasses
 * smallClass - 
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
public class JsonObject {
	
	@JsonIgnore
	private String name = null;
	
	private Object object = null;
	
	
	public JsonObject(final String name, final Object object) {
		this.name = name;
		this.object = object;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}
	
	
	@JsonIgnore
	public String getJsonString() throws Exception{
		if (object instanceof GarageDetail || object instanceof AutoMakerDetail) {
			return getFullJsonString();
		} else {
			return getKeyJsonString();
		}
    }
	
	@JsonIgnore
	public String getKeyJsonString() throws Exception {
		return new ObjectMapper().writeValueAsString(this).replaceFirst("object", name);
	}
	
	@JsonIgnore
	public String getFullJsonString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		builder.append(name);
		builder.append("\":\"");
		builder.append(object.toString());
		builder.append("\"}");
		return builder.toString();
	}


}
