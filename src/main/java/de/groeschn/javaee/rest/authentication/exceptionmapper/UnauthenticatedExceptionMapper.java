package de.groeschn.javaee.rest.authentication.exceptionmapper;

import de.groeschn.javaee.rest.authentication.interceptor.UnauthenticatedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnauthenticatedExceptionMapper implements ExceptionMapper<UnauthenticatedException> {

    @Override
    public Response toResponse(UnauthenticatedException e) {
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
