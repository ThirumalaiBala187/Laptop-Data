package BackendAssignment005i;

import java.util.ArrayList;

import java.util.Collections;
import java.util.PriorityQueue;

import java.util.Scanner;

public class HospitalManagement {
	
	static PriorityQueue<Patient> patientList = new PriorityQueue<>();

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("---- Welcome to ZoHospital -----");
		
		loop1 : while(true) {
		
			System.out.println("\nWhat do you want do ?\nPress '1' to 'Display Patients;.\nPress '2' to 'Admit' patient.\nPress '3' to 'Treat' patients.\nPress '4' to 'Discharge' patient.\nPress '5' to 'Exit'");
			
			int option = userInput.nextInt();
			
			if (option == 5) {
				
				System.out.println("Thank you for visiting ZoHospital.");
				
				break loop1;
				
			}
			
			switch(option) {
			
			case 1:
				
				if(!patientList.isEmpty()) {
					
					for(Patient patient : patientList) {
						
						System.out.println(patient.toString());
						
					}
					
				}
				
				else {
					
					System.out.println("\nNo patients has been admitted yet.");
					
				}
				
				break;
			
			case 2:
				
				System.out.println("Enter the number of patients you want to add :");
				
				int count=userInput.nextInt();
				
				for(int i=0;i<count;i++) {
					
					userInput.nextLine();
					
					System.out.println("\nEnter the Patient " + (i+1) +" Name :");
					
					String name = userInput.nextLine();
					
					System.out.println("Enter the Severity Level :");
					
					int severity = userInput.nextInt();
					
					Patient patientToAdmit = new Patient(name, severity);
					
					admitpatient(patientToAdmit);
					
				}
				
				break;
				
			
			case 3:
				
				if(patientList.isEmpty()) {
					
					System.out.println("\nNo patients has been admitted yet.");
					
				}
				
				else {

					treatPatients();
					
				}
				
				break;
				
			case 4:
				
				if(patientList.isEmpty()) {
					
					System.out.println("\nNo patients has been admitted yet.");
					
				}
				
				else {
					
					System.out.println("\nEnter the patient Id to Discharge.");
					
					int id=userInput.nextInt();
					
					discharge(id);
					
				}
				
				break;			
				
		
			}
				
		}
		
		userInput.close();

	}
	
	static void admitpatient(Patient patient) {
		
		patientList.add(patient);
		
	}
	
	static void treatPatients() {
		
		ArrayList<Patient> patients = new ArrayList<>(patientList);
		
		Collections.sort(patients);
		
		System.out.println("\nPatient to be Treated First");
		
		System.out.println(patients.get(0).toString());
		
	}
	
	static void discharge(int id) {
		
		for(Patient patient : patientList) {
			
			if(patient.patientId == id) {
				
				patientList.remove(patient);
				
			}
			
		}
		
	}

}
