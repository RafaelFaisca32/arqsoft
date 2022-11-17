package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreatingUserDto {

    public String email;
    public String password;
    public String taxIdentification;
    public String username;

    public CreatingUserDto(String email, String password, String taxIdentification, String username) {
        this.email = email;
        this.password = password;
        this.taxIdentification = taxIdentification;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTaxIdentification() {
        return taxIdentification;
    }

    public void setTaxIdentification(String taxIdentification) {
        this.taxIdentification = taxIdentification;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //<editor-fold desc="Needed for testing shops and promotions">
    public String id;
    public CreatingUserDto(String email, String password, String taxIdentification, String username, String id) throws NoSuchAlgorithmException {
        this.email = email;
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(password.getBytes());
        byte[] bytes = m.digest();
        StringBuilder s = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        this.password = s.toString() + "A";
        this.taxIdentification = taxIdentification;
        this.username = username;
        this.id = id;
    }

    private CreatingUserDto(){}

    public String getId() {
        return id;
    }
    //</editor-fold>


}
