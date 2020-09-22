# aims-pubsub-publisher

A Spring Boot app for sending test PubSub messages. Based on the following guide: [Messaging with Google Cloud Pub/Sub](https://spring.io/guides/gs/messaging-gcp-pubsub/).

### Running the Publisher

* Clone the repo
* Run the code in your IDE of choice
* If using the [PubSub Emulator](https://cloud.google.com/pubsub/docs/emulator) the host and port can be set in the `application.yml` file.
* The PubSub topic name can be set in the `application.yml` file.
* Publisher home page: <http://localhost:8082>

### Issues

* There is a problem running the publisher in a `docker-compose` script using a `org.springframework.cloud:spring-cloud-dependencies` version greater than `Hoxton.SR4`. Running it locally from the IDE up to version `Hoxton.SR8` has been tested and works.