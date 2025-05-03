package BackendAssignment005;

import java.util.Comparator;

public class TimeComparator implements Comparator<Patient>{

	@Override
	public int compare(Patient patient1,Patient patient2) {
		
		return patient1.getAdmitTime().compareTo(patient2.getAdmitTime());
	
	}
	
}