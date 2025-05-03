package BackendAssignment008;

import java.lang.reflect.Modifier;

import java.lang.reflect.Constructor;

import java.lang.reflect.Field;

import java.lang.reflect.Method;

import java.util.ArrayList;

import java.util.Scanner;

public class ClassInspector {
	
	public static <T> String getClassName(Class<?> clazz) {
		
		System.out.println("\n----- Class Name -----");
		
		return clazz.getName();
		
	}
	
	public static <T> ArrayList<String> getFieldsNames(Class<?> clazz) {
		
		System.out.println("\n----- Declared fields ----- : ");
		
		Field[] fields = clazz.getDeclaredFields();
		
		ArrayList<String> getFields = new ArrayList<>();
		
		for(Field field : fields) {
			
			getFields.add(field.getName());
			
		}
		
		return getFields;
		
	}
	
	public static <T> ArrayList<String> getMethodNames(Class<?> clazz) {
		
		System.out.println("\n----- Listing all methods ----- \n");
		
		Method[] methods = clazz.getMethods();
		
		ArrayList<String> getMethods = new ArrayList<>();
		
		for(Method method : methods) {
			
			getMethods.add(method.getName());
			
		}
		
		return getMethods;
		
	}
	
	
	public static <T> ArrayList<String> getConstructors(Class<?> clazz) {
		
		System.out.println("\n----- Listing Constructors -----");
		
		Constructor<?>[] constructors = clazz.getConstructors();
		
		ArrayList<String> getConstructors = new ArrayList<>();
		
		for(Constructor<?> constructor : constructors) {
			
			getConstructors.add(constructor.getName());
			
		}
		
		return getConstructors;
		
	}
		
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("----- Class Inspector -----\n");
		
		System.out.println("Enter a class name : ");
		
		String className = userInput.nextLine();
		
		Class<?> classToInspect = Class.forName(className);
		
		while(true) {
		
			System.out.println("\nWhat do you want to do?\nPress '1' to get the class Name\nPress '2' to get Declared fields.\nPress '3' to get Method names.\nPress '4' to get Constructors.\nPress '5' to invoke any methods.\nPress '6' to Exit.");
			
			int choice = userInput.nextInt();
			
			if(choice == 1) {			
				
				System.out.println("Class Name => " + ClassInspector.getClassName(classToInspect));
				
			}
			
			else if(choice == 2) {
				
				System.out.println("Class Fields => " + ClassInspector.getFieldsNames(classToInspect));
				
			}
			
			else if(choice == 3) {
				
				System.out.println("Class Method Names => " + ClassInspector.getMethodNames(classToInspect));
				
			}
			
			else if(choice == 4){
				
				System.out.println("Class constructors => " + ClassInspector.getConstructors(classToInspect));
				
			}
			
			else if(choice == 5) {
				
				Method[] methods = classToInspect.getDeclaredMethods();
				
				for(int i=0;i<methods.length;i++) {
					
					System.out.println((i+1) + " - " + methods[i].getName());
					
				}
				
				System.out.println("\nSelect the method you want to invoke");
				
				int methodSelected = userInput.nextInt();
				
				if(methodSelected >=1 && methodSelected <= methods.length) {
					
					Method selectedMethod = methods[methodSelected-1];
										
					String methodName = selectedMethod.getName();
					
					try {
						
						Class<?>[] parameterTypes = selectedMethod.getParameterTypes();
						
						if(parameterTypes.length != 0) {
							
							Object[] parameters = new Object[parameterTypes.length];
							
							for(int i=0;i<parameterTypes.length;i++) {
								
								System.out.println("Enter the value for parameter " + (i+1) + " (" + parameterTypes[i].getName() + ") : ");
								
								if(parameterTypes[i] == int.class) {
									
									parameters[i] = userInput.nextInt();
									
								}
								
								else if(parameterTypes[i] == byte.class) {
									
									parameters[i] = userInput.nextByte();
									
								}
								
								else if(parameterTypes[i] == short.class) {
									
									parameters[i] = userInput.nextShort();
									
								}
								
								else if(parameterTypes[i] == long.class) {
									
									parameters[i] = userInput.nextLong();
									
								}
								
								else if(parameterTypes[i] == double.class) {
									
									parameters[i] = userInput.nextDouble();
									
								}
								
								else if(parameterTypes[i] == float.class) {
									
									parameters[i] = userInput.nextFloat();
									
								}
								
								else if(parameterTypes[i] == String.class) {
									
									parameters[i] = userInput.next();
									
								}	
								
								else if(parameterTypes[i] == char.class) {
									
									while(true) {
									
										String param = userInput.next();
										
										if(param.length() == 1) {
											
											parameters[i] = param.charAt(0);
											
											break;
											
										}
										
										else {
											
											System.out.println("Invalid character. A character should have only one letter.");
											
											continue;
											
										}
									
									}
									
								}
								
								else if (parameterTypes[i] == boolean.class || parameterTypes[i] == Boolean.class) {
									
									userInput.nextLine();
								    
									boolean input = userInput.nextBoolean();
								        
									parameters[i] = Boolean.valueOf(input);
								
								}
								
								else {
									
									System.out.println("Please Enter a vaild parameter type.");
									
								}
								
							}
							
							Object instance = null;
							
							if(!Modifier.isStatic(selectedMethod.getModifiers())) {
								
								Constructor<?> constructor = classToInspect.getDeclaredConstructor();
								
								constructor.setAccessible(true);								
								
								instance = constructor.newInstance();
								
							}
							
							System.out.println("Result of the invoked method : " + selectedMethod.invoke(instance, parameters));
							
							System.out.println("The method " + methodName + " has been invoked successfully.");
							
						}
												
					} 
					
					catch (Exception e) {
					
						System.out.println("Error : " + e.getMessage());
					
					}
					
				}
				
				else {
					
					System.out.println("Please Enter a valid choice.");
					
				}
				
			}
			
			else {
				
				System.out.println("Exitting ...");
				
				break;
				
			}
		
		}
		
		
		
		
//		System.out.println("Get Class Name :\n");
//		
//		System.out.println(ClassInspector.getClassName(123));
//		
//		System.out.println(ClassInspector.getClassName("123"));
//		
//		System.out.println(ClassInspector.getClassName(123.0));
//		
//		System.out.println(ClassInspector.getClassName(123.0f));
//		
//		System.out.println(ClassInspector.getClassName(true));
//		
//		
//		System.out.println("\nGet Class Fields :\n");
//		
//		System.out.println("Integer Class Fields : " + ClassInspector.getFieldsNames(123));
//		
//		System.out.println("String Class Fields : " + ClassInspector.getFieldsNames("123"));
//		
//		System.out.println("Double Class Fields : " + ClassInspector.getFieldsNames(123.0));
//		
//		System.out.println("Float Class Fields : " + ClassInspector.getFieldsNames(123.0f));
//		
//		System.out.println("Boolean Class Fields : " + ClassInspector.getFieldsNames(true));
//		
//		
//		System.out.println("\nGet Class Methods :\n");
//		
//		System.out.println("Integer Class Methods : " + ClassInspector.getMethodNames(123));
//		
//		System.out.println("String Class Methods : " + ClassInspector.getMethodNames("123"));
//		
//		System.out.println("Double Class Methods : " + ClassInspector.getMethodNames(123.0));
//		
//		System.out.println("Float Class Methods : " + ClassInspector.getMethodNames(123.0f));
//		
//		System.out.println("Boolean Class Methods : " + ClassInspector.getMethodNames(true));
//		
//		
//		System.out.println("\nGet Class Constructors :\n");
//		
//		System.out.println("Integer Class Constructors : " + ClassInspector.getConstructors(123));
//		
//		System.out.println("String Class Constructors : " + ClassInspector.getConstructors("123"));
//		
//		System.out.println("Double Class Constructors : " + ClassInspector.getConstructors(123.0));
//		
//		System.out.println("Float Class Constructors : " + ClassInspector.getConstructors(123.0f));
//		
//		System.out.println("Boolean Class Constructors : " + ClassInspector.getConstructors(true));
//		
//		System.out.println("\n" + "-".repeat(100));
		
		
		userInput.close();
		

	}

}