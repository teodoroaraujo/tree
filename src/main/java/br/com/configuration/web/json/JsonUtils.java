package br.com.configuration.web.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	
	public static <T> String serialize(T json) {
		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(Include.NON_NULL);
		try {
			return mapper.writeValueAsString(json);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
	
	public static <T> T deserializable(String json, T clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			return (T)mapper.readValue(json, (Class<T>) clazz);
			
		} catch (JsonProcessingException e) {
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
