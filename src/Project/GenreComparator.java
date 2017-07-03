package Project;

import java.util.Comparator;

public class GenreComparator implements Comparator<Genre> {

	public GenreComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Genre g1, Genre g2) {
		// TODO Auto-generated method stub
		return g1.getPreference().compareTo(g2.getPreference());
	}

}
