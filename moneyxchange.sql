DROP DATABASE IF EXISTS moneyxchange;

CREATE DATABASE moneyxchange;

USE moneyxchange;

CREATE TABLE user(
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(100) NOT NULL UNIQUE,
	password VARCHAR(100) NOT NULL,
	creation_date DATETIME NOT NULL DEFAULT NOW(),
	status boolean NOT NULL,
     
    PRIMARY KEY(id)
);

CREATE TABLE currency(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	code VARCHAR(3) NOT NULL UNIQUE,
	symbol VARCHAR(10) NOT NULL,

    PRIMARY KEY(id)
);

INSERT INTO currency (name, code, symbol) VALUES ('Dollar', 'USD', '$');
INSERT INTO currency (name, code, symbol) VALUES ('Euro', 'EUR', '€');
SELECT * FROM currency;

CREATE TABLE currency_exchange(
	id_currency_in INT NOT NULL,
	id_currency_out INT NOT NULL,
	value double(7,4) NOT NULL,

    PRIMARY KEY(id_currency_in, id_currency_out),
    FOREIGN KEY(id_currency_in) REFERENCES currency(id),
    FOREIGN KEY(id_currency_out) REFERENCES currency(id)
);


SELECT * FROM currency_exchange;
INSERT INTO currency_exchange (id_currency_in, id_currency_out, value) VALUES(1,2,0.8624);
INSERT INTO currency_exchange (id_currency_in, id_currency_out, value) VALUES(2,1,1.1595);


INSERT INTO user (username, password, creation_date, status) VALUES ('admin', '123456', NOW(), '1');

SELECT * FROM user;

