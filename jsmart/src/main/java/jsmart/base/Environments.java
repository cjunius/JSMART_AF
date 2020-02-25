package jsmart.base;

public enum Environments {

    PROD {
        public String getURL() { return "https://www.google.com"; }
    },

    STAGING {
        public String getURL() { return "https://www.google.com"; }
    }


    ;

    public abstract String getURL();
}
