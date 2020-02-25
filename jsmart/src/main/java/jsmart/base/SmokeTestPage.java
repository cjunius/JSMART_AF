package jsmart.base;

public interface SmokeTestPage {

    public SmokeTestPage navigateTo();
    public PageValidations verify();

    public abstract class PageValidations {
        public abstract PageValidations pageLoaded();
    }

}
