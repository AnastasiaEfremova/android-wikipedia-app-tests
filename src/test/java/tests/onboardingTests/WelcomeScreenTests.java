package tests.onboardingTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.*;
import tests.TestBase;

@Feature("Onboarding Flow")
@Owner("efremovaa")
@Story("Welcome screen functionality")
@Tag("welcome")
@Tag("regression")
class WelcomeScreenTests extends TestBase {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("All elements welcome screen is visible and correct")
    void verifyElementsOnWelcomeScreenTest() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();

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
        WelcomeScreen welcomeScreen = new WelcomeScreen();

        welcomeScreen
                .skipOnboarding()
                .verifyMainScreenLoaded();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Continue from welcome screen shows discovery screen")
    void continueFromWelcomeScreenShowsDiscoverScreenTest() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();

        welcomeScreen
                .continueToDiscoveryScreen()
                .verifyDiscoveryScreenLoaded();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Switch to languages setting screen")
    void switchToLanguageSettingsScreenTest() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();

        welcomeScreen
                .switchToLanguagesScreen()
                .verifyDefaultLanguagePresent()
                .verifyAddLanguageButtonVisible();
    }
}