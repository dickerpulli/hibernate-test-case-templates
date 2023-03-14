package org.hibernate.bugs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.assertj.core.api.Assertions;
import org.hibernate.bugs.entities.CommonEntity;
import org.hibernate.bugs.entities.EntityA;
import org.hibernate.bugs.entities.EntityB;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
    }

    @After
    public void destroy() {
        entityManagerFactory.close();
    }

    // Entities are auto-discovered, so just add them anywhere on class-path
    // Add your tests, using standard JUnit.
    @Test
    public void hhh15929Test() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        EntityA entityA = new EntityA();
        entityA.setId(1L);
        entityA.getProperty().setPropertyA(1);
        entityManager.merge(entityA);

        EntityB entityB = new EntityB();
        entityB.setId(2L);
        entityB.getProperty().setPropertyB(2);
        entityManager.merge(entityB);

        // This call works, because we use the concrete subclass in the query
        EntityA loadedEntityA = findFirstOne(entityManager, EntityA.class);
        Assertions.assertThat(loadedEntityA).isNotNull();

        // This call does not work, because we use the superclass in the query
        CommonEntity loadedCommonEntity = findFirstOne(entityManager, CommonEntity.class);
        Assertions.assertThat(loadedCommonEntity).isNotNull();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private <C extends CommonEntity> C findFirstOne(EntityManager entityManager, Class<C> clazz) {
        var builder = entityManager.getCriteriaBuilder();
        var query = builder.createQuery(clazz);
        var dogRoot = query.from(clazz);
        query.select(dogRoot);
        return entityManager.createQuery(query).getResultList().stream().findFirst().orElseThrow();
    }
}
