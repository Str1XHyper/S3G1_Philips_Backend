package mercier.s3.backend;

import com.google.gson.JsonObject;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import mercier.s3.backend.Controller.LessonController;
import mercier.s3.backend.DAL.Lesson.Lesson;
import mercier.s3.backend.DAL.Lesson.LessonRepository;
import mercier.s3.backend.Logic.LessonManager;
import org.gradle.internal.impldep.javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.wildfly.common.Assert;

import javax.json.Json;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.*;

@QuarkusTest
public class LessonControllerTest
{
    @Inject LessonController lessonController;
    @InjectMock LessonController lessonCon;

    private List<Lesson> makeLessonList() {
        return new ArrayList<Lesson>();
    }

    @Test
    public void GetAllLessons() {
        //Arrange
        List<Lesson> lessonListExpected = makeLessonList();
        List<Lesson> lessonListActual;

        Mockito.when(lessonCon.GetLessons()).thenReturn(lessonListExpected);

        //Act
        lessonListActual = lessonController.GetLessons();

        //Assert
        Assertions.assertEquals(lessonListExpected, lessonListActual, "Lessons list does not match " +
                "found the next lists " +
                lessonListExpected + " And " + lessonListActual);
    }

    @Test
    public void GetLessonByName() {
        //Arrange
        String lessonName = "Add";
        Lesson expectedLesson = new Lesson();

        Mockito.when(lessonCon.GetLesson(lessonName)).thenReturn(expectedLesson);

        //Act
        Lesson actualLesson = lessonController.GetLesson(lessonName);

        //Assert
        Assertions.assertEquals(expectedLesson, actualLesson, "Lessons does not match" +
                "found lessons are: " +
                expectedLesson + " And " + actualLesson);
    }

    @Test
    public void GetLessonByOwnerID() {
        //Arrange
        String ownerId = "78886e2c-80ac-403b-80a0-e9224add01bb";
        List<Lesson> expectedLessonList = makeLessonList();
        List<Lesson> actualLessonList;

        Mockito.when(lessonCon.GetLessons(ownerId)).thenReturn(expectedLessonList);

        //Act
        actualLessonList = lessonController.GetLessons(ownerId);

        //Assert
        Assertions.assertEquals(expectedLessonList, actualLessonList, "Lesson list does not match " +
                "found lessons are: " +
                expectedLessonList + " And " + actualLessonList);
    }


}
