package com.example.signlanguageconverter;

import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Database {

	//multithreading shouldn't be necessary but just in case
	private ConcurrentHashMap<String,String> data = new ConcurrentHashMap<>();


	public String add(String text) {
		AbstractMap.SimpleEntry<String ,String> entry = getEntry(text);
		if(entry != null){
			data.put(entry.getKey(),entry.getValue());
			return entry.getKey() + " -> " + entry.getValue();
		}
		return null;
	}

	public void clear() {
		data.clear();
	}
	// https://teckensprakslexikon.su.se/sok/idnummer?q=08028%2C04748%2C00529%2C02238%2C00179%2C11320%2C00857%2C03591
	public String getLexicon() {
		if(data.isEmpty()) return null;
		StringBuilder builder = new StringBuilder();
		builder.append("https://teckensprakslexikon.su.se/sok/idnummer?q=");
		for(String value: data.values()){
			builder.append(value).append("%2C");
		}
		return builder.toString();
	}

	public String getImportText() {
		if(data.isEmpty()) return null;
		StringBuilder builder = new StringBuilder();
		builder.append("{\"name\":\"nameOfQuiz\",\"list\":[");
		for(String value : data.values()){
			builder.append("\"").append(value).append("\"");
		}
		builder.append("]}");
		return builder.toString();
	}

	public String remove(String text) {
		AbstractMap.SimpleEntry<String ,String> entry = getEntry(text);
		if(entry != null && data.containsKey(entry.getKey())){
			data.remove(entry.getKey());
			return mapText();
		}
		return null;
	}

	private String mapText() {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, String> entry: data.entrySet()) {
			builder.append(entry.getKey()).append(" -> ").append(entry.getValue());
		}
		return builder.toString();
	}

	private AbstractMap.SimpleEntry<String,String> getEntry(String inputlink){
		//todo
		return null;
	}
}
