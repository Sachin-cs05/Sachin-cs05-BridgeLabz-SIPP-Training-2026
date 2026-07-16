package polymorphism;

public class Notification {
    protected String recipientName;
    protected String message;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public void sendNotification() {
        System.out.println("Sending notification to " + recipientName);
    }
}

class EmailNotification extends Notification {
    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("Email sent to " + recipientName + ": " + message);
    }
}

class SMSNotification extends Notification {
    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("SMS sent to " + recipientName + ": " + message);
    }
}

class PushNotification extends Notification {
    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("Push notification sent to " + recipientName + ": " + message);
    }
}

class NotificationMain {
    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Aman", "Your meeting is at 10 AM"),
            new PushNotification("Kabir", "Your order has been delivered"),
        };
        System.out.println("All Sent Notifications:");

        for (Notification notification : notifications) {
            notification.sendNotification();
        }
    }
}
