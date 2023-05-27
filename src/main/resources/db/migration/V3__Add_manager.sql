insert into usr (id, username, password, first_name, last_name, phone_number)
values (1, 'manager', '$2a$12$CAp018FKJDm8ChB.ZSECa.rrv3KMT64jWHvFL35ILLyiVutLJM0La', 'Dmitry', 'Komarov', '9527652044');

insert into user_role (user_id, roles)
values (1, 'USER'), (1, 'MANAGER');