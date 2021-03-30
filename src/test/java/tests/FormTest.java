package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test

    void testForm()  {
        String firstName = "Иван",
                lastName = "Иванов",
                email = "12345@gmail.com",
                mobile ="1234567890",
                currentAddress = "Улица Пушкина, Дом Колотушкина";


        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").val(mobile);
        //dateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");

        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--005").click();
        //$("#subjectsContainer").click();
        $("#subjectsInput").setValue("En");
        $(byText("English")).click();

        //hobbies
        $(byText("Reading")).click();

        //picture
        $("#uploadPicture").uploadFile(new File("/Users/smith/IdeaProjects/FormTest/src/test/resources/1.png"));

        //Current Address
        $("#currentAddress").val(currentAddress);

        //Scroll
        $("#state").scrollTo();

        //State and City
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        //Submit
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //Проверка
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text("Male"));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("05" + " " + "January" + "," + "1994"));
        $x("//td[text()='Subjects']").parent().shouldHave(text("English"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Reading"));
        $x("//td[text()='Picture']").parent().shouldHave(text("1.png"));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text("NCR" + " " + "Delhi"));

    }
}
