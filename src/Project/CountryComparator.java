package Project;

import java.util.Comparator;

public class CountryComparator implements Comparator<Country> {

	public CountryComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Country o1, Country o2) {
		// TODO Auto-generated method stub
		return o1.getPreference().compareTo(o2.getPreference());
	}

}
