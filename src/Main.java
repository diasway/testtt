import controllers.MovieController;
import controllers.interfaces.IMovieController;
import data.Postgres;
import data.interfaces.IDP;
import repositories.MovieRepository;
import repositories.interfaces.IMovieRepository;

public class Main {
    public static void main(String[] args) {
        IDP db = new Postgres("jdbc:postgresql://localhost:5432", "postgres", "LEMONBRO", "legion");
        IMovieRepository repo = new MovieRepository(db);
        IMovieController controller = new MovieController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
        db.close();
    }
}