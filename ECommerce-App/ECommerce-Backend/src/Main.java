// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and Welcome to ECommerce-App Backend project!");

        UserManagement userManagement = new UserManagement();
        userManagement.signUp("Aditya","Kulkarni","aditya@gmail.com","password");
        String sessionId = userManagement.signIn("aditya@gmail.com","password");
        System.out.println("Session id is "+sessionId);

        //userManagement.signUp("Aditya","Kulkarni","aditya@gmail.com","password");
        //userManagement.signIn("aditya@gmail.com","");


    }
}