BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('Boss Dog Brewery', '2163212337', 'www.bossdogbrewing.com','2179 Lee Road', 'Cleveland Heights', 'Ohio');
INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('BrewNuts', '2164718008', 'www.brewnutscleveland.com', '6501 Detroit Avenue','Cleveland', 'Ohio');
INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('Fat Heads Brewery', '2168980242', 'www.fatheads.com', '17450 Engle Lake Drive', 'Middleburg Heights', 'Ohio');
INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('Great Lakes Brewing', '2167714404', 'www.greatlakesbrewing.com', '2516 Market Ave', 'Cleveland', 'Ohio');
INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('Hoppin Frog Brewery', '3303524578', 'www.hoppinfrog.com', '2572 Scraton Road', 'Cleveland', 'Ohio');
INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('Market Garden Brewery', '2166214000', 'www.marketgardenbrewery.com', '1947 W 25TH Street', 'Cleveland', 'Ohio');
INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('Moosehead Saloon', '4408717742', 'www.mooseheadrestaurant.com', '694 Dover Center Road', 'Westlake', 'Ohio');
INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('Sibling Revelry Brewery', '4404718589', 'www.siblingrevelrybrewing.com', '29305 Clemens Road', 'Westlake', 'Ohio');
INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('Thirsty Dog Brewery', '3302522739', 'www.thirstydog.com', '1075 Old River Road', 'Cleveland', 'Ohio');
INSERT INTO breweries (name, phone, url, street, city, state) VALUES ('Wolfs Ridge Brewing', '6144293936', 'www.wolfsridgebrewing.com', '215 N 4th Street', 'Columbus', 'Ohio');



COMMIT TRANSACTION;
