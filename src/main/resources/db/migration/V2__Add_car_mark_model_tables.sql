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