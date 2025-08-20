package models;

public class Credentials {
    private String goodEmail;
    private String goodPassword;
    private String wrongEmail;
    private String wrongPassword;

    public String getEmail(){
        return goodEmail;
    }

    public String getPassword(){
        return goodPassword;
    }

    public String getWrongEmail(){
        return wrongEmail;
    }

    public String getWrongPassword(){
        return wrongPassword;
    }
}
