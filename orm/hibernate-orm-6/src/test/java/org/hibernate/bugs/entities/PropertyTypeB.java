package org.hibernate.bugs.entities;

public class PropertyTypeB {

    private Integer propertyB;

    public PropertyTypeB() {
    }

    public PropertyTypeB(String propertyB) {
        // Hibernate needs this constructor, but doesn't use it :-)
        // See https://hibernate.atlassian.net/browse/HHH-15929
    }

    public Integer getPropertyB() {
        return propertyB;
    }

    public void setPropertyB(Integer propertyB) {
        this.propertyB = propertyB;
    }
}