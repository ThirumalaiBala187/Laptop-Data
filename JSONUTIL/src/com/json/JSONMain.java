package com.json;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONMain {

	public JSONMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		JSONObject json1 = new JSONObject();
//		json1.put("name","Bala");
//		json1.put("age",18);
//		json1.put("gender","male");
//		
//		System.out.println("JSON Object 1 : " + json1.toJSONString());
//		
//		JSONObject json2 = new JSONObject();
//		json2.put("name","Thirumalai");
//		json2.put("age",17);
//		json2.put("gender","male");
//		
//		System.out.println("JSON Object 2 : " + json2.toJSONString());
//		
//		JSONArray arr = new JSONArray();
//		arr.add(json1);
//		arr.add(json2);
//		
//		System.out.println("JSON Array of Objects : " + arr);
//		
//		
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("name","Bala");
//		map.put("age",18);
//		map.put("gender","male");
//		
//		JSONObject obj = new JSONObject(map);
//		
//		System.out.println(obj.toJSONString());
//		
//		String str = "{\"gender\":\"male\",\"name\":\"Bala\",\"age\":18}";
//		
//		JSONParser parse = new JSONParser();
//		
//		try {
//			JSONObject obj1 = (JSONObject) parse.parse(str);
//			System.out.println(obj1.toJSONString());
//		} catch (Exception e) {
//			System.out.println("Error : " + e.getMessage());
//		}
		
		Person person1 = new Person("Bala",18,"Male");
		JSONObject json = JSONUtil.toJsonObject(person1);
		
		System.out.println(json.toJSONString());
		
		Employee emp =  new Employee("Bala",18,"Male",24000);
		
		JSONObject json1 = JSONUtil.toJsonObject(emp);
		
		System.out.println(json1.toJSONString());	
		
		

	}

}
