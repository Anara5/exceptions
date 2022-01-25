import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter login");
        String login = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();

        // checking login and password
        User currentUser = getUserByLoginAndPassword(login, password);

        // checking user validation
        validateUser(currentUser);

        System.out.println("Access is successful");

    }

    public static User[] getUsers() {
        User user1 = new User("john", "pass", "john@gmail.com", 17);
        User user2 = new User("anna", "batyr", "anna@gmail.com", 34);

        return new User[]{user1, user2};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();

        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                    return user;
                }
            }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {

        if (user.getAge() < 18) {
            throw new AccessDeniedException("Access denied");
        }
    }

}
