package cl.inacap.parenas.evaluacion2.modelo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rubén on 18-10-2017.
 */

public class User {
    private String name;
    private String password;

    public static final List<User> users = new ArrayList<User>(){{
        add(new User("user", "secret"));
        add(new User("user2", "secret2"));
    }};

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(){

    }

    public boolean checkLogin() {
        for (User user : users) {
            if (user.getName().equals(this.getName()) && user.getPassword().equals(this.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
