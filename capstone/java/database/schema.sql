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

-- Bender BrewFinder tables

-- Breweries table
CREATE TABLE breweries (
    brewery_id SERIAL,
    brewer_id int,
    name varchar(250) NOT NULL,
    phone varchar(20) UNIQUE NOT NULL,
    url varchar(250) UNIQUE NOT NULL,
    street varchar(100),
    city varchar(100),
    state varchar(50),
    CONSTRAINT PK_breweries PRIMARY KEY (brewery_id),
    CONSTRAINT FK_users_breweries FOREIGN KEY (brewer_id) REFERENCES users(user_id)
    );


-- Beers table
CREATE TABLE beers (
    beer_id SERIAL,
    beer_name varchar(100) NOT NULL,
    beer_description varchar(500),
    image varchar(100),
    abv decimal,
    beer_type varchar(100),
    CONSTRAINT PK_beers PRIMARY KEY (beer_id)
);

-- Breweries_beers table
CREATE TABLE breweries_beers (
    breweries_id int NOT NULL,
    beer_id int NOT NULL,
    CONSTRAINT PK_breweries_beers PRIMARY KEY (breweries_id, beer_id),
    CONSTRAINT FK_breweries_breweries_beers FOREIGN KEY (breweries_id) REFERENCES breweries (breweries_id),
    CONSTRAINT FK_beers_breweries_beers FOREIGN KEY (beer_id) REFERENCES beers (beer_id)
)

CREATE TABLE reviews (
    review_id SERIAL,
    user_id int NOT NULL,
    beer_id int NOT NULL,
    brewery_id int NOT NULL,
    description VARCHAR(500),
    rating int NOT NULL
    CONSTRAINT CK_rating CHECK (rating <= 5),
    CONSTRAINT PK_reviews PRIMARY KEY (review_id),
    CONSTRAINT FK_users_reviews FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_beers_reviews FOREIGN KEY (beer_id) REFERENCES beers (beer_id),
    CONSTRAINT FK_breweries_reviews FOREIGN KEY (brewery_id) REFERENCES breweries (brewery_id)
);

COMMIT TRANSACTION;
