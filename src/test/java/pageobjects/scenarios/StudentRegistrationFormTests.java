package pageobjects.scenarios;

import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTests {
    StudentRegistrationFormPage StudentRegistrationFormPage = new StudentRegistrationFormPage();


    @Test
    void successfulFillFormTest(){
        StudentRegistrationFormPage.openPage();
        StudentRegistrationFormPage.fillForm();
        StudentRegistrationFormPage.checkData();

    }
}
