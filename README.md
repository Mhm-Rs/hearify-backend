# Hearify - Backend

This app handles the business logic of the Hearify Application. It is made of a Java 21 + Spring Boot 3 application, communicating with a MySQL database.

## Get started

### Launch the app with Docker

To use the containerized version of the backend, follow these steps :
- Navigate to the root of the project 
- Run ```mvn clean package``` to generate a .jar of the app
- Run ```docker compose up -d --build``` to launch both the backend app and the mySQL containers.
- The app will start at ```localhost:5001```.

> Use ```docker compose down``` to stop the containers.

### Launch the app locally
You will need an instance of the MySQL database to run the app locally.
- You can use the **docker-compose.yml** file at the root of the project and delete the backend service to launch only the MySQL container.
- Start the MySQL container with ```docker compose up --build``` 
- Start the backend project locally with ```./mvnw spring-boot:run```
- The app will start at ```localhost:5000```.

## Documentation

The project uses ```localhost:{PORT}/v1/api``` as its base URL, where {PORT} is either 5000 if launched locally or 5001 if launched via Docker.

You can find the swagger UI documentation at ```localhost:{PORT}/swagger-ui/index.html```, and the JSON docs at ```localhost:{PORT}/v3/api-docs```