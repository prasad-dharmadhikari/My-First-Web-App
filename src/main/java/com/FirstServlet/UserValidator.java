package com.FirstServlet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    String ruleForUserName = "^[Cap][a-z]*$";
    String patternFor8characterPassword = "^.{8,}$";
    String patternForMinimumOneUpperCaseCharacter = ".*[A-Z]+.*";
    String patternForExactlyOneSpecialCharacter = "[A-Z0-9a-z]*[!@#%&][A-Z0-9a-z]*";
    String patternForMinimumOneNumericCharacter = ".*[0-9].*";

    public boolean validator(String regexPattern, String input) {
        Pattern p = Pattern.compile(regexPattern);
        Matcher matcher = p.matcher(input);
        return matcher.matches();
    }

    public boolean validateUserName(String username) {
        return validator(ruleForUserName, username);
    }

    public boolean validatePassword(String password) {
        boolean result = false;
        if (validator(patternFor8characterPassword, password))
            if (validator(patternForMinimumOneUpperCaseCharacter, password))
                if (validator(patternForMinimumOneNumericCharacter, password))
                    if (validator(patternForExactlyOneSpecialCharacter, password))
                        result = true;

        return result;
    }
}
