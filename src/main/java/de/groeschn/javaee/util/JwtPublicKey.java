package de.groeschn.javaee.util;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, TYPE, PARAMETER})
public @interface JwtPublicKey {
}
