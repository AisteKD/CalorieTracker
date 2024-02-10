package lt.techin.Test;

import lt.techin.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends BasePageTest {

    @Test
    void shouldAddItemsAndSum() {
        String newItemText = "Butter";
        homePage.enterItem(newItemText);

        int newItemTextCalories = 800;
        homePage.enterCalories(newItemTextCalories);

        homePage.clickAddMealButton();

        String newItemText1 = "Chocolate";
        homePage.enterItem(newItemText1);

        int newItemTextCalories1 = 600;
        homePage.enterCalories(newItemTextCalories1);

        homePage.clickAddMealButton();

        int actualListSize = homePage.getProductListSize();
        int expectedListSize = 2;
        Assertions.assertEquals(expectedListSize, actualListSize);
        System.out.println(actualListSize);

        List<String> names = homePage.getProductNames();
        System.out.println(names);

        int totalSum = homePage.getTotalCalories();
        int allProductColoriesSum = homePage.getProductColoriesSum();
        Assertions.assertEquals(totalSum, allProductColoriesSum);
        System.out.println(allProductColoriesSum);

        //List<Integer> colories = homePage.getProductColories();
        //System.out.println(colories);
    }

    @Test
    void shouldAddItemsWhenOneInputIsEmpty() {
        String newItemText = "Butter";
        homePage.enterItem(newItemText);
        palaukti();
        homePage.clickAddMealButton();
        palaukti();

        int actualListSize = homePage.getProductListSize();
        int expectedListSize = 0;
        Assertions.assertEquals(expectedListSize, actualListSize, "message ");
        palaukti();

        List<String> names = homePage.getProductNames();
        System.out.println(names);
        palaukti();
    }

    @Test
    void shouldUpdateItem() {
        String newItemText = "Butter";
        homePage.enterItem(newItemText);
        int newItemTextCalories = 800;
        homePage.enterCalories(newItemTextCalories);
        homePage.clickAddMealButton();
        homePage.clickItemIconforUpdatingButton(0);
        homePage.clearCaloriesInput();
        int newItemTextCaloriesUpdated = 802;
        homePage.enterCalories(newItemTextCaloriesUpdated);
        homePage.clickUpdateButton();

        String newItemText2 = "Chocolate";
        homePage.enterItem(newItemText2);
        int newItemTextCalories2 = 600;
        homePage.enterCalories(newItemTextCalories2);
        homePage.clickAddMealButton();
        homePage.clickItemIconforUpdatingButton(1);
        homePage.clearCaloriesInput();
        int newItemTextCaloriesUpdated2 = 601;
        homePage.enterCalories(newItemTextCaloriesUpdated2);
        homePage.clickUpdateButton();

        ArrayList<Integer> updateColoriesList = homePage.getProductColories();
        //System.out.println(updateColoriesList);

        int updatedCalories = updateColoriesList.get(0);
        int expectedUpdatedCalories = 802;
        Assertions.assertEquals(expectedUpdatedCalories, updatedCalories);
        //System.out.println(updatedCalories);

        int updatedCalories1 = updateColoriesList.get(1);
        int expectedUpdatedCalories1 = 601;
        Assertions.assertEquals(expectedUpdatedCalories1, updatedCalories1);
        //System.out.println(updatedCalories);
    }

    @ParameterizedTest
    @Timeout(10)
    @CsvFileSource(files = "src/test/resources/products.csv", numLinesToSkip = 1)
    void shouldUpdateItemParams(String newItemText, int newItemTextCalories, int newItemTextCaloriesUpdated) {

        homePage.enterItem(newItemText);
        homePage.enterCalories(newItemTextCalories);
        homePage.clickAddMealButton();
        homePage.clickItemIconforUpdatingButton(0);
        homePage.clearCaloriesInput();
        homePage.enterCalories(newItemTextCaloriesUpdated);
        homePage.clickUpdateButton();

        ArrayList<Integer> updateColoriesList = homePage.getProductColories();

        int updatedCalories = updateColoriesList.get(0);
        Assertions.assertEquals(newItemTextCaloriesUpdated, updatedCalories);
    }

    @Test
    void shouldDeleteItem() {

        String newItemText = "Butter";
        homePage.enterItem(newItemText);
        int newItemTextCalories = 800;
        homePage.enterCalories(newItemTextCalories);
        homePage.clickAddMealButton();

        homePage.clickItemIconforUpdatingButton(0);
        homePage.clearCaloriesInput();
        int newItemTextCalories4 = 802;
        homePage.enterCalories(newItemTextCalories4);
        homePage.clickUpdateButton();

        homePage.clickItemIconButton();
        homePage.clickDeleteMealButton();

        int actualListSize = homePage.getProductListSize();
        int expectedListSize = 0;
        Assertions.assertEquals(expectedListSize, actualListSize);

    }

    @Test
    void shouldDeleteAllItems() {

        String newItemText = "Butter";
        homePage.enterItem(newItemText);
        palaukti();
        int newItemTextCalories = 800;
        homePage.enterCalories(newItemTextCalories);
        palaukti();
        homePage.clickAddMealButton();
        palaukti();
        homePage.clickAllClearButton();
        palaukti();
    }
}
