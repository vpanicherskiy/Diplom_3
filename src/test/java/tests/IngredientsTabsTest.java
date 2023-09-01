package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class IngredientsTabsTest extends BaseTest {
    @Test
    @DisplayName("Переход в раздел Соусы")
    public void checkSaucesTab() {
        homePage().clickSaucesTab();
        Assert.assertTrue(homePage().getSaucesTabAttributes().contains("tab_tab_type_current"));
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    public void checkFillingsTab() {
        homePage().clickFillingsTab();
        Assert.assertTrue(homePage().getFillingsTabAttributes().contains("tab_tab_type_current"));
    }

    @Test
    @DisplayName("Переход в раздел Булки")
    public void checkBunsTab() {
        homePage().clickSaucesTab();
        homePage().clickBunsTab();
        Assert.assertTrue(homePage().getBunsTabAttributes().contains("tab_tab_type_current"));
    }
}
