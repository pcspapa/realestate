/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cspark on 2016. 12. 1..
 */
@Data
public class SaleContact {

    @Embeddable
    public static class Id implements Serializable {

        private Long saleId;

        private Long contactId;

        public Id() {}

        public Id(Long saleId, Long contactId) {
            this.saleId = saleId;
            this.contactId = contactId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Id id = (Id) o;

            if (saleId != null ? !saleId.equals(id.saleId) : id.saleId != null) return false;
            return contactId != null ? contactId.equals(id.contactId) : id.contactId == null;

        }

        @Override
        public int hashCode() {
            int result = saleId != null ? saleId.hashCode() : 0;
            result = 31 * result + (contactId != null ? contactId.hashCode() : 0);
            return result;
        }
    }

    @EmbeddedId
    private Id id = new Id();

    private String name;

    private String mobileNo;

    private String companyName;

    private String deptName;

    @OneToOne
    @JoinColumn(name = "SALE_ID", insertable = false, updatable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "CONTACT_ID", insertable = false, updatable = false)
    private Contact contact;

}
