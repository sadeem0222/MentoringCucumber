package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.Driver;

public class InputValidatioPage {
    public InputValidatioPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "characters")
    private WebElement charactersInput;

    @FindBy(name = "validation_message")
    private WebElement validationMessage;

    @FindBy(name = "validate")
    private WebElement validateButton;

    public void enterCharacters(String text) {
        charactersInput.clear();
        if(text != null && !text.trim().isEmpty()) {
            charactersInput.sendKeys(text);
        } else {
            System.out.println("Skipping sendKeys because input is null or empty");
        }
    }
    public void clickValidate() {
        validateButton.click();
    }


    public String getValidationMessage() {
        return validationMessage.getAttribute("value");
    }

}
