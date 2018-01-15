package pl.baranski.samples;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import pl.baranski.samples.CredentialsStorage.CredentialsConfig.Credentials;

@Component
public class CredentialsStorage {

    @Autowired
    private CredentialsConfig credentialsConfig;

    public Credentials getCredentials(final String env) {
        final Credentials credentials = credentialsConfig.getPasswords().get(StringUtils.substringBefore(env, "_"));

        if (credentials == null) {
            throw new IllegalArgumentException("Credentials does not exists for env=" + env);
        }

        return credentials;
    }

    @ConfigurationProperties
    @Component
    @Data
    public static class CredentialsConfig {

        private Map<String, Credentials> passwords;

        @Data
        public static class Credentials {
            private String user;
            private String pass;

        }

    }

}