package cn.com.microcent.core.utils;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Created by Administrator on 2017/5/27.
 */
public class TokenGenerator {
    public static String generateHexKey() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public final static String createAuthorizationKey(final String username, final String token) {
        String authorizationString = username + ":" + token;
        return new String(Base64.encodeBase64(authorizationString.getBytes(Charset.forName("US-ASCII"))));
    }
}
