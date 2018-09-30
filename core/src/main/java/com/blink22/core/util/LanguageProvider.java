package com.blink22.core.util;

/**
 * Created by m.hemdan on 11/17/17.
 */

public class LanguageProvider {
    private static String currentLanguage = "en";

    public String getCurrentLanguage() {
        return currentLanguage;
    }

    public static void setCurrentLanguage(String newLanguage) {
        currentLanguage = newLanguage;
    }
}
