package tests.onboardingTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.WelcomeScreen;
import tests.TestBase;

@Feature("Onboarding Flow")
@Owner("efremovaa")
@Story("Welcome screen functionality")
@Tag("welcome")
@Tag("regression")
class WelcomeScreenTests extends TestBase {

    WelcomeScreen welcomeScreen = new WelcomeScreen();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("All elements welcome screen is visible and correct")
    void verifyElementsOnWelcomeScreenTest() {
        welcomeScreen
                .verifyWikipediaLogoVisible()
                .verifyPrimaryTitleText()
                .verifySecondaryTitleText()
                .verifyDefaultLanguagePresent()
                .verifyLanguageSettingsButtonVisible()
                .verifySkipButtonVisible()
                .verifyContinueButtonVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Skip onboarding shows main screen Wikipedia")
    void skipFromWelcomeScreenShowsMainWikipediaScreenTest() {
        welcomeScreen
                .skipOnboarding()
                .verifyMainScreenLoaded();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Continue from welcome screen shows discovery screen")
    void continueFromWelcomeScreenShowsDiscoverScreenTest() {
        welcomeScreen
                .continueToDiscoveryScreen()
                .verifyDiscoveryScreenLoaded();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Switch to languages setting screen")
    void switchToLanguageSettingsScreenTest() {
        welcomeScreen
                .switchToLanguagesScreen()
                .verifyDefaultLanguagePresent()
                .verifyAddLanguageButtonVisible();
    }
}