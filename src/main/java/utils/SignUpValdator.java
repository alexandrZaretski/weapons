package utils;

import java.util.regex.Pattern;


import static utils.ValidatorConstant.*;

public class SignUpValdator {

    //private final static String EMAIL_REGEX = "\\w+@[a-zA-Z]+[.][a-zA-Z]+";

    public static boolean isUserNameCorrect(String username) {
        return (Pattern.matches(USER_NAME_REGEX, username));
    }

    public static boolean isUserSurnameCorrect(String surname) {
        return Pattern.matches(USER_NAME_REGEX, surname);
    }

    public static boolean isUserYearsOldCorrect(String yearOld) {
        return Pattern.matches(USER_YEARS_OLD_REGEX, yearOld);
    }

    public static boolean isUserEmailCorrect(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isUserPasswordCorrect(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    public static boolean isCommentCorrect(String comment) {
        return Pattern.matches(COMMENT_REGEX, comment);
    }

}