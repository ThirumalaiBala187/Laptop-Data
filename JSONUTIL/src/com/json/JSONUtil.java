package com.json;

import java.lang.reflect.Field;

import org.json.simple.JSONObject;

public class JSONUtil {

		public static<T> JSONObject toJsonObject(T obj) {
			Class<?> clazz = obj.getClass();
			Field[] fields = clazz.getDeclaredFields();
			JSONObject json = new JSONObject();
			
			for(Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				try {
					json.put(fieldName, field.get(obj));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return json;
		}
		
		
//		public static<T> T toJavaObject(JSONObject obj, Class<T> clazz){
//			
//			try {
//				T obj = clazz.getDeclaredConstructor().newInstance();
//				Field[] fields = clazz.getDeclaredFields();
//				for
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}

}
