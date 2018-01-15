package pl.baranski.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.baranski.samples.CredentialsStorage.CredentialsConfig.Credentials;

@RestController
public class PasswordController {

    @Value("${environment}")
    private String env;

    @Autowired
    private CredentialsStorage credentialsStorage;

    @RequestMapping("/credentials")
    String credentials() {
        final Credentials credentials = credentialsStorage.getCredentials(env);
        return String.format("Env=%s. Found user=%s and pass=%s", env, credentials.getUser(), credentials.getPass());
    }

}
