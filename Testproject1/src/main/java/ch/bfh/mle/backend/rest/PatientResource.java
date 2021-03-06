/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bfh.mle.backend.rest;

import ch.bfh.mle.backend.model.Patient;
import ch.bfh.mle.backup.files.GenericJpaDao;
import ch.bfh.mle.backup.files.IPatientDao;
import ch.bfh.mle.backend.service.PatientService;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Stefan & Boris
 */
@Stateless
@Path("patients")
public class PatientResource {

    @Context
    private UriInfo context;

    @Inject
    private PatientService srv;

    /**
     * Creates a new instance of PatientResource
     */
    public PatientResource() {}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Patient create(Patient entity) {
        return srv.create();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Patient update(Patient entity) {
        return srv.update(entity);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Patient get(@PathParam("id") long id) {
        return srv.read(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Patient> getAll() {
        return srv.read();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(Patient entity) {
        srv.delete(entity);
    }
}
