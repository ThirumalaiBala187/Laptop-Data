package BackendAssignment005;

import java.util.Comparator;

public class SeverityComparator implements Comparator<Patient>{

	@Override
	public int compare(Patient patient1,Patient patient2) {
		
		return Integer.compare(patient2.getSeverityLevel(), patient1.getSeverityLevel());
	
	}

}
