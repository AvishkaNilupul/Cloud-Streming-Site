package io.cloudvideoplayer.cloudvideoplayer.Services;

import io.cloudvideoplayer.cloudvideoplayer.Model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService{


    private static final String VALID_USERNAME = "avishka";
    private static final String VALID_PASSWORD = "125589";

    public boolean authenticate(String username, String password) {

        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }

    public User getUserDetails(String username) {

        if (VALID_USERNAME.equals(username)) {

            return new User(VALID_USERNAME, "john@example.com");
        }
        return null;
    }
}
