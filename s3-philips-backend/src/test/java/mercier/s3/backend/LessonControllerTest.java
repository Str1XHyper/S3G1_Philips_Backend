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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@QuarkusTest
public class LessonControllerTest
{
    @Inject LessonController lessonController;
    @InjectMock LessonController lessonCon;

    private List<Lesson> makeLessonList() {
        List<Lesson> lessons = new List<Lesson>() {
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
            public Iterator<Lesson> iterator() {
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
            public boolean add(Lesson lesson) {
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
            public boolean addAll(Collection<? extends Lesson> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Lesson> c) {
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
            public Lesson get(int index) {
                return null;
            }

            @Override
            public Lesson set(int index, Lesson element) {
                return null;
            }

            @Override
            public void add(int index, Lesson element) {

            }

            @Override
            public Lesson remove(int index) {
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
            public ListIterator<Lesson> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Lesson> listIterator(int index) {
                return null;
            }

            @Override
            public List<Lesson> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        return lessons;
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
