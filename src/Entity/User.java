package Entity;

public class User {
    private String surname;
    private String givenName;
    private String ID;

    public User() {
    }

    public User(String surname, String givenName, String ID) {
        this.surname = surname;
        this.givenName = givenName;
        this.ID = ID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}
