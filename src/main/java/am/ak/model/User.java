package am.ak.model;

/**
 * Created by karlen on 6/11/17.
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void throwException() {
        throw new RuntimeException("User exception");
    }
}
