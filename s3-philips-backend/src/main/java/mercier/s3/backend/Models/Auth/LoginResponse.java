package mercier.s3.backend.Models.Auth;

import mercier.s3.backend.DAL.User.User;

public class LoginResponse {
    private User user;
    private String jwt;
    private int responseCode;

    public LoginResponse(){
        responseCode = 200;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
