package mercier.s3.backend.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import mercier.s3.backend.DAL.Lesson.Lesson;
import mercier.s3.backend.DAL.Question.Question;
import mercier.s3.backend.DAL.Question.QuestionTypes;
import mercier.s3.backend.Logic.LessonManager;
import mercier.s3.backend.Logic.QuestionManager;
import mercier.s3.backend.Models.Questions.AddQuestion;
import mercier.s3.backend.Models.Questions.DeleteQuestion;
import mercier.s3.backend.Models.Questions.EditQuestion;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Question")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class QuestionController {
    @Inject QuestionManager questionManager;
    @Inject LessonManager lessonManager;

    @POST
    @Path("/Add")
    public Question AddQuestion(AddQuestion addQuestion){
        return questionManager.CreateQuestion(addQuestion);
    }

    @GET
    @Path("/{LessonID}")
    public List<Question> GetQuestion(@PathParam("LessonID") String LessonID)
    {
        Lesson lesson = lessonManager.GetLesson(LessonID);
        return lesson.getQuestions();
    }

    @GET
    @Path("/Planned/{LessonID}")
    public List<Question> GetPlannedQuestion(@PathParam("LessonID") String LessonID)
    {
        Lesson lesson = lessonManager.GetPlannedLesson(LessonID);
        return lesson.getQuestions();
    }

    @PUT
    @Path("/Edit")
    public Question EditQuestion(EditQuestion editQuestion){
        return questionManager.EditQuestion(editQuestion);
    }

    @DELETE
    @Path("/Delete")
    public String DeleteQuestion(DeleteQuestion deleteQuestion){
        boolean response = questionManager.DeleteQuestion(deleteQuestion);
        return String.valueOf(response);
    }
    @GET
    @Path("/Types")
    public QuestionTypes[] GetTypes(){
        return QuestionTypes.values();
    }
}