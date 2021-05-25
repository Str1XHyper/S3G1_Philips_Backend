package mercier.s3.backend;

import com.google.gson.JsonObject;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.internal.common.assertion.Assertion;
import mercier.s3.backend.Controller.QuestionController;
import mercier.s3.backend.DAL.Question.Question;
import mercier.s3.backend.DAL.Question.QuestionTypes;
import net.bytebuddy.implementation.bytecode.Throw;
import org.gradle.internal.impldep.javax.inject.Inject;
import org.hibernate.HibernateException;
import org.hibernate.jdbc.Expectation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.wildfly.common.Assert;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.persistence.criteria.CriteriaBuilder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@QuarkusTest
public class QuestionControllerTest {

    @Inject QuestionController questionController;
    @InjectMock QuestionController questionControllerMock;

    private ArrayList<Question> makeQuestionsList() {
        return new ArrayList<>();
    }

    @Test
    public void GetAllQuestionsFromOneLesson() {
        //Arrange
        List<Question> expectedQuestionList = makeQuestionsList();
        List<Question> actualQuestionList;
        String lessonID = "1";

        Mockito.when(questionControllerMock.GetQuestion(lessonID)).thenReturn(expectedQuestionList);

        //Act
        actualQuestionList = questionController.GetQuestion(lessonID);

        //Arrange
        Assertions.assertEquals(expectedQuestionList, actualQuestionList, "Questions List does not match " +
                "Found the following lists: " +
                expectedQuestionList + " And actual list: " + actualQuestionList);
    }

    @Test
    public void GetPlannedQuestion() {
        //Arrange
        List<Question> expectedQuestionList = makeQuestionsList();
        List<Question> actualQuestionList;
        String lessonID = "1";

        Mockito.when(questionControllerMock.GetPlannedQuestion(lessonID)).thenReturn(expectedQuestionList);

        //Act
        actualQuestionList = questionController.GetPlannedQuestion(lessonID);

        //Arrange
        Assertions.assertEquals(expectedQuestionList, actualQuestionList, "Questions List does not match " +
                "Found the following lists: " +
                expectedQuestionList + " And actual list: " + actualQuestionList);
    }

    @Test
    public void GetQuestionTypes() {
        //Arrange
        QuestionTypes[] expectedQuestionTypes = {};
        QuestionTypes[] actualQuestionTypes = {};

        Mockito.when(questionControllerMock.GetTypes()).thenReturn(expectedQuestionTypes);

        //Act
        actualQuestionTypes = questionController.GetTypes();

        //Arrange
        Assertions.assertEquals(expectedQuestionTypes, actualQuestionTypes, "Question types does not match " +
                " We have found the following Question types: " +
                expectedQuestionTypes + " And the actual question types: " + actualQuestionTypes);
    }
}
