package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import org.junit.jupiter.api.Test;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Email;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Password;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TaxIdentification;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Username;
import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;
import pt.isep.arqsoft.gorgeousSandwich.ValueObjects.*;

import static com.mongodb.assertions.Assertions.assertTrue;
import static com.mongodb.assertions.Assertions.fail;

class UserTest {
    String invalidString = "";
    String validStringEmail = "blahblah@isep.ipp.pt";
    String validStringPassword = "Umapassword3";
    String validStringUsername = "1180658";
    String validTaxId = "234234234";


    @Test
    void businessValidation() {

        try {
            User userEmail = new TestUser(new Email(invalidString), new Password(validStringPassword), new TaxIdentification(validTaxId), new Username(validStringUsername));
            fail(String.format("Email " + invalidString + " cannot be neither null nor empty and needs to have one @"));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            User userPassword = new TestUser(new Email(validStringEmail), new Password(invalidString), new TaxIdentification(validTaxId), new Username(validStringUsername));
            fail(String.format("Password " + invalidString  + " cannot be neither null nor empty, needs to be at least 8 characters long, have 1 number and 1 capitalized letter. "));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            User userTaxId = new TestUser(new Email(validStringEmail), new Password(validStringPassword), new TaxIdentification(invalidString), new Username(validStringUsername));
            fail(String.format("Tax Identification " + invalidString + " cannot be neither null nor empty and it needs to be 9 characters long"));
        } catch (BusinessRuleViolationException ignored) {
        }

        try {
            User userUsername = new TestUser(new Email(validStringEmail), new Password(validStringPassword), new TaxIdentification(validTaxId), new Username(invalidString));
            fail(String.format("Username " + invalidString  + " cannot be neither null nor empty."));
        } catch (BusinessRuleViolationException ignored) {
        }
    }


    @Test
    void getEmail() {
        try {
            Email email = new Email(validStringEmail);
            User u = new TestUser(email, new Password(validStringPassword), new TaxIdentification(validTaxId), new Username(validStringUsername));
            assertTrue(email.equals(u.getEmail()));
        } catch (BusinessRuleViolationException e) {
            fail();
        }

    }

    @Test
    void getPassword() {
        try {
            Password password = new Password(validStringPassword);
            User u = new TestUser(new Email(validStringEmail), password, new TaxIdentification(validTaxId), new Username(validStringUsername));
            assertTrue(password.equals(u.getPassword()));
        } catch (BusinessRuleViolationException e) {
            fail();
        }
    }

    @Test
    void getTaxIdentification() {
        try {
            TaxIdentification taxId = new TaxIdentification(validTaxId);
            User u = new TestUser(new Email(validStringEmail), new Password(validStringPassword), taxId, new Username(validStringUsername));
            assertTrue(taxId.equals(u.getTaxIdentification()));
        } catch (BusinessRuleViolationException e) {
            fail();
        }
    }

    @Test
    void getUsername() {
        try {
            Username username = new Username(validStringUsername);
            User u = new TestUser(new Email(validStringEmail), new Password(validStringPassword), new TaxIdentification(validTaxId), username);
            assertTrue(username.equals(u.getUsername()));
        } catch (BusinessRuleViolationException e) {
            fail();
        }
    }

    private static class TestUser extends User {

        TestUser(Email email, Password password, TaxIdentification taxIdentification, Username username) {
            super(email,password,taxIdentification,username);
        }


    }
}

