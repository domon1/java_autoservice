create table car_mark(
    id bigint not null auto_increment,
    mark_name varchar(30) not null,
    primary key (id)
);

create table car_model(
    id bigint not null auto_increment,
    model_name varchar(30) not null,
    mark_id bigint,
    primary key (id)
);

alter table car_model add constraint fk_model_mark foreign key (mark_id) references car_mark (id);

insert into car_mark(id, mark_name)
values (1, 'KIA'), (2, 'FORD'), (3, 'CHEVROLET'), (4, 'ЛАДА');

insert into car_model(id, model_name, mark_id)
values (1, 'CERATO', 1), (2, 'CEED', 1), (3, 'RIO', 1),
       (4, 'FOCUS', 2), (5, 'MONDEO', 2), (6, 'FIESTA', 2),
       (7, 'NIVA', 3), (8, 'CRUSE', 3), (9, 'AVEO', 3),
       (10, 'PRIORA', 4), (11, 'GRANTA', 4), (12, 'VESTA', 4);