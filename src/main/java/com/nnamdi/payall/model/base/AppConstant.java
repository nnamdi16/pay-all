package com.nnamdi.payall.model.base;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public interface AppConstant {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM d yyyy HH:mm a");
    DateTimeFormatter dateFormatSeparatorStyle = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    DateTimeFormatter dateFormatNoDate = DateTimeFormatter.ofPattern("MMM d yyyy");

    DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

    Character NEW_ENTITY ='N';
    Character DELETE_ENTITY = 'D';
    Character UPDATED_ENTITY= 'U';
    Character EXPIRED_ENTITY= 'E';
    Character BLOCK_ENTITY = 'B';

    enum Role {
        ADMIN,
        CUSTOMER,
        AGENT
    }




}
