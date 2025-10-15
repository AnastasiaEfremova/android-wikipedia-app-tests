package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class WelcomeScreen {

    private final SelenideElement logo = $(id("org.wikipedia.alpha:id/imageViewCentered"));
    private final SelenideElement primaryText = $(id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement secondaryText = $(id("org.wikipedia.alpha:id/secondaryTextView"));
    private final ElementsCollection languageOptions = $$(id("org.wikipedia.alpha:id/option_label"));
    private final SelenideElement languageButton = $(id("org.wikipedia.alpha:id/addLanguageButton"));
    private final SelenideElement skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));
    private final SelenideElement continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    @Step("Verify Wikipedia logo is visible")
    public WelcomeScreen verifyWikipediaLogoVisible() {
        logo.shouldBe(visible);
        return this;
    }

    @Step("Verify primary title text")
    public WelcomeScreen verifyPrimaryTitleText() {
        primaryText.shouldBe(visible);
        return this;
    }

    @Step("Verify secondary title text")
    public WelcomeScreen verifySecondaryTitleText() {
        secondaryText.shouldBe(visible);
        return this;
    }

    @Step("Verify default language is present")
    public WelcomeScreen verifyDefaultLanguagePresent() {
        languageOptions.first().shouldBe(visible);
        return this;
    }

    @Step("Verify language settings button is visible")
    public WelcomeScreen verifyLanguageSettingsButtonVisible() {
        languageButton.shouldBe(visible);
        return this;
    }

    @Step("Verify skip button is visible")
    public WelcomeScreen verifySkipButtonVisible() {
        skipButton.shouldBe(visible).shouldHave(text("Skip"));
        return this;
    }

    @Step("Verify continue button is visible")
    public void verifyContinueButtonVisible() {
        continueButton.shouldBe(visible).shouldHave(text("Continue"));
    }

    @Step("Skip onboarding flow")
    public MainScreen skipOnboarding() {
        skipButton.click();
        return new MainScreen();
    }

    @Step("Continue to discovery screen")
    public DiscoveryScreen continueToDiscoveryScreen() {
        continueButton.click();
        return new DiscoveryScreen();
    }

    @Step("Add or edit languages switch to languages screen")
    public WikipediaLanguagesScreen switchToLanguagesScreen() {
        languageButton.click();
        return new WikipediaLanguagesScreen();
    }
}