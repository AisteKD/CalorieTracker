package lt.techin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "item-name")
    WebElement addItem;

    @FindBy(id = "item-calories")
    WebElement addCalories;

    @FindBy(xpath = "//form[@class='col']//button[1]")
    WebElement addMealbutton;

    @FindBy(id = "item-list")
    WebElement getCaloriesText;

    @FindBy(xpath = "//ul[@id='item-list']/li[1]//i")
    WebElement getItemIconButton;

    @FindBy(xpath = "//form//button[3]")
    WebElement deleteMealButton;

    @FindBy(xpath = "//*[@id=\"item-list\"]")
    WebElement getItemsListAfterDeleted;

    @FindBy(css = ".secondary-content")
    List<WebElement>  clickIconforUpdating;

    @FindBy(xpath = "//form//button[2]")
    WebElement clickUpdateMealButton;

    @FindBy(xpath = "//li//a")
    WebElement clickClearAllButton;
    @FindBy(css = ".collection-item")
    List<WebElement> elements;

    @FindBy(xpath = "//h3[@class='center-align']")
    WebElement totalCalories;

    public void enterItem(String item) {
        waitForElement(addItem);
        addItem.sendKeys(item);
    }

    public void enterCalories(int calories) {
        addCalories.sendKeys(Integer.toString(calories));
    }

    public void clickAddMealButton() {
        addMealbutton.click();
    }

    public String getCaloriesText() {
        waitForElement(getCaloriesText);
        return getCaloriesText.getText();
    }

    public void clickItemIconButton() {
        getItemIconButton.click();
    }

    public void clickDeleteMealButton() {
        deleteMealButton.click();
    }

    public String getItemsList() {
        return getItemsListAfterDeleted.getText();
    }

    public void clickItemIconforUpdatingButton(int updateButtonIndex) {
        clickIconforUpdating.get(updateButtonIndex).click();
    }

    public void clearCaloriesInput() {
        addCalories.clear();
    }

    public void clickUpdateButton() {
        clickUpdateMealButton.click();
    }

    public void clickAllClearButton() {
        clickClearAllButton.click();
    }

    public List<String> getProductNames() {
        ArrayList<String> mealsNames = new ArrayList<>();
        for (WebElement element : elements) {
            mealsNames.add(element.getText().split(":")[0]);
        }
        return mealsNames;
    }

    public int getProductListSize() {
        return elements.size();
    }

    public int getTotalCalories() {
        return Integer.parseInt(totalCalories.getText().split(": ")[1]);
    }

    public ArrayList<Integer> getProductColories() {
        ArrayList<Integer> mealsColories = new ArrayList<>();
        for (WebElement element : elements) {
            mealsColories.add(Integer.parseInt(element.getText().split(" ")[1]));
        }
        return mealsColories;
    }

    public int getProductColoriesSum() {
        ArrayList<Integer> mealsColories = getProductColories();
        return getProductColories().stream().mapToInt(Integer::intValue).sum();
//        int sum = 0;
//        for (int colories : mealsColories) {
//            sum = sum + colories;
//        }
//        return sum;
    }

//    public ArrayList<Integer> getUpdatedCalories() {
//        ArrayList<Integer> updatesColories = new ArrayList<>();
//        for (WebElement element : elements) {
//            updatesColories.add(Integer.parseInt(element.getText().split(" ")[1]));
//        }
//        return updatesColories;
//    }

}
