import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WhatsApp {

    // Users of the app
    private List<User> users = new ArrayList<>();
    private HashMap<User, List<String>> messages = new HashMap<>();

    // Register a new user
    public void registerUser(String name) {
        User user = new User(name);
        users.add(user);
        messages.put(user, new ArrayList<>());
        System.out.println(name + " has been registered.");
    }

    // Send a message from one user to another
    public boolean sendMessage(User sender, User receiver, String message) {
        if (users.contains(sender) && users.contains(receiver)) {
            List<String> receiverMessages = messages.get(receiver);
            receiverMessages.add("From " + sender.getName() + ": " + message);
            System.out.println("Message sent from " + sender.getName() + " to " + receiver.getName() + ".");
            return true;
        } else {
            System.out.println("Message sending failed. Both users must be registered.");
            return false;
        }
    }

    // Print all messages for a user
    public void viewMessages(User user) {
        if (users.contains(user)) {
            System.out.println("Messages for " + user.getName() + ":");
            List<String> userMessages = messages.get(user);
            for (String msg : userMessages) {
                System.out.println(msg);
            }
        } else {
            System.out.println(user.getName() + " is not registered.");
        }
    }

    public static void main(String[] args) {
        WhatsApp app = new WhatsApp();

        // Register users
        app.registerUser("Sai");
        app.registerUser("Arya");

        // Create user instances for communication
        User sai = new User("Sai");
        User arya = new User("Arya");

        // Send a message
        app.sendMessage(sai, arya, "Hey Arya, hope you're doing well!");

        // View messages
        app.viewMessages(arya);
    }
}

// Supporting User class
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}