package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaLanguagesScreen {

    private final ElementsCollection selectedLanguages = $$(id("org.wikipedia.alpha:id/wiki_language_title"));
    private final SelenideElement addLanguageButton = $$(id("org.wikipedia.alpha:id/wiki_language_title"))
            .findBy(text("Add language"));


    @Step("Verify default English language is present")
    public WikipediaLanguagesScreen verifyDefaultLanguagePresent() {
        selectedLanguages.findBy(text("English")).shouldBe(visible);
        return this;
    }

    @Step("Verify add language button is visible")
    public void verifyAddLanguageButtonVisible() {
        addLanguageButton.shouldBe(visible);
    }

    @Step("Tap on Add language button")
    public AddALanguageScreen tapOnAddLanguageButton() {
        addLanguageButton.click();
        return new AddALanguageScreen();
    }
}