/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cspark on 2017. 1. 17..
 */
@Entity
@AssociationOverrides({
        @AssociationOverride(name = "id.building", joinColumns = @JoinColumn(name = "BUILDING_ID")),
        @AssociationOverride(name = "id.contact", joinColumns = @JoinColumn(name = "CONTACT_ID"))
})
public class BuildingContact implements Serializable {

    @EmbeddedId
    private BuildingContactId id = new BuildingContactId();

    /**
     * 담당
     */
    private String charge;

    public BuildingContactId getId() {
        return id;
    }

    public void setId(BuildingContactId id) {
        this.id = id;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Building getBuilding() {
        return getId().getBuilding();
    }

    public void setBuilding(Building building) {
        getId().setBuilding(building);
    }

    public Contact getContact() {
        return getId().getContact();
    }

    public void setContact(Contact contact) {
        getId().setContact(contact);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BuildingContact that = (BuildingContact) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (getId() != null ? getId().hashCode() : 0);
    }

}
