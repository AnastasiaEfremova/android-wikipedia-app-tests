package tests.onboardingTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.*;
import tests.TestBase;

@Feature("Onboarding Flow")
@Owner("efremovaa")
@Story("Discovery screen functionality")
@Tag("discovery")
@Tag("regression")
class DiscoveryScreenTests extends TestBase {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify discovery screen elements")
    void verifyDiscoveryScreenElementsTest() {
        DiscoveryScreen discoveryScreen = new WelcomeScreen()
                .continueToDiscoveryScreen();

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
        DiscoveryScreen discoveryScreen = new WelcomeScreen()
                .continueToDiscoveryScreen();

        discoveryScreen
                .skipOnboarding()
                .verifyMainScreenLoaded();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Continue from discovery to bookmarks screen")
    void continueFromDiscoveryToBookmarksScreenTest() {
        DiscoveryScreen discoveryScreen = new WelcomeScreen()
                .continueToDiscoveryScreen();

        discoveryScreen
                .continueToBookmarksScreen()
                .verifyBookmarksScreenLoaded();
    }
}