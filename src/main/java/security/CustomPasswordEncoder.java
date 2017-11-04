package security;

import exceptions.PasswordEncodingException;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        String result = md5(rawPassword) + "sadasfdsa";
        result = new StringBuilder(result).reverse().toString();
        result = md5(result);
        return result;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

    private static String md5(CharSequence password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = password.toString().getBytes("UTF-8");
            byte[] encodedPassword = md.digest(passwordBytes);
            return new String(encodedPassword, "UTF-8");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new PasswordEncodingException("Unpredicted exception has been generated : ", e);
        }
    }
}
