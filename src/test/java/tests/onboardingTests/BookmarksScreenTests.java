package tests.onboardingTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
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

    private BookmarksScreen bookmarksScreen;

    @BeforeEach
    @Step("Navigate to bookmarks screen")
    void navigateToBookmarksScreen() {
        bookmarksScreen = new WelcomeScreen()
                .continueToDiscoveryScreen()
                .continueToBookmarksScreen();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify bookmarks screen elements")
    void verifyBookmarksScreenElementsTest() {
        bookmarksScreen
                .verifyBookmarksScreenLoaded()
                .verifyPrimaryTitle()
                .verifySkipOptionVisible();
    }

    @Test
    @DisplayName("Skip onboarding from bookmarks screen")
    @Severity(SeverityLevel.NORMAL)
    void skipFromBookmarksScreenShowsMainScreenTest() {
        bookmarksScreen
                .skipOnboarding()
                .verifyMainScreenLoaded();
    }

    @Test
    @DisplayName("Continue from bookmarks to privacy screen")
    @Severity(SeverityLevel.BLOCKER)
    void continueFromBookmarksToPrivacyScreenTest() {
        bookmarksScreen
                .proceedToNextStep()
                .verifyPrivacyScreenLoaded();
    }
}