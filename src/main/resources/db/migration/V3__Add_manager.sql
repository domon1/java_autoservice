insert into usr (id, username, password, first_name, last_name, phone_number)
values (1, 'manager', 'manager', 'Dmitry', 'Komarov', '9527652044');

insert into user_role (user_id, role)
values (1, 'USER'), (1, 'MANAGER');