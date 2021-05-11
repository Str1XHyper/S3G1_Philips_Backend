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

import javax.json.Json;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@QuarkusTest
public class AnswerControllerTest {

    @Inject AnswerController answerController;
    @InjectMock AnswerController answerControllerMock;


    private List<Answer> MakeAnswerList() {
        List<Answer> answersList = new List<Answer>() {
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
            public Iterator<Answer> iterator() {
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
            public boolean add(Answer answer) {
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
            public boolean addAll(Collection<? extends Answer> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Answer> c) {
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
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Answer get(int index) {
                return null;
            }

            @Override
            public Answer set(int index, Answer element) {
                return null;
            }

            @Override
            public void add(int index, Answer element) {

            }

            @Override
            public Answer remove(int index) {
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
            public ListIterator<Answer> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Answer> listIterator(int index) {
                return null;
            }

            @Override
            public List<Answer> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        return answersList;
    }

    @Test
    public void GetAnswersFromAQuestion() {
        //Arrange
        List<Answer> expectedAnswerList = MakeAnswerList();
        List<Answer> actualAnswerList;
        String questionId = "1";

        Mockito.when(answerControllerMock.GetAnswers(questionId)).thenReturn(expectedAnswerList);

        //Act
        actualAnswerList = answerController.GetAnswers(questionId);

        //Arrange
        Assertions.assertEquals(expectedAnswerList, actualAnswerList, "Answers does not match " +
                "We have found thee following anwsers: " +
                expectedAnswerList + " And actual answers: " + actualAnswerList);
    }
}
