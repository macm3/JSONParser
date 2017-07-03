package Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Advisor {
	
	private List<Country> countries;
	private List<Country> globCountry = new ArrayList<Country>();
	private List<Actor> actors;
	private List<Actor> globActor = new ArrayList<Actor>();
	private List<Genre> genres;
	private List<Genre> globGenre = new ArrayList<Genre>();
	private List<User> users;
	
	public Advisor(List<User> users) {
		this.users = users;
	}
	
	public void addGlobActor(){
		for(int k = 0; k < users.size(); k++){
			this.globActor.addAll(users.get(k).getActors());
		}
	}
	
	public void checkActor(){
		addGlobActor();
		for(int i = 0; i < users.size(); i++){	
			for(int j = 0; j < globActor.size(); j++){			
				if(users.get(i).getActors().contains(globActor.get(j))){
					int temp =  Integer.parseInt(globActor.get(j).getPreference());
					//temp = temp+1;
					String temp2 = Integer.toString(temp);
					globActor.get(j).setPreference(temp2);
				};
			}
		}
		List<Actor> listaEliminarA = new ArrayList<Actor>();
		int m = 0;
		for(int i = 0; i < globActor.size() -1; i++){
			for(int j = i+1; j < globActor.size(); j++){
				if(globActor.get(i).getName().equals(globActor.get(j).getName())){
					int temp =  Integer.parseInt(globActor.get(j).getPreference());
					temp = temp+1;
					String temp2 = Integer.toString(temp);
					globActor.get(j).setPreference(temp2);
					listaEliminarA.add(m, globActor.get(i));
					m++;
				}
			}	
		}
		globActor.removeAll(listaEliminarA);		
	}
	
	public void addGlobGenre(){
		for(int k = 0; k < users.size(); k++){
			this.globGenre.addAll(users.get(k).getGenres());
		}
	}
	
	public void checkGenre(){
		addGlobGenre();
		for(int i = 0; i < users.size(); i++){		
			for(int j = 0; j < globGenre.size(); j++){			
				if(users.get(i).getGenres().contains(globGenre.get(j))){
					int temp =  Integer.parseInt(globGenre.get(j).getPreference());
					//temp = temp+1;
					String temp2 = Integer.toString(temp);
					globGenre.get(j).setPreference(temp2);
				};
			}
		}
		List<Genre> listaEliminarG = new ArrayList<Genre>();
		int k = 0;
		for(int i = 0; i < globGenre.size() -1; i++){
			for(int j = i+1; j < globGenre.size(); j++){
				if(globGenre.get(i).getName().equals(globGenre.get(j).getName())){
					int temp =  Integer.parseInt(globGenre.get(j).getPreference());
					temp = temp+1;
					String temp2 = Integer.toString(temp);
					globGenre.get(j).setPreference(temp2);
					listaEliminarG.add(k, globGenre.get(i));
					k++;
				}
			}	
		}
		globGenre.removeAll(listaEliminarG);		
	}
	
	public void addGlobCountry(){
		for(int k = 0; k < users.size(); k++){
			this.globCountry.addAll(users.get(k).getCountries());
		}
	}
	
	public void checkCountry(){
		addGlobCountry();
		for(int i = 0; i < users.size(); i++){		
			for(int j = 0; j < globCountry.size(); j++){			
				if(users.get(i).getCountries().contains(globCountry.get(j))){
					int temp =  Integer.parseInt(globCountry.get(j).getPreference());
					String temp2 = Integer.toString(temp);
					globCountry.get(j).setPreference(temp2);
				};
			}
		}
		List<Country> listaEliminar = new ArrayList<>();
		int l= 0;
		for(int i = 0; i < globCountry.size() -1; i++){
			for(int j = i+1; j < globCountry.size(); j++){
				if(globCountry.get(i).getName().equals(globCountry.get(j).getName())){
					int temp =  Integer.parseInt(globCountry.get(j).getPreference());
					temp = temp+1;
					String temp2 = Integer.toString(temp);
					globCountry.get(j).setPreference(temp2);
					listaEliminar.add(l, globCountry.get(i));
					l++;
				}
			}	
		}
		globCountry.removeAll(listaEliminar);		
	}
	
	
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

	public List<Country> getGlobCountry() {
		return globCountry;
	}

	public void setGlobCountry(List<Country> globCountry) {
		this.globCountry = globCountry;
	}

	public List<Actor> getGlobActor() {
		return globActor;
	}

	public void setGlobActor(List<Actor> globActor) {
		this.globActor = globActor;
	}

	public List<Genre> getGlobGenre() {
		return globGenre;
	}

	public void setGlobGenre(List<Genre> globGenre) {
		this.globGenre = globGenre;
	}


	
}
