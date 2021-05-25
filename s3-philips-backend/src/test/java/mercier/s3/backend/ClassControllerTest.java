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

import java.util.*;

@QuarkusTest
public class ClassControllerTest {
    @Inject ClassController classController;
    @InjectMock ClassController classCon;

    private List<SchoolClass> makeClassesList() {
        return new ArrayList<SchoolClass>();
    }

    private List<User> makeUserList() {
        return new ArrayList<User>();
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
