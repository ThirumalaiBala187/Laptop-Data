package BackendAssignment011;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AlarmMain {

	public AlarmMain() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("----- Alarm Application -----");
		
		loop1: while (true) {
			
			System.out.println("\nWhat would you like to do?\nPress '1' to 'Set' Alarm.\nPress '2' to 'List' Alarms.\nPress '3' to 'Cancel' Alarm.\nPress '4' to 'Exit'.");
			
			int choice = userInput.nextInt();
			
			if(choice == 4) {
				
				Alarm.exitApplication();
				
				break loop1;
				
			}
			
			else if(choice == 1) {
				
				userInput.nextLine();
				
				loop2 : while(true) {
									
					System.out.println("Enter the Date and Time for the Alarm in this format - (yyyy-MM-dd HH:mm:ss) :");
					
					String time = userInput.nextLine();
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					
					try {
						
						LocalDateTime alarmTime = LocalDateTime.parse(time, formatter);
						
						if(alarmTime.isAfter(LocalDateTime.now())) {
							
							Alarm newAlarm = new Alarm(alarmTime);
							
							newAlarm.setAlarm(alarmTime);
							
							break loop2;
							
						}
						
						else {
						
							System.out.println("Please Enter a correct time. The alarm can be set only in future.\n");
							
						}
											
					} 
					
					catch (Exception e) {
						
						System.out.println("Invalid Time format. Please Enter in this format (yyyy-mm-dd HH:mm:ss)\n");
						
					}
				
				}
				
			}
			
			else if (choice == 2) {
				
				Alarm.listAlarms();
				
			}
			
			else if (choice == 3) {
				
				System.out.println("Enter the Alarm Id to cancel it : ");
				
				int cancelAlarmId = userInput.nextInt();
				
				Alarm.cancelAlarm(cancelAlarmId);
				
			}
			
		}
		
		userInput.close();
		
	}

}
