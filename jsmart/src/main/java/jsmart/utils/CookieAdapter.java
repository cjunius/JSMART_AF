package jsmart.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CookieAdapter {

    public org.openqa.selenium.Cookie convertToSelenium(io.restassured.http.Cookie cookie) {

        org.openqa.selenium.Cookie.Builder cookieBuilder = 
                new org.openqa.selenium.Cookie.Builder(cookie.getName(), cookie.getValue());

        if(cookie.hasDomain()) {
            cookieBuilder.domain(cookie.getDomain());
        }

        if(cookie.hasExpiryDate()) {
            cookieBuilder.expiresOn(cookie.getExpiryDate());
        } else if(cookie.hasMaxAge()) {
            Calendar expiryDate = Calendar.getInstance();
            expiryDate.setTimeZone(TimeZone.getTimeZone("GMT"));
            expiryDate.add(Calendar.SECOND, cookie.getMaxAge());
            cookieBuilder.expiresOn(expiryDate.getTime());
        }

        if(cookie.hasPath()) {
            cookieBuilder.path(cookie.getPath());
        }

        if(cookie.hasComment()) {
            System.out.println("Selenium Cookie does not support addition of a comment");
        }

        if(cookie.hasVersion()) {
            System.out.println("Selenium Cookie does not support addition of a version");
        }

        cookieBuilder.isSecure(cookie.isSecured());
        cookieBuilder.isHttpOnly(cookie.isHttpOnly());

        return cookieBuilder.build();
    }

    public io.restassured.http.Cookie convertToRestAssured(org.openqa.selenium.Cookie cookie) {

        io.restassured.http.Cookie.Builder cookieBuilder = 
                new io.restassured.http.Cookie.Builder(cookie.getName(), cookie.getValue());

        String domain = cookie.getDomain();
        if(domain != null) {
            cookieBuilder.setDomain(domain);
        }

        String path = cookie.getPath();
        if(path != null) {
            cookieBuilder.setPath(path);
        }

        Date expiry = cookie.getExpiry();
        if(expiry != null) {
            cookieBuilder.setExpiryDate(expiry);
        }

        cookieBuilder.setSecured(cookie.isSecure());
        cookieBuilder.setHttpOnly(cookie.isHttpOnly());

        return cookieBuilder.build();

    }

}
