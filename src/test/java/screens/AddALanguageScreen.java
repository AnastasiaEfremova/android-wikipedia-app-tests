package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class AddALanguageScreen {

    private final SelenideElement backButton = $(accessibilityId("Go back"));
    private final SelenideElement searchButton = $(accessibilityId("Search"));
    private final SelenideElement allLanguagesTitle = $("android.widget.TextView").shouldHave(text("All languages"));
    private final ElementsCollection languageItems = $$("android.view.View[clickable=true]");
    private final ElementsCollection languageNativeNames = $$("android.widget.TextView").filterBy(visible);

    @Step("Verify header elements")
    public void verifyHeaderElements() {
        backButton.shouldBe(visible);
        searchButton.shouldBe(visible);
        allLanguagesTitle.shouldBe(visible);
    }

    @Step("Verify languages list is not empty")
    public void verifyLanguagesListNotEmpty() {
        languageItems.shouldHave(sizeGreaterThan(0));
    }

    @Step("Select language: {languageName}")
    public void selectLanguage(String languageName) {
        languageNativeNames.findBy(text(languageName)).click();
        new WikipediaLanguagesScreen();
    }
}