package Project;

public class Actor implements Comparable<Actor>{

	private String name;
	private String preference;
	
	public Actor(String name, String preference) {
		this.name = name;
		this.preference = preference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}
	
	public int compareTo(Actor other){
		int temp = Integer.parseInt(preference);
		int temp2 = Integer.parseInt(other.getPreference());
		if(temp > temp2){
			return -1;
		}
		if( temp < temp2){
			return 1;
		}
		return 0;
		
	}
	
}