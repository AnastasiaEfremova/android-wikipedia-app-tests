package tests.onboardingTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import screens.WelcomeScreen;
import tests.TestBase;

@Feature("Languages Selection")
@Owner("efremovaa")
@Story("Language selection screen functionality")
@Tag("languages")
@Tag("regression")
class LanguageSettingsScreenTests extends TestBase {

    WelcomeScreen welcomeScreen = new WelcomeScreen();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Navigate to Add language screen and verify elements")
    void verifyAddLanguageScreenElementsTest() {
        welcomeScreen
                .switchToLanguagesScreen()
                .tapOnAddLanguageButton()
                .verifyHeaderElements();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify languages list is not empty")
    void verifyLanguagesListIsNotEmptyTest() {
        welcomeScreen
                .switchToLanguagesScreen()
                .tapOnAddLanguageButton()
                .verifyLanguagesListNotEmpty();
    }

    @ParameterizedTest
    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {"Español", "Deutsch", "中文（马来西亚"})
    @DisplayName("Select specific language from the list")
    void selectLanguageFromListTest(String language) {
        welcomeScreen
                .switchToLanguagesScreen()
                .tapOnAddLanguageButton()
                .selectLanguage(language);
    }
}