CREATE TABLE outbox_events
(
    id             uuid PRIMARY KEY,
    aggregate_id   uuid NOT NULL,
    aggregate_type VARCHAR(100) NOT NULL,
    event_type     VARCHAR(100) NOT NULL,
    payload        jsonb,
    created_at     TIMESTAMP,
    published      BOOLEAN DEFAULT FALSE
)