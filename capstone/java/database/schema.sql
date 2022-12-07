BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS breweries;
DROP TABLE IF EXISTS brews;
DROP TABLE IF EXISTS reviews;



CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

--Bender BrewFinder tables

CREATE TABLE breweries (
    brewery_id SERIAL,
    brewer_id INT,
    name VARCHAR(250) NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    url VARCHAR(250) UNIQUE NOT NULL,
    street VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(50),
    CONSTRAINT pk_brewery PRIMARY KEY (brewery_id),
    CONSTRAINT fk_breweries FOREIGN KEY (brewer_id) REFERENCES users(user_id)
    );

CREATE TABLE beers (
    beer_id SERIAL,
    brewery_id INT,
    beer_name VARCHAR(100) NOT NULL,
    beer_description VARCHAR(500),
    image VARCHAR(100),
    abv decimal,
    beer_type VARCHAR(100),
    CONSTRAINT pk_beer PRIMARY KEY (beer_id),
    CONSTRAINT fk_breweries FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)
);

CREATE TABLE reviews (
    review_id SERIAL,
    user_id INT NOT NULL,
    beer_id INT NOT NULL,
    beer_name VARCHAR(100) NOT NULL,
    brewery_name VARCHAR(250) NOT NULL,
    description VARCHAR(500),
    rating INT NOT NULL
    CONSTRAINT ck_rating CHECK (rating <= 5),
    CONSTRAINT pk_review PRIMARY KEY (review_id),
    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_review_beer FOREIGN KEY (beer_id) REFERENCES beers(beer_id)
);

COMMIT TRANSACTION;
