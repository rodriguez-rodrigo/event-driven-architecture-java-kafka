curl --location 'http://localhost:8083/connectors' \
--header 'Content-Type: application/json' \
--data '{
    "name": "producer-connector",
    "config": {
      "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
      "database.hostname": "producer-database",
      "database.port": "5432",
      "database.user": "postgres",
      "database.password": "password",
      "database.dbname": "java",
      "database.server.name": "dbserver1",

      "topic.prefix": "producer-connector",

      "plugin.name": "pgoutput",

      "table.include.list": "public.outbox_events",

      "snapshot.mode": "never",

      "key.converter": "org.apache.kafka.connect.json.JsonConverter",
      "value.converter": "org.apache.kafka.connect.json.JsonConverter",
      "key.converter.schemas.enable": "false",
      "value.converter.schemas.enable": "false"
    }
  }'