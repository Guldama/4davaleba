import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkClass {
    @Test
    public void Part_1(){
        open("https://ee.ge/");
        $(byText("რეგისტრაცია")).click();
        $(byText("სწრაფი რეგისტრაცია")).should(visible);
        $(byId("firstName")).setValue("nina").shouldNot(Condition.empty);
        $(byId("lastName")).setValue("guldama").shouldNot(Condition.empty);
        $(byId("email")).setValue("guldama@gmail.com").shouldNot(Condition.empty);
        $(byId("password")).setValue("gulda").shouldNot(Condition.empty);
        $(byId("confirmPassword")).setValue("gulda").shouldNot(Condition.empty);
        $(byId("singup")).should(Condition.disabled);
    }

    @Test
    public void Part_2(){
        open("https://ee.ge/");
        $(byId("rcc-confirm-button")).click();
        $(byText("რეგისტრაცია")). click();
        $(byText("სწრაფი რეგისტრაცია")).should(visible);
        $(byId("firstName")). click();
        $(byId("lastName")). click();
        $(byText("სახელი სავალდებულოა")). should(visible);
        $(byId("email")). click();
        $(byText("გვარი სავალდებულოა")). should(visible);
        $(byId("password")).click();
        $(byText("ელ. ფოსტა სავალდებულოა")). shouldBe(visible);
        $(byId("confirmPassword")). click();
        $(byText("პაროლი სავალდებულოა.")). should(visible);
        $(byId("password")). click();
        $(byText("პაროლის გამეორება სავალდებულოა")). should(visible);
        $(byId("email")).setValue("guldamagmail.com").shouldNot(Condition.empty);
        $(byText("ელ. ფოსტა სავალდებულოა")). should(visible);
        $(byId("password")).setValue("gulda").shouldNot(Condition.empty);
        $(byText("პაროლი სავალდებულოა.")). should(visible);
        $(byId("confirmPassword")).setValue("guldama").shouldNot(Condition.empty);
        $(byText("პაროლის გამეორება სავალდებულოა")). should(visible);
        $(byId("singup")). click();
        $(byId("singup")).should(Condition.disabled);
    }
    @Test
    public void Part_3(){
        open("https://ee.ge/");
        $(byClassName("cart-count")). click();
        $(byText("კალათა ცარიელია")).should(visible);
        $(byId("search_list")). setValue("lenovo");
        $(byClassName("fa-search")). click();
        ElementsCollection collection = $$(byClassName("fa-shopping-cart"));
        int count = collection.size();
        for(int i = 0; i < count; i++);
        $(byClassName("fa-shopping-cart"), 0). click();
        $(byClassName("cart-count")). click();
        $(byText("კალათა ცარიელია")).shouldNotBe(visible);
        $(byText("წაშლა")).click();
        $(byText("კალათა ცარიელია")).should(visible);
    }
    @Test
    public void Part_4(){
        open("https://ee.ge/");
        $(byClassName("cart-count")).click();
        $(byText("კალათა ცარიელია")).shouldBe(visible);
        sleep(5000);
        $(byText("შენახული ნივთები")).click();
        $(byText("ვერ მოიძებნა")).shouldBe(visible);
        sleep(5000);
        $(byId("search_list")).setValue("lenovo");
        $(byClassName("fa-search")).click();
        sleep(5000);
        ElementsCollection collection = $$(byClassName("fa-shopping-cart"));
        int count = collection.size();
        for (int i = 0; i < count; i++) ;
        $(byClassName("fa-shopping-cart"), 0).click();
        sleep(5000);
        $(byClassName("cart-count")).click();
        $(byText("შენახვა")).click();
        sleep(5000);
        $(byText("შენახული ნივთები")).click();
        $(byText("ვერ მოიძებნა")).shouldNotBe(visible);
        sleep(5000);
        $(byClassName("cart-count")).click();
        $(byText("კალათა ცარიელია")).shouldBe(visible);
        sleep(5000);
        $(byText("შენახული ნივთები")).click();
        $(byClassName("fa-times")).click();
        $(byText("ვერ მოიძებნა")).shouldNotBe(visible);
        sleep(5000);
    }
    }

