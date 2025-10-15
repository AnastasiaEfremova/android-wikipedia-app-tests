package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class BookmarksScreen {

    private final SelenideElement primaryTitle = $(id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement skipOption = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));
    private final SelenideElement nextStepButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    private static final String EXPECTED_PRIMARY_TEXT = "Reading lists with sync";

    @Step("Verify bookmarks screen is loaded")
    public BookmarksScreen verifyBookmarksScreenLoaded() {
        primaryTitle.shouldBe(visible);
        skipOption.shouldBe(visible);
        return this;
    }

    @Step("Verify primary title text")
    public BookmarksScreen verifyPrimaryTitle() {
        primaryTitle.shouldHave(text(EXPECTED_PRIMARY_TEXT));
        return this;
    }

    @Step("Verify skip option is visible")
    public void verifySkipOptionVisible() {
        skipOption.shouldBe(visible);
    }

    @Step("Continue to privacy screen")
    public PrivacyScreen proceedToNextStep() {
        nextStepButton.click();
        return new PrivacyScreen();
    }

    @Step("Skip onboarding from bookmarks screen")
    public MainScreen skipOnboarding() {
        skipOption.click();
        return new MainScreen();
    }
}