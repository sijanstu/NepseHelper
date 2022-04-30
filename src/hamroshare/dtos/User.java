package hamroshare.dtos;

/**
 *
 * @author Sijan Bhandari
 */
public class User {

    private final String ID;
    private final String Username;

    public User(String ID, String Username) {
        this.ID = ID;
        this.Username = Username;
    }

    public String getID() {
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
