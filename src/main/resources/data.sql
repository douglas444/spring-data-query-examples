INSERT INTO customer (id, active, email) VALUES (1, true, 'joao@test.com');
INSERT INTO customer (id, active, email) VALUES (2, true, 'maria@test.com');
INSERT INTO customer (id, active, email) VALUES (3, false, 'carlos@test.com');

INSERT INTO product (id, code, price) VALUES (10, 'NINTENDO-SWITCH', 1899.0);
INSERT INTO product (id, code, price) VALUES (20, 'PS5', 3299.0);
INSERT INTO product (id, code, price) VALUES (30, 'XBOX-ONE', 2499.0);

INSERT INTO purchase (id, customer_id, product_id) VALUES (100, 1, 10);
INSERT INTO purchase (id, customer_id, product_id) VALUES (200, 2, 20);
INSERT INTO purchase (id, customer_id, product_id) VALUES (300, 3, 20);

INSERT INTO stock (id, code, quantity) VALUES (1000, 'NINTENDO-SWITCH', 1245);
INSERT INTO stock (id, code, quantity) VALUES (2000, 'PS5', 0);
INSERT INTO stock (id, code, quantity) VALUES (3000, 'XBOX-ONE', 19384);

INSERT INTO rating (id, code, rating) VALUES (10000, 'NINTENDO-SWITCH', 4.7);
INSERT INTO rating (id, code, rating) VALUES (20000, 'PS5', 4.3);
INSERT INTO rating (id, code, rating) VALUES (30000, 'XBOX-ONE', 3.6);