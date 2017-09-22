drop table if exists roles;
create table roles
(
	id bigint auto_increment
		primary key,
	name varchar(255) not null,
	constraint UK_ofx66keruapi6vyqpv6f2or37
		unique (name)
);

drop table if exists users;
create table users
(
	id bigint auto_increment
		primary key,
	account_expired bit not null,
	account_locked bit not null,
	company varchar(255) null,
	create_date datetime not null,
	email varchar(100) not null,
	enabled bit not null,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	password varchar(100) not null,
	password_expired bit not null,
	photo_url varchar(255) null,
	update_date datetime null,
	username varchar(100) not null,
	constraint UK_6dotkott2kjsp8vw4d0m25fb7
		unique (email),
	constraint UK_r43af9ap4edm43mmtq01oddj6
		unique (username)
);

drop table if exists user_role;
create table user_role
(
	user_id bigint not null,
	role_id bigint not null,
	primary key (user_id, role_id)
)
;

create index user_role_role_id
	on user_role (role_id);



