import controllers.interfaces.IMovieController;
import models.Movie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final IMovieController controller;
    private final Scanner scanner = new Scanner(System.in);

    public MyApplication(IMovieController controller){
        this.controller = controller;
    }

    public void start(){
        while (true){
            mainMenu();
            try {
                int option = scanner.nextInt();
                switch (option){
                    case 1 : getAllMoviesMenu(); break;
                    case 2 : getMovieByIdMenu(); break;
                    case 3 : createMovieMenu(); break;
                    default: return;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Input must be a number");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    private void getMovieByIdMenu() {
        System.out.println("Enter movie id: ");
        int id = scanner.nextInt();
        String response = controller.getMovieById(id);
        System.out.println(response);
    }

    private void getAllMoviesMenu() {
        String response = controller.getAllMovies();
        System.out.println(response);
    }
    private void createMovieMenu(){
        System.out.println("Please enter a movie name: ");
        String name = scanner.next();
        System.out.println("Please enter a movie genre: ");
        String genre = scanner.next();
        System.out.println("Please enter a movie age restriction: ");
        int age_res = scanner.nextInt();
        System.out.println("Please enter a movie rating: ");
        int rating = scanner.nextInt();
        System.out.println("Please enter a movie review: ");
        String review = scanner.next();

        Movie movie = new Movie(name, genre, age_res, rating, review);
        String response = controller.createMovie(movie);
        System.out.println(response);
    }

    private void mainMenu(){
        System.out.println("Welcome to movie centre");
        System.out.println("Select the option:");
        System.out.println("1. Get all available movies");
        System.out.println("2. Get movie by id");
        System.out.println("3. Upload a new movie");
        System.out.println("0. Exit");
        System.out.println("Enter option: (1-3): ");
    }
}
