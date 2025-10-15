package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class DiscoveryScreen {

    private final SelenideElement image = $(id("org.wikipedia.alpha:id/imageViewCentered"));
    private final SelenideElement primaryText = $(id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement secondaryText = $(id("org.wikipedia.alpha:id/secondaryTextView"));
    private final SelenideElement skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));
    private final SelenideElement continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    private static final String EXPECTED_PRIMARY_TEXT = "New ways to explore";
    private static final String EXPECTED_SECONDARY_TEXT = "Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. \n" +
            "Customize the feed to your interests – whether it’s learning about historical events On this day, or rolling the dice with Random.";

    @Step("Verify discovery screen is loaded")
    public DiscoveryScreen verifyDiscoveryScreenLoaded() {
        primaryText.shouldBe(visible);
        secondaryText.shouldBe(visible);
        return this;
    }

    @Step("Verify discovery image is visible")
    public DiscoveryScreen verifyDiscoveryImage() {
        image.shouldBe(visible);
        return this;
    }

    @Step("Verify discovery title text")
    public DiscoveryScreen verifyDiscoveryTitle() {
        primaryText.shouldHave(text(EXPECTED_PRIMARY_TEXT));
        return this;
    }

    @Step("Verify discovery secondary text")
    public DiscoveryScreen verifySecondaryTitle() {
        secondaryText.shouldHave(text(EXPECTED_SECONDARY_TEXT));
        return this;
    }

    @Step("Verify skip option is visible")
    public void verifySkipOptionVisible() {
        skipButton.shouldBe(visible).shouldHave(text("Skip"));
    }

    @Step("Continue to bookmarks onboarding screen")
    public BookmarksScreen continueToBookmarksScreen() {
        continueButton.click();
        return new BookmarksScreen();
    }

    @Step("Skip onboarding from discovery screen")
    public MainScreen skipOnboarding() {
        skipButton.click();
        return new MainScreen();
    }
}