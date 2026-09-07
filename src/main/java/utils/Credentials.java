package utils;

public class Credentials {

    public static String getUsername() {

        String username =
                System.getenv("CMS_USERNAME");

        if (username == null || username.isBlank()) {

            throw new RuntimeException(
                    "CMS_USERNAME environment variable is missing"
            );
        }

        return username;
    }

    public static String getPassword() {

        String password =
                System.getenv("CMS_PASSWORD");

        if (password == null || password.isBlank()) {

            throw new RuntimeException(
                    "CMS_PASSWORD environment variable is missing"
            );
        }

        return password;
    }
}