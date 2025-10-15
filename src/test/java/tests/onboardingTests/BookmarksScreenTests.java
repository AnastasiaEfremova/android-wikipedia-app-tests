package tests.onboardingTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.*;
import tests.TestBase;

@Feature("Onboarding Flow")
@Owner("efremovaa")
@Story("Bookmarks screen functionality")
@Tag("bookmarks")
@Tag("regression")
class BookmarksScreenTests extends TestBase {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify bookmarks screen elements")
    void verifyBookmarksScreenElementsTest() {
        BookmarksScreen bookmarksScreen = new WelcomeScreen()
                .continueToDiscoveryScreen()
                .continueToBookmarksScreen();

        bookmarksScreen
                .verifyBookmarksScreenLoaded()
                .verifyPrimaryTitle()
                .verifySkipOptionVisible();
    }

    @Test
    @DisplayName("Skip onboarding from bookmarks screen")
    @Severity(SeverityLevel.NORMAL)
    void skipFromBookmarksScreenShowsMainScreenTest() {
        BookmarksScreen bookmarksScreen = new WelcomeScreen()
                .continueToDiscoveryScreen()
                .continueToBookmarksScreen();

        bookmarksScreen
                .skipOnboarding()
                .verifyMainScreenLoaded();
    }

    @Test
    @DisplayName("Continue from bookmarks to privacy screen")
    @Severity(SeverityLevel.BLOCKER)
    void continueFromBookmarksToPrivacyScreenTest() {
        BookmarksScreen bookmarksScreen = new WelcomeScreen()
                .continueToDiscoveryScreen()
                .continueToBookmarksScreen();

        bookmarksScreen
                .proceedToNextStep()
                .verifyPrivacyScreenLoaded();
    }
}