package Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Advisor {
	
	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	private List<Country> countries;
	private List<Actor> actors;
	private List<Genre> genres;
	private List<User> users;
	
	public Advisor(List<User> users) {
		this.users = users;
	}
	
	public void checkActor(){
		for(int i = 0; i < users.size(); i++){
			this.actors = new ArrayList(users.get(i).getActors());
			for(int j = 0; j < actors.size(); j++){
				if(users.get(i).getActors().contains(actors.get(j))){
					int temp =  Integer.parseInt(actors.get(j).getPreference());
					temp = temp+1;
					String temp2 = Integer.toString(temp);
					actors.get(j).setPreference(temp2);
				};
			}
		}
	}
	
	public void checkGenre(){
		for(int i = 0; i < users.size(); i++){
			this.genres = new ArrayList((users.get(i).getGenres()));
			for(int j = 0; j < genres.size(); j++){
				if(users.get(i).getGenres().contains(genres.get(j))){
					int temp =  Integer.parseInt(genres.get(j).getPreference());
					temp = temp+1;
					String temp2 = Integer.toString(temp);
					genres.get(j).setPreference(temp2);
				};
			}
		}
	}
	
	public void checkCountry(){
		for(int i = 0; i < users.size(); i++){
			System.out.println(users.size());
			this.countries = new ArrayList(users.get(i).getCountries());
			for(int j = 0; j < countries.size(); j++){			
				System.out.println("entrou");
				if(users.get(i).getCountries().contains(countries.get(j))){
					int temp =  Integer.parseInt(countries.get(j).getPreference());
					temp = temp+1;
					String temp2 = Integer.toString(temp);
					countries.get(j).setPreference(temp2);
				};
			}
		}
	}
	

	
}
