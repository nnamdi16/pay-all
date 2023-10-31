package com.nnamdi.payall.model.base;

import java.io.Serializable;
import java.time.ZonedDateTime;

public interface AbstractEntity<PK extends Serializable> {
    /**
     * @return the primary key as String
     */
    String getIdx();

    PK getPk();

    String getIde();

    /**
     * Helper method to know whether the primary key is set or not
     *
     * @return true if the primary key is set, false otherwise
     */

    boolean isIdSet();

    void setId(String id);

    String getId();

    void setCreatedBy(String createdBy);

    ZonedDateTime getCreatedDate();

    void setCreatedDate(ZonedDateTime createdDate);

    String getLastModifiedBy();

    void setLastModifiedBy(String lastModifiedBy);

    ZonedDateTime getLastModifiedDate();

    void setLastModifiedDate(ZonedDateTime lastModifiedDate);


}
