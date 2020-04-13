package PageObjects;

import Utilities.BaseTestGui;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTestGui {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "log-in")
    WebElement loginField;

    @FindBy(linkText = "Join Now")
    WebElement joinnowLink;

    @FindBy(xpath = "//h3[text()='Home and Renters Insurance']")
    WebElement headerHomeRentersInsurance;

    @FindBy(xpath = "//div/a[@href='/inet/pages/insurance_home_condo?wa_ref=pub_home_homeowners']")
    WebElement btnHomeowners;

    @FindBy(xpath = "//div/a[@href='/inet/pages/insurance_home_renters?wa_ref=pub_home_renters']")
    WebElement btnRenters;

    public void verifyHomeRentersInsuranceSection() {
        try {
            headerHomeRentersInsurance.isDisplayed();
            log.info("'Home and Renters Insurance' header on home page is displayed");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void clickHomeownersInsuranceButton() {
        try {
            btnHomeowners.click();
            log.info("Homeowners button was clicked");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void clickRentersInsuranceButton() {
        try {
            btnRenters.click();
            log.info("Renters button was clicked");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    
}
