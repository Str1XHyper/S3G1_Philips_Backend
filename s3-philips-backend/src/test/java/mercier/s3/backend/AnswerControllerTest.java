package mercier.s3.backend;


import com.google.gson.JsonObject;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.internal.common.assertion.Assertion;
import mercier.s3.backend.Controller.AnswerController;
import mercier.s3.backend.DAL.Answer.Answer;
import org.gradle.internal.impldep.javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.wildfly.common.Assert;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.*;

@QuarkusTest
public class AnswerControllerTest {

    @Inject AnswerController answerController;
    @InjectMock AnswerController answerControllerMock;


    @Test
    public void GetAnswersFromAQuestion() {
        //Arrange
        List<Answer> expectedAnswerList = new ArrayList<>();
        List<Answer> actualAnswerList;
        String questionId = "1";

        Mockito.when(answerControllerMock.GetAnswers(questionId)).thenReturn(expectedAnswerList);

        //Act
        actualAnswerList = answerController.GetAnswers(questionId);

        //Arrange
        Assertions.assertEquals(expectedAnswerList, actualAnswerList, "Answers does not match " +
                "We have found thee following answers: " +
                expectedAnswerList + " And actual answers: " + actualAnswerList);
    }
}
