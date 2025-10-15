package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {

    private final SelenideElement mainToolbar = $(id("org.wikipedia.alpha:id/main_toolbar"));
    private final SelenideElement searchContainer = $(id("org.wikipedia.alpha:id/search_container"));
    private final SelenideElement exploreTab = $(id("org.wikipedia.alpha:id/nav_tab_explore"));

    @Step("Verify main screen is loaded")
    public void verifyMainScreenLoaded() {
        mainToolbar.shouldBe(visible);
        searchContainer.shouldBe(visible);
        exploreTab.shouldBe(visible);
    }

}