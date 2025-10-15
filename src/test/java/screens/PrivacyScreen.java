package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class PrivacyScreen {

    private final SelenideElement mainTitle = $(id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement beginButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    private static final String EXPECTED_MAIN_TITLE_TEXT = "Data & Privacy";

    @Step("Verify privacy screen is loaded")
    public PrivacyScreen verifyPrivacyScreenLoaded() {
        mainTitle.shouldBe(visible);
        beginButton.shouldBe(visible);
        return this;
    }

    @Step("Verify privacy title text")
    public PrivacyScreen verifyPrivacyTitle() {
        mainTitle.shouldHave(text(EXPECTED_MAIN_TITLE_TEXT));
        return this;
    }

    @Step("Verify begin button is present")
    public void verifyBeginButtonPresent() {
        beginButton.shouldHave(text("Get started"));
    }

    @Step("Complete onboarding")
    public MainScreen completeOnboarding() {
        beginButton.click();
        return new MainScreen();
    }
}