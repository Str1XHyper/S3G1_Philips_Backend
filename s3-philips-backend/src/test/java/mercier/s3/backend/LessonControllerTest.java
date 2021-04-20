package mercier.s3.backend;

import io.quarkus.test.junit.QuarkusTest;
import mercier.s3.backend.DAL.Lesson.Lesson;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class LessonControllerTest
{
    @Test
    public void getAllLessons() {
        Lesson lesson = new Lesson();
        lesson.setId("ac04dcab-b025-45ff-b90a-d15b73759284");
        lesson.setName("Add");
        given()
          .when().get("/Lessons/GetByName/Add")
          .then()
             .statusCode(200)
             .body(is(lesson));
    }

}