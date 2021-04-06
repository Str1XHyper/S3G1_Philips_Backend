package mercier.s3.backend.Logic;

import mercier.s3.backend.DAL.Session.SessionRepository;
import mercier.s3.backend.DAL.User.User;
import mercier.s3.backend.DAL.User.UserRepository;
import mercier.s3.backend.Logic.jwt.Hasher;
import mercier.s3.backend.Logic.jwt.JWTWrapper;
import mercier.s3.backend.Models.Auth.LoginModel;
import mercier.s3.backend.Models.Auth.LoginResponse;
import mercier.s3.backend.Models.Auth.RegisterModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.InternalServerErrorException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@ApplicationScoped
public class AuthManager {
    @Inject UserRepository userRepository;
    @Inject SessionRepository sessionRepository;
    @Inject Hasher hasher;
    @Inject
    JWTWrapper jwt;

    public User AddUser(RegisterModel registerModel){
        try{
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setUsername(registerModel.getUsername());
            user.setPassword(hasher.EncryptPassword(registerModel.getPassword()));
            userRepository.persist(user);
            return user;
        } catch (PersistenceException ex){
            System.out.println();
            return null;
        }
    }

    public LoginResponse VerifyLogin(LoginModel loginModel) throws Exception{
        User user = userRepository.findByName(loginModel.getUsername());
        boolean canLogin = hasher.ValidatePassword(loginModel.getPassword(), user.getPassword());

        if(canLogin){
            LoginResponse response = new LoginResponse();
            response.setUser(user);
            try {
                response.setJwt(jwt.GenerateJWT(sessionRepository.CreateSession(user)));
            } catch (NoSuchAlgorithmException e) {
                throw new InternalServerErrorException("The given algorithm can't be used.");
            } catch (InvalidKeyException e) {
                throw new InternalServerErrorException("The given key isn't correct.");
            }
            return response;
        }
        throw new Exception("Password combination incorrect!");

    }
}
