create table address (
    id bigint not null auto_increment,
    house varchar(5) not null,
    street varchar(255) not null,
    primary key (id));

create table category (
    id bigint not null auto_increment,
    name varchar(50) not null,
    primary key (id));

create table rec_time (
    id bigint not null auto_increment,
    time_value varchar(5) not null,
    primary key (id));

create table record (
    id bigint not null auto_increment,
    comment varchar(255),
    date date not null,
    mark varchar(20) not null,
    model varchar(20) not null,
    name varchar(20) not null,
    state varchar(15) not null,
    service_id bigint not null,
    time_id bigint not null,
    phone_number varchar(10) not null,
    primary key (id));

create table user_role (
    user_id bigint not null,
    roles varchar(20));

create table usr (
    id bigint not null auto_increment,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    username varchar(50) not null,
    password varchar(255) not null,
    phone_number varchar(10) not null,
    primary key (id));

create table usr_service (
    id bigint not null auto_increment,
    description varchar(255) not null,
    name varchar(50) not null,
    price integer not null,
    category_id bigint,
    primary key (id));

alter table record add constraint fk_record_service foreign key (service_id) references usr_service (id);
alter table record add constraint fk_record_time foreign key (time_id) references rec_time (id);
alter table user_role add constraint fk_user_role foreign key (user_id) references usr (id);
alter table usr_service add constraint fk_service_category foreign key (category_id) references category (id);