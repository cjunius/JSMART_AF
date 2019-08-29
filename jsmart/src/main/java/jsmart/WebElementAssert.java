package jsmart;

import org.openqa.selenium.WebElement;

import org.assertj.core.api.AbstractAssert;;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    public WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement webElement){
        return new WebElementAssert(webElement);
    }

    public WebElementAssert isDisplayed(){
        isNotNull();

        if(!actual.isDisplayed()){
            failWithMessage("Expected element to be displayed. But was not!!");
        }
        
        return this;
    }

    public WebElementAssert isEnabled(){
        isNotNull();

        if(!actual.isEnabled()){
            failWithMessage("Expected element to be enabled. But was not!!");
        }

        return this;
    }

    public WebElementAssert isButton(){
        isNotNull();

        if(!(actual.getTagName().equalsIgnoreCase("button") || actual.getAttribute("type").equalsIgnoreCase("button"))){
            failWithMessage("Expected element to be a button. But was not!!");
        }

        return this;
    }

    public WebElementAssert isLink(){
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("a")){
            failWithMessage("Expected element to be a link. But was not!!");
        }

        return this;
    }

    public WebElementAssert isCheckbox() {
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("input") || !actual.getAttribute("type").equalsIgnoreCase("checkbox")) {
            failWithMessage("Expected element to be a Checkbox. But was not!!");
        }

        return this;
    }

    public WebElementAssert isRadio() {
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("input") || !actual.getAttribute("type").equalsIgnoreCase("radio")) {
            failWithMessage("Expected element to be a Radio. But was not!!");
        }

        return this;
    }

    public WebElementAssert isSelected() {
        isNotNull();

        if(!actual.isSelected()) {
            failWithMessage("Expected element to be selected. But was not!!");
        }

        return this;
    }

    public WebElementAssert isFileInput() {
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("input") || !actual.getAttribute("type").equalsIgnoreCase("file")) {
            failWithMessage("Expected element to be a file input. But was not!!");
        }

        return this;
    }

    public WebElementAssert isSubmit() {
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("input") || !actual.getAttribute("type").equalsIgnoreCase("submit") {
            failWithMessage("Expected element to be a submit. But was not!!");
        }

        return this;
    }

    public WebElementAssert isTextbox() {
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("input") || !actual.getAttribute("type").equalsIgnoreCase("text")) {
            failWithMessage("Expected element to be a Textbox. But was not!!");
        }

        return this;
    }

    public WebElementAssert isTextArea() {
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("textarea")) {
            failWithMessage("Expected element to be a Textbox. But was not!!");
        }

        return this;
    }

    public WebElementAssert isDropdown() {
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("select")) {
            failWithMessage("Expected element to be a Dropdown. But was not!!");
        }

        return this;
    }

    public WebElementAssert isImage() {
        isNotNull();
        
        if(!actual.getTagName().equalsIgnoreCase("img")) {
            failWithMessage("Expected element to be an image. But was not!!");
        }

        return this;
    }

    public WebElementAssert hasText(String value){
        isNotNull();

        if(!actual.getText().equals(value)){
            failWithMessage("Expected element to have Text <%s>. But it did not!!", value);
        }

        return this;
    }

    public WebElementAssert hasAttributeValue(String attr, String value){
        isNotNull();

        if(!actual.getAttribute(attr).equals(value)){
            failWithMessage("Expected element to have attr <%s> value as <%s>. But was not!!", attr, value);
        }

        return this;
    }

    public WebElementAssert containsAttributeValue(String attr, String value) {
        isNotNull();

        if(!actual.getAttribute(attr).contains(value)) {
            failWithMessage("Expected element to have attr <%s> containing value <%s>. But it did not!!", attr, value);
        }

        return this;
    }

}