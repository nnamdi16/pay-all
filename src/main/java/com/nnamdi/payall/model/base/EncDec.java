package com.nnamdi.payall.model.base;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum EncDec {
    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(EncDec.class);

    private static final String password =  "zK1idhqSmHYYwScyeKvFG0ChjYp9fl";

    final StandardPBEStringEncryptor stringEncryptor;

    EncDec() {
        stringEncryptor = new StandardPBEStringEncryptor();
        stringEncryptor.setPassword(password);
        stringEncryptor.setStringOutputType("hexadecimal");
        stringEncryptor.initialize();

    }

    private String encrypt(String valueToEncrypt) {
        return stringEncryptor.encrypt(valueToEncrypt);
    }

    private String decrypt(String valueToDecrypt) {
        try {
            String decrypted = stringEncryptor.decrypt(valueToDecrypt);
            logger.debug("finished decrypting {} & decrypted value is {}", valueToDecrypt, decrypted);
            return decrypted;
        } catch (EncryptionOperationNotPossibleException e) {

            logger.error("EncryptionOperationNotPossibleException just occurred " +
                    "as this value might have been formerly decrypted prior to this time.");
            return "4533-3F15-28184-A3AA5-429FC5-09DF24B-345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B345333F1528184A3AA5429FC509DF24B3";
        }
    }

    public String encryptAndEncode(String valueToEncrypt) {
        logger.debug("finished encryptAndEncode {}", valueToEncrypt);
        return encrypt(valueToEncrypt);
    }

    public String decodeAndDecrypt(String valueToDecrypt) {
        logger.debug("finished decodeAndDecrypt {}", valueToDecrypt);
        return decrypt(valueToDecrypt);
    }


}
