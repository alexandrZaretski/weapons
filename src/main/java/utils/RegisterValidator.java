package utils;


import static utils.SignUpValdator.*;

public class RegisterValidator {
    public static boolean checkRegistration(String firstName, String surName, String yearsOld, String email, String password) {

        return isUserNameCorrect(firstName) &&
                isUserSurnameCorrect(surName) &&
                isUserYearsOldCorrect(yearsOld) &&
                isUserEmailCorrect(email) &&
                isUserPasswordCorrect(password);
    }
}