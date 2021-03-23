package mercier.s3.backend.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import mercier.s3.backend.DAL.Lesson;
import mercier.s3.backend.Logic.LessonManager;
import mercier.s3.backend.Logic.QuestionManager;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/Question")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class QuestionController {
    @Inject QuestionManager questionManager;
    @Inject LessonManager lessonManager;
    private static Logger logger = Logger.getLogger(QuestionController.class.getName());

    @POST
    @Path("/Add")
    public String AddQuestion(String data){

        JsonObject obj = new Gson().fromJson(data, JsonObject.class);
        questionManager.CreateQuestion(obj);

        return new Gson().toJson(obj);
    }

    @GET
    @Path("/{LessonID}")
    public String GetQuestions(@PathParam("LessonID") String LessonID)
    {
        logger.info(LessonID);
        Lesson lesson = lessonManager.GetLesson(LessonID);
        return new Gson().toJson(lesson.getQuestions());
    }

    @POST
    @Path("/Edit")
    public String EditQuestion(String data){
        JsonObject obj = new Gson().fromJson(data, JsonObject.class);
        boolean response = questionManager.EditQuestion(obj);
        return String.valueOf(response);
    }

    @DELETE
    @Path("/Delete")
    public String DeleteQuestion(String data){
        JsonObject obj = new Gson().fromJson(data, JsonObject.class);
        boolean response = questionManager.DeleteQuestion(obj);
        return String.valueOf(response);
    }
}