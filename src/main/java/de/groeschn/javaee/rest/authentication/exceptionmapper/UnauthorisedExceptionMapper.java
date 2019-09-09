package de.groeschn.javaee.rest.authentication.exceptionmapper;

import de.groeschn.javaee.rest.authentication.interceptor.UnauthorisedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnauthorisedExceptionMapper implements ExceptionMapper<UnauthorisedException> {

    @Override
    public Response toResponse(UnauthorisedException e) {
        return Response.status(Response.Status.FORBIDDEN).build();
    }
}
