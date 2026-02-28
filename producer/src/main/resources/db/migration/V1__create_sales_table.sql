CREATE TABLE sales
(
    id          uuid PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    amount      FLOAT        NOT NULL
)