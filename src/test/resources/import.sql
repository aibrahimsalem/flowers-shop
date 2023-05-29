insert into customer(id, name, phone, email, address) values (1, 'ahmed', '01727530893', 'a.b@d.e', 'AM See, Haar');
insert into customer(id, name, phone, email, address) values (2, 'moataz', '0123456789', 'm.b@d.e', 'Leonrodplatz');
insert into flowers_order(id, customer_id) values (2, 2);
insert into item_type(id, name) values(2, 'flower');
insert into item(id, name, quantity, type, price, color, material, item_type_id) values(2, 'flowerA', 10, 'plastic', 1.25, 'red', 'paper', 2);
