package mercier.s3.backend.Controller;


import mercier.s3.backend.DAL.User.User;
import mercier.s3.backend.Logic.AuthManager;
import mercier.s3.backend.Models.Auth.LoginModel;
import mercier.s3.backend.Models.Auth.LoginResponse;
import mercier.s3.backend.Models.Auth.RegisterModel;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AuthController {
    @Inject AuthManager authManager;

    @POST
    @Path("/Login")
    public LoginResponse Login(LoginModel loginModel){
        try{
            return authManager.VerifyLogin(loginModel);
        } catch (Exception ex){
            LoginResponse response = new LoginResponse();
            response.setResponseCode(400);
            return response;
        }
    }

    @POST
    @Path("/Register")
    public User Register(RegisterModel registerModel){
        return authManager.AddUser(registerModel);
    }
}
