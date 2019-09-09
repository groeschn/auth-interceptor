package de.groeschn.javaee.rest.authentication.interceptor;

import de.groeschn.javaee.entity.User;
import de.groeschn.javaee.rest.authentication.producer.RequestUser;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Interceptor to check authentication and authorisation against the injected user.
 */
@Interceptor
@AuthorisedUser("")
public class AuthorisationInterceptor {

    @Inject
    @RequestUser
    User user;

    @AroundInvoke
    public Object checkAuthorisation(InvocationContext invocationContext) throws Exception {
        if (user != null) {
            String roleName = invocationContext.getMethod().getAnnotation(AuthorisedUser.class).value();
            if (roleName.length() > 0 && !user.isAuthorisedFor(roleName)) {
                throw new UnauthorisedException();
            } else {
                return invocationContext.proceed();
            }
        } else {
            throw new UnauthenticatedException();
        }
    }

}
