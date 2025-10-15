package tests.onboardingTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.DiscoveryScreen;
import screens.WelcomeScreen;
import tests.TestBase;

@Feature("Onboarding Flow")
@Owner("efremovaa")
@Story("Discovery screen functionality")
@Tag("discovery")
class DiscoveryScreenTests extends TestBase {

    private DiscoveryScreen discoveryScreen;

    @BeforeEach
    void navigateToDiscoveryScreen() {
        discoveryScreen = new WelcomeScreen()
                .continueToDiscoveryScreen();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify discovery screen elements")
    void verifyDiscoveryScreenElementsTest() {
        discoveryScreen
                .verifyDiscoveryScreenLoaded()
                .verifyDiscoveryImage()
                .verifyDiscoveryTitle()
                .verifySecondaryTitle()
                .verifySkipOptionVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Skip onboarding from discovery screen")
    void skipFromDiscoveryScreenShowsMainScreenTest() {
        discoveryScreen
                .skipOnboarding()
                .verifyMainScreenLoaded();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Continue from discovery to bookmarks screen")
    void continueFromDiscoveryToBookmarksScreenTest() {
        discoveryScreen
                .continueToBookmarksScreen()
                .verifyBookmarksScreenLoaded();
    }
}