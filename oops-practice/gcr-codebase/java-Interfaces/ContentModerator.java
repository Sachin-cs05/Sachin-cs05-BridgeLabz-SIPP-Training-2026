interface TextModeration {

    void checkOffensiveContent(String post);

    default void displayModerationPolicy() {
        System.out.println("Text Moderation Policy: Offensive content is not allowed.");
    }

    static boolean containsRestrictedWords(String post) {
        String text = post.toLowerCase();
        return text.contains("hate") || text.contains("abuse") || text.contains("spam");
    }
}

interface SpamDetection {

    void checkSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam Detection Policy: Spam content is not allowed.");
    }
}

public class ContentModerator implements TextModeration, SpamDetection {

    String[] posts = {
        "Welcome to our community",
        "This is spam offer",
        "I hate everyone",
        "Enjoy your day",
        "Abuse is not good"
    };

    public void checkOffensiveContent(String post) {
        String text = post.toLowerCase();

        if (text.contains("hate") || text.contains("abuse")) {
            System.out.println(post + " --> Offensive Post");
        }
    }

    public void checkSpam(String post) {
        if (post.toLowerCase().contains("spam")) {
            System.out.println(post + " --> Spam Post");
        }
    }

    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public static void main(String[] args) {

        ContentModerator moderator = new ContentModerator();

        moderator.displayModerationPolicy();
        System.out.println();

        for (String post : moderator.posts) {

            if (TextModeration.containsRestrictedWords(post)) {

                if (post.toLowerCase().contains("spam")) {
                    moderator.checkSpam(post);
                } else {
                    moderator.checkOffensiveContent(post);
                }

            } else {
                System.out.println(post + " --> Valid Post");
            }
        }
    }
}