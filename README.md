# Running this Demo

1. Install Docker and Docker Compose.
2. Start Infrastructure with `docker-compose up -d`: This will start:
- Producer Database
- Adminer for inspecting database
- Kafka
- Kafka UI for inspecting Kafka
- Debezium connector for capturing changes in the producer database
3. Create Debezium connector by running `./create-connector.sh` in the terminal. This will create a Debezium connector that captures changes in the producer database and sends them to Kafka.
3. Run the Producer application with `./gradlew bootRun` or by running the `ProducerApplication` class in your IDE.

After everything is up and running, is time to test the application. 
You can use Postman or any other API testing tool to send a POST request to `http://localhost:8080/api/v1/sales` with the following JSON body:

```json
{
  "id": "9375f380-752f-40b4-81a3-70dbdf00bfc3",
  "description": "Haircut",
  "amount": 17
}
```

The sale will be inserted in the producer database and the Debezium connector will capture this change and send it to Kafka. You can inspect the Kafka topic `sales` in Kafka UI to see the change being captured.
Producer application will mark the sale as processed and update the database accordingly.
Consumer application will consume the message and process it, making a new entry in the consumer database.