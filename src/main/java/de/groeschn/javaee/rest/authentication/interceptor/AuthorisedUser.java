package de.groeschn.javaee.rest.authentication.interceptor;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * InterceptorBinding for {@link AuthorisationInterceptor}. The value can be used to to check for a specific role.
 */
@Inherited
@InterceptorBinding()
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface AuthorisedUser {
    @Nonbinding String value() default "";
}
