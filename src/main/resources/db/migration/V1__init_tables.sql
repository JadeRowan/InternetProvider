create table services
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table tariff_plans
(
    id          bigint auto_increment
        primary key,
    description varchar(255) null,
    price       double       null,
    title       varchar(255) null,
    service_id  bigint       null,
    constraint FK4w1n4ueitggj5o6b0gfqs1gau
        foreign key (service_id) references services (id)
);

create table users
(
    id         bigint auto_increment
        primary key,
    balance    double       null,
    is_blocked bit          null,
    login      varchar(255) null,
    role       varchar(255) null
);

create table users_tariff_plans
(
    user_id         bigint not null,
    tariff_plans_id bigint not null,
    constraint UK_gidh8k54cpe4mb0bu3gpwrsxy
        unique (tariff_plans_id),
    constraint FK9wpong8i4lk79snpadtrfw1xr
        foreign key (tariff_plans_id) references tariff_plans (id),
    constraint FKaobxm93g17f4b7il03ack07n3
        foreign key (user_id) references users (id)
);
