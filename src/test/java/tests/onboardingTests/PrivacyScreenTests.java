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
@Story("Privacy screen functionality")
@Tag("privacy")
@Tag("regression")
class PrivacyScreenTests extends TestBase {

    private PrivacyScreen privacyScreen;

    @BeforeEach
    @Step("Navigate to privacy screen")
    void navigateToPrivacyScreen() {
        privacyScreen = new WelcomeScreen()
                .continueToDiscoveryScreen()
                .continueToBookmarksScreen()
                .proceedToNextStep();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify privacy screen elements")
    void verifyPrivacyScreenElementsTest() {
        privacyScreen
                .verifyPrivacyScreenLoaded()
                .verifyPrivacyTitle()
                .verifyBeginButtonPresent();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Complete onboarding flow")
    void completeOnboardingShowsMainScreenTest() {
        privacyScreen
                .completeOnboarding()
                .verifyMainScreenLoaded();
    }
}