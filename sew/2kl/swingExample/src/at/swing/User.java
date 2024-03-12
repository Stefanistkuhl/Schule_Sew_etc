package at.swing;

public class User {
    private String username;
    private String password;

    public User(String username, String password){
        this.password = password;
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.username;
    }
    @Override
    public String toString(){
       return this.username + " " + this.password;
    }

}
