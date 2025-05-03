package BackendAssignment005;

import java.time.LocalTime;

public class Patient{
	
	int patientId;
	
	private String patientName;
	
	private int severityLevel;
	
	private LocalTime admitTime;
	
	static int increment = 1001;

	public Patient(String patientName, int severityLevel) {
		
		this.patientId = increment;
		
		increment++;
		
		this.patientName = patientName;
		
		this.severityLevel = severityLevel;
		
		this.admitTime= LocalTime.now();
		
	}

	public String getPatientName() {
		
		return patientName;
	
	}

	public void setPatientName(String patientName) {
	
		this.patientName = patientName;
	
	}

	public LocalTime getAdmitTime() {
	
		return admitTime;
	
	}

	public void setAdmitTime(LocalTime admitTime) {
	
		this.admitTime = admitTime;
	
	}

	public int getSeverityLevel() {
	
		return severityLevel;
	
	}

	public void setSeverityLevel(int severityLevel) {
	
		this.severityLevel = severityLevel;
	
	}
	
	@Override	
	public String toString() {
		
		return "\n----- Patient Details -----\nPatient ID : " +patientId + "\nName : " + patientName + "\nSeverity Level : " + severityLevel + "\nAdmitted Time : " + admitTime;
		
	}

	public int getPatientId() {
	
		return patientId;
	
	}

	public void setPatientId(int patientId) {

		this.patientId = patientId;
	
	}

}
