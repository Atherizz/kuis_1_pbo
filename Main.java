public class Main {
    public static void main(String[] args) {
        User user1 = new User("john_doe", "john@example.com", "password123");
        if (user1.getClass() == User.class) {
            System.out.println("User instance created successfully.");
        }
    }
}
