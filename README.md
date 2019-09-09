# auth-interceptor
* Users are authenticated through JWTs supplied through the http Authorization header.
* CDI Producer to make a request's User object available for DI
* CDI Interceptor to check authentication and authorisation against the application's database

## Users
see src/main/resources/import.sql

| User | Roles | JWT |
| ---- | ----- | --- |
| DEMO_USER1 | DEMO_ROLE1 | `eyJhbGciOiJFUzUxMiJ9.eyJzdWIiOiJERU1PX1VTRVIxIn0.AILXOecq2IkMucy1HWSfiG5O6jmgsaZCOplgddE0pthqp-atQqsfm1SjeXXJ4_OGuHq5kkOf5OQLzYvvmLHjnqjNAIGL7l7nmP5QVhTnNmu2d4yD8noDjCW6wdiSYtSD6n0gWp5TIk92Iw8TQN5Jox4Ybvj12PYHMuDuu0u_GU4dotfD` |
| DEMO_USER2 | DEMO_ROLE1, DEMO_ROLE2 | `eyJhbGciOiJFUzUxMiJ9.eyJzdWIiOiJERU1PX1VTRVIyIn0.AJ2k9LsZJcN7ctoHO2f_mfK1oMu6ev3vDrIJif_fUgd0MxMFNaimDl-spoEcDQ6DeZn33GeNLbqwlgOM1HLIrZ5QATSPHU2NuAgIl8thqAjZyI7olAPCHAEUwkYFR3j8l3xx1JBuiZNtd7DsRtMbmS5Jq1EYSXwdf1Fn89r1Ug7k2Xsb` |

## Resources
| Resource | Description |
| -------- | ----------- |
| `auth-interceptor/rest/demo/users` | Return all users |
| `auth-interceptor/rest/demo/user` | Return the request's user |
| `auth-interceptor/rest/demo/authenticated` | Only available to authenticated users |
| `auth-interceptor/rest/demo/in-role` | Only available to authenticated users in role DEMO_ROLE2 |

## run
To start a local wildfly container and deploy the project run
```
mvn -Prun
```
or use the supplied run configuration for IntelliJ.