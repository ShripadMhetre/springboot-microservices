# Microservices Demo Project in Spring Boot

## Services :-
- Microservices - **image-service**, **gallery-service**
- **api-gateway** - proxy/gateway to the system (Uses netflix's **zuul**)
- **service-registry** - Eureka Server (by netflix) as a naming server or service registry


## Testing the application :-
- Run eureka server (i.e. __service-registry__)
- Run **api-gateway**
- Run the microservices (**image-service** & **gallery-service**)
- Then go to Eureka Server running at `localhost:8761` to see the running services on the Eureka dashboard
- Also to ping the gallery-service, go to `localhost:8762/gallery`
