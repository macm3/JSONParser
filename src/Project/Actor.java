package Project;

public class Actor {

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
	
}