package sample;

public class User {
    private String login;
    private String password;
    private String accessRight;
    private String securityQuestion;
    private String securityAnswer;
    private String position;
    public String[] getUser(String[] user){
        user[0]=getLogin();
        user[1]=getPassword();
        user[2]=getAccessRight();
        user[3]=getSecurityAnswer();
        user[4]=getSecurityQuestion();
        user[5]=getPosition();
        return user;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getAccessRight(){
        return accessRight;
    }
    public String getSecurityAnswer() { return securityAnswer; }
    public String getSecurityQuestion() { return securityQuestion; }
    public String getPosition(){return position;}

    public void setUser(String login,String password,String accessRight,String position, String securityQuestion,String securityAnswer){
        setLogin(login);
        setPassword(password);
        setAccessRight(accessRight);
        setPosition(position);
        setSecurityQuestion(securityQuestion);
        setSecurityAnswer(securityAnswer);
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
    public void setSecurityAnswer(String securityAnswer) { this.securityAnswer = securityAnswer; }
    public void setSecurityQuestion(String securityQuestion) { this.securityQuestion = securityQuestion; }
    public void setPosition(String position){ this.position=position; }
}
