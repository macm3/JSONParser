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
	private List<Movie> movies;
	private List<Movie> recomendados = new ArrayList<Movie>();

	public Advisor(List<User> users, List<Movie> movies) {
		this.users = users;
		this.movies = movies;
	}

	public void printActor(){
		System.out.println(globActor.get(getGlobActor().size()-1).getName());

	}

	public int[] ordena(int[] vetor){
		int[] indices = new int[vetor.length];
		for(int i = 0 ; i < vetor.length ; i++){
			indices[i] = i;
		}
		int aux;
		int auxInd;

		for(int i = 0; i < vetor.length - 1 ; i++){	
			for(int j = 0 ; j < vetor.length-1; j++){
				if(vetor[j] > vetor[j+1]){
					aux = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1]= aux;
					auxInd = indices[j];
					indices[j] = indices[j+1];
					indices[j+1]= auxInd;
				}
			}
		}

		return indices; 
	}



	public void recomendar(){
		String prioridadeA = globActor.get(getGlobActor().size()-1).getName();
		String prioridadeG = globGenre.get(getGlobGenre().size()-1).getName();
		String prioridadeC = globCountry.get(getGlobCountry().size()-1).getName();
		int prio = 0;
		int[] pri = new int[movies.size()];
		//while(recomendados.size() < 5) {
		for(int i = 0; i < movies.size(); i++){

			for(int j = 0; j < movies.get(i).getActors().length; j++){
				if(this.movies.get(i).getActors()[j].equals(prioridadeA)){
					prio++; 
				}
			}

			for(int k = 0; k < this.movies.get(i).getGenre().length; k++){
				if(this.movies.get(i).getGenre()[k].equals(prioridadeG)){
					prio++;
				}						
			}

			for(int l = 0; l < this.movies.get(i).getCountries().length; l++){
				if(this.movies.get(i).getCountries()[l].equals(prioridadeC)){
					prio++;
				}						
			}
			pri[i] = prio;
			prio = 0;
		}
		pri = this.ordena(pri);
		int temp = 1;
		System.out.println("");
		System.out.println("Lista de filmes recomendados:\n");
		for(int i = pri.length-1; i >= 0; i--){
			System.out.println("------------"+temp+"------------");
			System.out.println("Titulo: "+this.movies.get(pri[i]).getTitle());
			System.out.println("Diretor: "+this.movies.get(pri[i]).getDirector());
			System.out.print("Gêneros: ");
			for(int k = 0; k < this.movies.get(pri[i]).getGenre().length; k++){
				System.out.print(this.movies.get(pri[i]).getGenre()[k] + ";");
			}
			System.out.println();
			System.out.print("Atores: ");
			for(int m = 0; m < this.movies.get(pri[i]).getActors().length; m++){
				System.out.print(this.movies.get(pri[i]).getActors()[m] + ";");
			}
			System.out.println("");
			System.out.print("Países: ");
			for(int m = 0; m < this.movies.get(pri[i]).getCountries().length; m++){
			System.out.print(this.movies.get(pri[i]).getCountries()[m] + ";");
			}
			System.out.println();
			temp++;
		}	

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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}


}
