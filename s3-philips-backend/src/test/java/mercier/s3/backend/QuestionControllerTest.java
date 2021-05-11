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
import org.gradle.internal.impldep.javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.wildfly.common.Assert;

import javax.json.Json;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@QuarkusTest
public class QuestionControllerTest {

    @Inject QuestionController questionController;
    @InjectMock QuestionController questionControllerMock;

    private List<Question> makeQuestionsList() {
        List<Question> questionList = new List<Question>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Question> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Question question) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Question> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Question> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Question get(int index) {
                return null;
            }

            @Override
            public Question set(int index, Question element) {
                return null;
            }

            @Override
            public void add(int index, Question element) {

            }

            @Override
            public Question remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Question> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Question> listIterator(int index) {
                return null;
            }

            @Override
            public List<Question> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        return questionList;
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
        //Arrangee
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
