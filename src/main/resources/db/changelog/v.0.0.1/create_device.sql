CREATE TABLE IF NOT EXISTS device
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    country VARCHAR(120) NOT NULL,
    manufacturer VARCHAR(120) NOT NULL,
    online_order BOOLEAN NOT NULL,
    installment BOOLEAN NOT NULL
);