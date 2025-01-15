create table users (
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    password varchar(100) not null,
    admin boolean default false,

    primary key(id)
);

create table courses (
    id bigint not null auto_increment,
    name varchar(100) not null unique,
    category varchar(100) not null,

    primary key(id)
);

create table topics (
    id bigint not null auto_increment,
    title varchar(100) not null unique,
    message varchar(300) not null unique,
    creation_date datetime not null,
    status boolean default true,
    author_id bigint not null,
    course_id bigint not null,

    primary key(id),
    foreign key (author_id) references users(id),
    foreign key (course_id) references courses(id)
);

create table comments (
    id bigint not null auto_increment,
    message varchar(300) not null unique,
    topic_id bigint not null,
    author_id bigint not null,
    creation_date datetime not null,
    resolve boolean default false,

    primary key(id),
    foreign key (author_id) references users(id),
    foreign key (topic_id) references topics(id)
);
