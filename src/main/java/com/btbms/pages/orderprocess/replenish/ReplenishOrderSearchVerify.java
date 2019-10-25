package com.btbms.pages.orderprocess.replenish;

import com.btbms.config.Driver;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ReplenishOrderSearchVerify {
    private WebDriver driver;

    public ReplenishOrderSearchVerify(WebDriver driver) {
        this.driver = driver;
    }

    public void byRegisterUser(String value) {
        WebElement talbe = Driver.driver.findElement(By.xpath("//*[@id=\"Rpoheads\"]/div[1]/table"));

        List<WebElement> rows = talbe.findElements(By.tagName("tr"));
        //Get the first result
        if (rows.size()<2){
            Assertions.assertThat(rows).size().isGreaterThan(1);
        }
        List<WebElement> usersRegister = rows.get(1).findElements(By.tagName("td"));
        WebElement users = usersRegister.get(2);
        String result = users.getText();
        Assertions.assertThat(result.trim()).isEqualTo(value);

    }
}
