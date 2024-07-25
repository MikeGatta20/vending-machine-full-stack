BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO vending_machine (location, name, type, price, inventory) VALUES ('A1', 'Potato Crips', 'Chips', 305, 5);
INSERT INTO vending_machine (location, name, type, price, inventory) VALUES ('A2', 'Stackers', 'Chips', 145, 5);
INSERT INTO vending_machine (location, name, type, price, inventory) VALUES ('A3', 'Grain Waves', 'Chips', 275, 5);

COMMIT TRANSACTION;
