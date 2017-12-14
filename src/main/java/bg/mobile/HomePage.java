package bg.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.plamenti.Browser;;

public class HomePage extends BasePage {

	private final String url = "https://www.mobile.bg/";
	private final String title = "Mobile.bg – Българският автомобилен пазар: нови и втора употреба автомобили, джипове, камиони, мотоциклети...";
	private final String categoryToSelect = "Джипове";
	private final String categoryDefault = "Автомобили";

	// Example how to use Explicit wait
	private WebElement getEditButton() {
		By locator = By.className("editButton");
		WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return Browser.getDriver().findElement(locator);
	}

	private WebElement getAddButton() {
		By locator = By.className("addButton");
		WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return Browser.getDriver().findElement(locator);
	}

	private Select getMainCategory() {
		WebElement mainCategoriesContainer = Browser.getDriver().findElement(By.xpath("//select[@name = 'pubtype']"));
		Select mainCategories = new Select(mainCategoriesContainer);

		return mainCategories;
	}

	public void navigateTo() {
		Browser.navigate(url);
	}

	public boolean isCorrectTitle() {
		return Browser.title().equals(this.title);
	}

	public boolean isEditButtonPresent() {
		try {
			this.getEditButton();
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean isAddButtonPresent() {
		try {
			this.getAddButton();
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean isSelectedDefaultCategoryCorrect() {
		return this.getMainCategory().getFirstSelectedOption().getText().equals(this.categoryDefault);
	}

	public boolean isSelectedCategoryCorrect(String category) {
		return this.getMainCategory().getFirstSelectedOption().getText().equals(category);
	}

	public void selectCategory(String category) {
		this.getMainCategory().selectByVisibleText(category);
	}
}
