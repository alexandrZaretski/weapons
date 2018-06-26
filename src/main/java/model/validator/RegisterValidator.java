package model.validator;


import static model.validator.SignUpValdator.*;

public class RegisterValidator {
    public static boolean checkRegistration(String firstName, String phone, String adress, String email, String password) {

        return isUserNameCorrect(firstName) &&
                isUserYearsOldCorrect(phone) &&
                isUserNameCorrect(adress) &&
                isUserEmailCorrect(email) &&
                isUserPasswordCorrect(password);
    }
}