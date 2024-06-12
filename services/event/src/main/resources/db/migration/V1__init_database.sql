create table if not exists category
(
    id BIGSERIAL PRIMARY KEY,
    title varchar(255) not null,
    description varchar(255) not null
);

create table if not exists event
(
    id BIGSERIAL PRIMARY KEY,
    title varchar(255) not null,
    description varchar(255) not null,
    image varchar(255),
    start_time timestamp with time zone not null,
    end_time timestamp with time zone not null,
    price numeric(38,2) not null,
    available_qtty double precision not null,
    category_id bigint
                constraint fk_eventconstraint references category(id)
);

create sequence if not exists category_seq increment by 50;
create sequence if not exists event_seq increment by 50;


