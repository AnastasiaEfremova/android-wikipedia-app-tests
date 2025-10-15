package tests.onboardingTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.*;
import tests.TestBase;

@Feature("Onboarding Flow")
@Owner("efremovaa")
@Story("Complete onboarding journey")
@Tag("smoke")
class CompleteOnboardingIntegrationTest extends TestBase {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Complete full onboarding flow successfully")
    void completeFullOnboardingFlowTest() {
        // Шаг 1: Приветственный экран
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen
                .verifyWikipediaLogoVisible()
                .verifyPrimaryTitleText()
                .verifySecondaryTitleText()
                .verifyDefaultLanguagePresent()
                .verifyLanguageSettingsButtonVisible()
                .verifySkipButtonVisible()
                .verifyContinueButtonVisible();

        // Шаг 2: Переход на экран Discovery
        DiscoveryScreen discoveryScreen = welcomeScreen.continueToDiscoveryScreen();
        discoveryScreen
                .verifyDiscoveryScreenLoaded()
                .verifyDiscoveryImage()
                .verifyDiscoveryTitle()
                .verifySecondaryTitle()
                .verifySkipOptionVisible();

        // Шаг 3: Переход на экран Bookmarks
        BookmarksScreen bookmarksScreen = discoveryScreen.continueToBookmarksScreen();
        bookmarksScreen
                .verifyBookmarksScreenLoaded()
                .verifyPrimaryTitle()
                .verifySkipOptionVisible();

        // Шаг 4: Переход на экран Privacy
        PrivacyScreen privacyScreen = bookmarksScreen.proceedToNextStep();
        privacyScreen
                .verifyPrivacyScreenLoaded()
                .verifyPrivacyTitle()
                .verifyBeginButtonPresent();

        // Шаг 5: Завершение онбординга
        MainScreen mainScreen = privacyScreen.completeOnboarding();
        mainScreen.verifyMainScreenLoaded();
    }
}