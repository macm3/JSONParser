package Project;

public class Country {

	private String name;
	private String preference;

	public Country(String name, String preference) {
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

	public int compareTo(Country other){
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
