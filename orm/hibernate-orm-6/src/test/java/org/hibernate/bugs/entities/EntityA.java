package org.hibernate.bugs.entities;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

@Entity
@DiscriminatorValue("A")
public class EntityA extends CommonEntity {

    @JdbcTypeCode(SqlTypes.JSON)
    @Type(JsonType.class)
    private PropertyTypeA property = new PropertyTypeA();

    public PropertyTypeA getProperty() {
        return property;
    }

    public void setProperty(PropertyTypeA property) {
        this.property = property;
    }
}