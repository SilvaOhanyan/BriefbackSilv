package com.company.commons;

import java.security.SecureRandom;

public class UIDGenerator {
    public static String getUID;
    private static volatile SecureRandom numberGenerator = null;
    private static final long MSB = 0x8000000000000000L;

    public static String getUID() {
        SecureRandom ng = numberGenerator;
        if (ng == null) {
            numberGenerator = ng = new SecureRandom();
        }

        return Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
    }
}
