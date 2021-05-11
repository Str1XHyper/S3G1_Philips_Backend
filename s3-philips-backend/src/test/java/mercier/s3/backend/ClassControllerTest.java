package mercier.s3.backend;

import com.google.gson.JsonObject;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.internal.common.assertion.Assertion;
import mercier.s3.backend.Controller.ClassController;
import mercier.s3.backend.DAL.Class.SchoolClass;
import mercier.s3.backend.DAL.Lesson.Lesson;
import mercier.s3.backend.DAL.User.User;
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
public class ClassControllerTest {
    @Inject ClassController classController;
    @InjectMock ClassController classCon;

    private List<SchoolClass> makeClassesList() {
        List<SchoolClass> classes = new List<SchoolClass>() {
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
            public Iterator<SchoolClass> iterator() {
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
            public boolean add(SchoolClass schoolClass) {
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
            public boolean addAll(Collection<? extends SchoolClass> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends SchoolClass> c) {
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
            public SchoolClass get(int index) {
                return null;
            }

            @Override
            public SchoolClass set(int index, SchoolClass element) {
                return null;
            }

            @Override
            public void add(int index, SchoolClass element) {

            }

            @Override
            public SchoolClass remove(int index) {
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
            public ListIterator<SchoolClass> listIterator() {
                return null;
            }

            @Override
            public ListIterator<SchoolClass> listIterator(int index) {
                return null;
            }

            @Override
            public List<SchoolClass> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        return classes;
    }

    private List<User> makeUserList() {
        List<User> users = new List<User>() {
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
            public Iterator<User> iterator() {
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
            public boolean add(User user) {
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
            public boolean addAll(Collection<? extends User> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends User> c) {
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
            public User get(int index) {
                return null;
            }

            @Override
            public User set(int index, User element) {
                return null;
            }

            @Override
            public void add(int index, User element) {

            }

            @Override
            public User remove(int index) {
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
            public ListIterator<User> listIterator() {
                return null;
            }

            @Override
            public ListIterator<User> listIterator(int index) {
                return null;
            }

            @Override
            public List<User> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        return  users;
    }

    @Test
    public void GetAllClasses() {
        //Arrange
        List<SchoolClass> schoolClassesListExpected = makeClassesList();
        List<SchoolClass> schoolClassListActual;

        Mockito.when(classCon.GetClasses()).thenReturn(schoolClassesListExpected);

        //Act
        schoolClassListActual = classController.GetClasses();

        //Assert
        Assertions.assertEquals(schoolClassesListExpected, schoolClassListActual, "School Classes list does not match " +
                "found the next lists " +
                schoolClassesListExpected + " And " + schoolClassListActual);
    }

    @Test
    public void GetAllStudentsForAClass() {
        //Arrange
        List<User> expectedUserList = makeUserList();
        List<User> actualUserList;
        String classID = "1";

        Mockito.when(classCon.GetStudents(classID)).thenReturn(expectedUserList);

        //Act
        actualUserList = classController.GetStudents(classID);

        //Assert
        Assertions.assertEquals(expectedUserList, actualUserList, "Users list does not match " +
                "found the next lists " +
                expectedUserList + " And " + actualUserList);
    }
}
