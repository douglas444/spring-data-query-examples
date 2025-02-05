INSERT INTO customer (id, active, email) VALUES (1, true, 'joao@test.com');
INSERT INTO customer (id, active, email) VALUES (2, true, 'maria@test.com');

INSERT INTO product (id, code, price) VALUES (10, 'SWITCH', 1899.0);
INSERT INTO product (id, code, price) VALUES (20, 'PS5', 3299.0);
INSERT INTO product (id, code, price) VALUES (30, 'XBOX-ONE', 2499.0);

INSERT INTO purchase (id, customer_id, product_id) VALUES (100, 1, 10);
INSERT INTO purchase (id, customer_id, product_id) VALUES (200, 2, 20);