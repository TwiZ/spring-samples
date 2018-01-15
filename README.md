# spring-samples
## spring-properties-samples
Let's imagine you have property for environment and you have different passwords for each enviroment and you need to resolve correct credentials.
You can find code in example.

applicayion.yml
```
environment: dev_china
    
passwords:
    dev:
        user: devuser
        pass: devpass
    prod:
        user: produser
        pass: prodpass
```

Usage example. Call http://localhost:8080/credentials

Result: Env=dev_china. Found user=devuser and pass=devpass.
