package sample;

public class User {
    private String login;
    private String password;
    private String accessRight;

    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getAccessRight(){
        return accessRight;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAccessRight(String accessRight) {
        this.accessRight = accessRight;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
