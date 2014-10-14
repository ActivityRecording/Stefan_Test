/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.mle.backend.rest;

import ch.bfh.mle.backend.model.Patient;
import ch.bfh.mle.backend.service.PatientService;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Stefan
 */
@Stateless
@Path("patienten")
public class PatientResource {

    @Context
    private UriInfo context;
    
    @Inject
    private PatientService patientService;

    /**
     * Creates a new instance of PatientResource
     */
    public PatientResource() {
    }

    /**
     * Retrieves representation of an instance of ch.sw.test.rest.PatientResource
     * @return an instance of Patient
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Patient> getPatienten() {
        return patientService.read();
    }

}
