package automobile.util.converter;


import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonStringConverter {
	public static String getJSONString(String name, Object object) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		StringBuilder re = new StringBuilder();
		re.append("{\"")
		.append(name).append("\":").append(mapper.writeValueAsString(object)).append("}");
		return re.toString();
    }
}
