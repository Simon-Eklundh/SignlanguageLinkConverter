package com.example.signlanguageconverter;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Database {

	//multithreading shouldn't be necessary but just in case
	private ConcurrentHashMap<String,String> data = new ConcurrentHashMap<>();


	public String add(String text) {
		if(data.containsKey(text)) return null;
		//semi-recursion
		if(isCodeList(text)) {
			String[] codes = text.split(",");
			StringBuilder builder = new StringBuilder();
			for (String code : codes) {
				String result = add(code);
				if(result != null)
					builder.append(result).append("\n");
			}
			if(builder.isEmpty()) return null;
			return builder.toString();
		}else if(text.contains("q=")){
			String[] codes = text.split("q=")[1].split("%2C");
			StringBuilder builder = new StringBuilder();
			for (String code :
					codes) {
				String tmp = add(code);
				if(tmp != null)
					builder.append(tmp).append("\n");
			}
			if(builder.isEmpty()) return null;
			return builder.toString();
		}
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
		return builder.substring(0,builder.length()-3);
	}

	public String getImportText() {
		if(data.isEmpty()) return null;
		StringBuilder builder = new StringBuilder();
		builder.append("{\"name\":\"nameOfQuiz\",\"list\":[");
		for (Iterator<String> iterator = data.values().iterator(); iterator.hasNext(); ) {
			String value = iterator.next();
			builder.append("\"").append(value);
			if(iterator.hasNext()) builder.append("\"");
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


	/**
	 * https://teckensprakslexikon.su.se/movies/00/skola-00617-tecken.mp4
	 * https://teckensprakslexikon.su.se/ord/04748
	 * @param inputlink
	 * @return
	 */
	private AbstractMap.SimpleEntry<String,String> getEntry(String inputlink){
		if(inputlink.length() == 5){
			for (int i = 0; i < inputlink.length(); i++) {
				if(!Character.isDigit(inputlink.charAt(i))) return null;
			}
			return new AbstractMap.SimpleEntry<>(inputlink, inputlink);
		}else if(inputlink.contains("-")){
			String[] result = inputlink.split("-");
			return new AbstractMap.SimpleEntry<>(inputlink, result[1]);
		}
		else if (inputlink.contains("/")){
			return new AbstractMap.SimpleEntry<>(inputlink, inputlink.substring(inputlink.length()-5));
		}






		return null;
	}

	private boolean isCodeList(@org.jetbrains.annotations.NotNull String inputlink) {
		if((inputlink.length() + 1) % 6 != 0 || inputlink.length() <= 5){
			return false;
		}
		for (int i = 0, j= 1; i < inputlink.length(); i++) {
			if(j == 7) j = 1;
			if(j == 6 ){
				if(inputlink.charAt(i) != ',') return false;
			}
			else{
				if(!Character.isDigit(inputlink.charAt(i))){
					return false;
				}
			}
			j++;
		}
		return true;
	}
}
