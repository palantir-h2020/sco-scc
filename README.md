# Security Capabilities Catalogue

**This is the components of [PALANTIR](../) which contains the service and related microservices of the security capabilities catalogue.**

This project uses Quarkus, the Supersonic Subatomic Java Framework.

> **_NOTE:_** Futher instructions for usage will be added as integration with other components is made.

Note that for Docker container creation, check/use the desired dockerfile in [SCC's docker][scc-docker-dir] directory.

## Prerequisites

* Use .env.example to create a **.env** file.
* **Set up the connection to the Security Orchestrator, by changing the hosts file of the OS to point to the sco-so:**
On Linux add for example `10.101.41.168 sco-so` to the hosts file, or do an equivalent mapping to the name `sco-so`. Alternatively, the `sco-so` domain name must resolve to the appropriate host of the Security Orchestrator.

* **Start MongoDB and MinIO.** Do `docker compose up -d` to start them up.

## Running the catalogue in dev mode

You can run your catalogue in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  The SCC has the Quarkus Dev UI enabled in dev mode, which is available in dev mode only at <http://localhost:8080/q/dev/>. The SCC also has a **Swagger UI** enabled in dev mode, where the API can be inspected, which is available in dev mode only at <http://localhost:8080/q/swagger-ui/>.

## Packaging and running the catalogue

The catalogue can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The catalogue is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The catalogue, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/security-capabilities-catalogue-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

[scc-docker-dir]: src/main/docker
