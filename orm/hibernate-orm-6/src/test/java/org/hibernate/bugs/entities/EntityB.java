package org.hibernate.bugs.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@DiscriminatorValue("B")
public class EntityB extends CommonEntity {

    @JdbcTypeCode(SqlTypes.JSON)
    private PropertyTypeB property = new PropertyTypeB();

    public PropertyTypeB getProperty() {
        return property;
    }

    public void setProperty(PropertyTypeB property) {
        this.property = property;
    }
}