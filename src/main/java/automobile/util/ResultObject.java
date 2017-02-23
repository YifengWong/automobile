package automobile.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.GarageDetail;

/**
 * @author CrazeWong
 * 用于表达Controller返回值json内容
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
public class ResultObject {
	
	private String result = null;
	
	private String state = null;
	
	private Object object = null;
	
	
	public ResultObject(final String result, final String state, final Object object) {
		this.result = result;
		this.state = state;
		this.object = object;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
		return new ObjectMapper().writeValueAsString(this);
	}
	
	@JsonIgnore
	public String getFullJsonString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"result\":\"");
		builder.append(result);
		builder.append("\",\"state\":\"");
		builder.append(state);
		builder.append("\",\"object\":");
		builder.append(object.toString());
		builder.append("}");
		return builder.toString();
	}
	
}
