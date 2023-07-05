CREATE TABLE tv
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    serial VARCHAR(120) NOT NULL,
    color VARCHAR(120) NOT NULL,
    size NUMERIC(10, 2) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    category VARCHAR(120) NOT NULL,
    technology VARCHAR(120) NOT NULL,
    availability BOOLEAN NOT NULL,
    device_id INT REFERENCES device(id) NOT NULL
);

CREATE TABLE IF NOT EXISTS vacuum
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    serial VARCHAR(120) NOT NULL,
    color VARCHAR(120) NOT NULL,
    size NUMERIC(10, 2) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    availability BOOLEAN NOT NULL,
    capacity NUMERIC(4, 2) NOT NULL,
    mode INT NOT NULL,
    device_id INT REFERENCES device(id) NOT NULL
);

CREATE TABLE IF NOT EXISTS fridge
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    serial VARCHAR(120) NOT NULL,
    color VARCHAR(120) NOT NULL,
    size NUMERIC(10, 2) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    availability BOOLEAN NOT NULL,
    door_count INT NOT NULL,
    compressor VARCHAR(120) NOT NULL,
    device_id INT REFERENCES device(id) NOT NULL
);

CREATE TABLE IF NOT EXISTS phone
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    serial VARCHAR(120) NOT NULL,
    color VARCHAR(120) NOT NULL,
    size NUMERIC(10, 2) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    availability BOOLEAN NOT NULL,
    memory INT NOT NULL,
    camera INT NOT NULL,
    device_id INT REFERENCES device(id) NOT NULL
);

CREATE TABLE IF NOT EXISTS computer
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    serial VARCHAR(120) NOT NULL,
    color VARCHAR(120) NOT NULL,
    size NUMERIC(10, 2) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    availability BOOLEAN NOT NULL,
    category VARCHAR(120) NOT NULL,
    processor VARCHAR(120) NOT NULL ,
    device_id INT REFERENCES device(id) NOT NULL
);