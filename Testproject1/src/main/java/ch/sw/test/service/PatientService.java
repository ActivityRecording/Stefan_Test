/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.sw.test.service;

import ch.sw.test.model.Patient;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stefan
 */
@Stateless
public class PatientService {
  
    @PersistenceContext
    protected EntityManager entityManager;

    public Collection<Patient> read() {
        return (Collection<Patient>) entityManager.createQuery("SELECT x FROM " + Patient.class.getSimpleName() + " x", Patient.class).getResultList();
    }
}
