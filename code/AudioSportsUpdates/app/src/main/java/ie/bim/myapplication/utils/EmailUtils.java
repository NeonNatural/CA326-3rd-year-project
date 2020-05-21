package ie.bim.myapplication.utils;

public class EmailUtils {

    public static boolean validateEmail(String email) {
        return email.contains("@");
    }

}
