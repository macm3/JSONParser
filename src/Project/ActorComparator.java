package Project;

import java.util.Comparator;

public class ActorComparator implements Comparator<Actor>{

	public ActorComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Actor o1, Actor o2) {
		// TODO Auto-generated method stub
		return o1.getPreference().compareTo(o2.getPreference());
	}

}
