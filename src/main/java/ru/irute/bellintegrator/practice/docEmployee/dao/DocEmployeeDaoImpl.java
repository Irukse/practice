package ru.irute.bellintegrator.practice.docEmployee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.irute.bellintegrator.practice.docEmployee.entity.DocEmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocEmployeeDaoImpl implements DocEmployeeDao{

    private final EntityManager em;

    @Autowired
    public DocEmployeeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocEmployeeEntity> getAllDocuments() {
        TypedQuery<DocEmployeeEntity> query = em.createQuery("SELECT d FROM DocEmployeeEntity d", DocEmployeeEntity.class);

        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveDocument(DocEmployeeEntity doc) {

        if (doc != null) {
            em.persist(doc);
        } else {
            throw new NullPointerException("Документ не может быть пустым");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateDocument(DocEmployeeEntity doc) {

        if (doc != null) {
            DocEmployeeEntity d = em.find(DocEmployeeEntity.class, doc.getId());

            if (d != null) {
                d.setDocNumber(doc.getDocNumber());
                d.setDocType(doc.getDocType());
                d.setDocDate(doc.getDocDate());
            }
        } else {
            throw new NullPointerException("Документ не может быть пустым");
        }
    }

}
