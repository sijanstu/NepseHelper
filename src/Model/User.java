package Model;

/**
 *
 * @author Sijan Bhandari
 */
public class User {

    private final int ID;
    private final String Username;

    public User(int ID, String Username) {
        this.ID = ID;
        this.Username = Username;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return Username;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", Username=" + Username + '}';
    }

}
