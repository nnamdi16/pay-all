package com.nnamdi.payall.model.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.UUID;

public enum ID {

    INSTANCE;
    private static final Random RANDOM1;
    private static final Random RANDOM2;

    private static final Random RANDOM3;

    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final long GLOBAL_PROCESS_ID;

    static Logger log = LoggerFactory.getLogger(ID.class);

    static {
        long time = System.currentTimeMillis();
        long nanoTime = System.nanoTime();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long addressHashCode;
        try {
            InetAddress inetAddress;
            inetAddress = InetAddress.getLocalHost();
            addressHashCode = inetAddress.getHostName().hashCode();
        } catch (UnknownHostException e) {
            log.warn("Unable to get local host information.", e);
            addressHashCode = ID.class.hashCode();
        }
        GLOBAL_PROCESS_ID = time ^ nanoTime ^ freeMemory ^ addressHashCode;
        RANDOM1= new Random(time);
        RANDOM2= new Random(nanoTime);
        RANDOM3 = new Random(addressHashCode ^ freeMemory);
    }

    private ID() {}

    private  static long generateLong(){
        return Math.abs(RANDOM1.nextLong() ^ RANDOM2.nextLong() ^ RANDOM3.nextLong());
    }

    public static int generateInt() {
        return (int) generateLong();
    }

    public static String generateUUIDString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").toUpperCase();
    }


    public static String generateRandomCharacters(int num, String characterSampleSpace) {
        StringBuilder generatedString = new StringBuilder();
        for (int i = 0; i < num; i++) {

            char letter = (characterSampleSpace).charAt(RANDOM2.nextInt(characterSampleSpace.length()));
            generatedString.append(letter);

        }
        log.debug("Random generatedString:- {}", generatedString.toString());
        return generatedString.toString();


    }
}
