/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by cspark on 2017. 2. 6..
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingContactId implements Serializable {

    @ManyToOne
    private Building building;

    @ManyToOne
    private Contact contact;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuildingContactId that = (BuildingContactId) o;

        if (building != null ? !building.equals(that.building) : that.building != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (building != null ? building.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }
}
