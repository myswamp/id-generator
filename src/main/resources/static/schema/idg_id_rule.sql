create table idg_id_rule(
    id int(11) not null auto_increment,
    business_tag varchar(254) not null,
    max_id int(11) not null default 0,
    step int(11) not null default 1000,
    description varchar(254),
    created_on timestamp default current_timestamp,
    updated_on timestamp on update current_timestamp
)