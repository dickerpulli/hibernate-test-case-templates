package org.hibernate.bugs.entities;

public class PropertyTypeA {

    private Integer propertyA;

    public PropertyTypeA() {
    }

    public PropertyTypeA(String property) {
        // Hibernate needs this constructor, but doesn't use it :-)
        // See https://hibernate.atlassian.net/browse/HHH-15929
    }

    public Integer getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(Integer propertyA) {
        this.propertyA = propertyA;
    }
}