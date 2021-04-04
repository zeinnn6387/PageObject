package pageobjects.scenarios;

import java.io.File;

import com.github.javafaker.Faker;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class StudentRegistrationFormPage {
    Faker faker = new Faker();

    //
    private String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            mobile =faker.number().digits(10),
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";


    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

    }

    public void fillForm(){
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



        }


    public void checkData() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text("Male"),
                text(mobile),
                text("05 January,1994"),
                text("English"),
                text("1.png"),
                text(currentAddress),
                text(state),
                text(city)
        );
    }


}

