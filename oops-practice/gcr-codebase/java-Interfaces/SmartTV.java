interface StreamingService {

    void streamMovies();

    default void showSubscriptionDetails() {
        System.out.println("Streaming Subscription: Premium Plan");
    }
}

interface GamingService {

    void playGames();

    default void showSubscriptionDetails() {
        System.out.println("Gaming Subscription: Gold Plan");
    }
}

public class SmartTV implements StreamingService, GamingService {

    String[] movies = {
        "Avengers",
        "Interstellar",
        "Inception"
    };

    String[] games = {
        "FIFA",
        "Minecraft",
        "PUBG"
    };

    public void streamMovies() {
        System.out.println("Movies Available:");
        for (String movie : movies) {
            System.out.println(movie);
        }
    }

    public void playGames() {
        System.out.println("Games Available:");
        for (String game : games) {
            System.out.println(game);
        }
    }

    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public static void main(String[] args) {
        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();
        System.out.println();

        tv.streamMovies();
        System.out.println();

        tv.playGames();
    }
}