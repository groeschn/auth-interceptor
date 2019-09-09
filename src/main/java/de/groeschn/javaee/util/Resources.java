package de.groeschn.javaee.util;

import lombok.extern.slf4j.Slf4j;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Singleton
@Slf4j
public class Resources {

    @PersistenceContext
    private EntityManager em;

    @Produces
    public EntityManager getEm() {
        return em;
    }

    @Produces
    @JwtPublicKey
    public PublicKey getJwtPublicKey() {
        try {
            String publicKeyBase64 = System.getenv("JWT_PUBLIC_KEY_BASE64");
            KeyFactory kf = KeyFactory.getInstance("EC");
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyBase64));
            return kf.generatePublic(publicKeySpec);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }
}
