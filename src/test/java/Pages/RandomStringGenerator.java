package Pages;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RandomStringGenerator {
    static Faker faker = new Faker();
    public static String randomFirstName() {
        return faker.name().firstName();
    }
    public static String randomLastName() {
        return faker.name().lastName();
    }
    public static String randomEmail(){
        return faker.internet().emailAddress();
    }
    public static String randomPhone(){
        return faker.phoneNumber().cellPhone();
    }
    public static String randomPassword(){
        return faker.internet().password();
    }
    public static String randomQuote(){
        return faker.yoda().quote();
    }
    public static String randomDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(faker.date().future(1, TimeUnit.DAYS)).toString();
    }
    public static String randomTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(faker.date().future(1, TimeUnit.DAYS)).toString();
    }
}