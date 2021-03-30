package mercier.s3.backend.Controller;

import mercier.s3.backend.DAL.Answer;
import mercier.s3.backend.Logic.QuestionManager;
import mercier.s3.backend.Models.Answer.AddAnswer;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Answer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AnswerController {
    @Inject QuestionManager questionManager;

    @POST
    @Path("/Add")
    public boolean AddAnswers(AddAnswer addAnswer){
        System.out.println(addAnswer.getAnswers().toString());
        questionManager.SetAnswers(addAnswer);
        return true;
    }

    @GET
    @Path("/{QuestionID}")
    public List<Answer> GetAnswers(@PathParam("QuestionID") String questionID){
        return questionManager.getAnswers(questionID);
    }
}
