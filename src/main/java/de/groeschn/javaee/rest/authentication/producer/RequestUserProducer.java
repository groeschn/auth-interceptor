package de.groeschn.javaee.rest.authentication.producer;

import de.groeschn.javaee.dao.UserDao;
import de.groeschn.javaee.entity.User;
import de.groeschn.javaee.util.JwtPublicKey;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;

/**
 * Make the request's user available for DI, if the Authorization: Bearer token is valid.
 */
@Slf4j
@RequestScoped
public class RequestUserProducer {

    @Inject
    HttpServletRequest httpServletRequest;
    @Inject
    UserDao userDao;
    @Inject
    @JwtPublicKey
    PublicKey publicKey;

    private User user;

    @Produces
    @RequestUser
    public User produceRequestUser() {
        if (user == null) {
            String headerValue = httpServletRequest.getHeader("Authorization");
            if (headerValue != null && headerValue.contains("Bearer")) {
                String username = Jwts.parser()
                        .setSigningKey(publicKey)
                        .parseClaimsJws(getJwtFromHeader(headerValue))
                        .getBody()
                        .getSubject();
                user = userDao.findUserByUsername(username);
            }
        }
        return user;
    }

    private String getJwtFromHeader(String headerValue) {
        if (headerValue != null) {
            return headerValue.replaceAll("Bearer ", "");
        } else {
            return null;
        }
    }
}
