package utilities;

import java.awt.*;

public class finalVariables {
    public static final String invalidUnamePwrd = "Epic sadface: Username and password do not match any user in this service";
    public static final String unameRequired = "Epic sadface: Username is required";
    public static final String pwrdRequired = "Epic sadface: Password is required";

    public static String[] getErrorMessage(){
        return new String[]{invalidUnamePwrd,unameRequired,pwrdRequired};
    }

}
