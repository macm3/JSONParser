package Project;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

  public static void main(String[] args) {
	Parser parser = new Parser();
	try {
		parser.parseFileMovie(new FileReader("/Users/marcelamelo/Developer/workspace /JSONParser/src/Input/banco_filmes.json"));
		parser.parseFileUser(new FileReader("/Users/marcelamelo/Developer/workspace /JSONParser/src/Input/banco_usuarios.json"));
		
		parser.testMovies();
		parser.testUsers();
	} catch (FileNotFoundException ex) {
		ex.printStackTrace();
	}
  }

}
