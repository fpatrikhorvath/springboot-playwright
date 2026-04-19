package com.playwright.framework.service.util;

import io.cucumber.spring.ScenarioScope;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

@Service
@ScenarioScope
public class ExtendedFakerService extends Faker {

    public String generateSsn() {
        final String areaNumber   = String.format("%03d", number().numberBetween(1, 900));
        final String groupNumber  = String.format("%02d", number().numberBetween(1, 100));
        final String serialNumber = String.format("%04d", number().numberBetween(1, 10000));

        return String.join("-", areaNumber, groupNumber, serialNumber);
    }

    public String generatePassword() {
        final String upperCaseLetters = lorem().characters(4, 6, true).toUpperCase();
        final String lowerCaseLetters = lorem().characters(4, 8, false).toLowerCase();
        final String digits           = number().digits(1);
        final String specialChars     = regexify("[!@#$%^&*()_+]");

        return String.join("-", upperCaseLetters, lowerCaseLetters, digits, specialChars);
    }
}