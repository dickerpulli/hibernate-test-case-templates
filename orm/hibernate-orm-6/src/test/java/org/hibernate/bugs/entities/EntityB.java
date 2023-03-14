package org.hibernate.bugs.entities;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

@Entity
@DiscriminatorValue("B")
public class EntityB extends CommonEntity {

    @JdbcTypeCode(SqlTypes.JSON)
    @Type(JsonType.class)
    private PropertyTypeB property = new PropertyTypeB();

    public PropertyTypeB getProperty() {
        return property;
    }

    public void setProperty(PropertyTypeB property) {
        this.property = property;
    }
}