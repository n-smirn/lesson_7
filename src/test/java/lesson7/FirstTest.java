package lesson7;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest extends TestBase {

    @Test
    void fillRegFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Nancy");
        $("#lastName").setValue("Fancy");
        $("#userEmail").setValue("1@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8585858585");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("May");
        $(".react-datepicker__year-select").selectOptionContainingText("1989");
        $(".react-datepicker__day.react-datepicker__day--017").click();

        $("#subjectsContainer input").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("123.jpg");
        $("#currentAddress").setValue("random data");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        //saved data
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Nancy Fancy"));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text("1@mail.ru"));
        $(".table-responsive").$(byText("Gender"))
                .parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile"))
                .parent().shouldHave(text("8585858585"));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text("17 May,1989"));
        $(".table-responsive").$(byText("Subjects"))
                .parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture"))
                .parent().shouldHave(text("123.jpg"));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text("random data"));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text("NCR Delhi"));

    }

}
