package utils;


import org.apache.commons.lang3.RandomStringUtils;
public class MailGenerator {


    public String generateMail(){
        String mail;
        mail = RandomStringUtils.randomAlphabetic(10) + RandomStringUtils.randomNumeric(3);
        return mail + "@gmail.com";
    }
}
