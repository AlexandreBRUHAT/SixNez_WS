create table FAVS
(
    username varchar(40) not null,
    id_film varchar(10) not null,
    constraint FAVS_pk
        primary key (username, id_film),
    constraint FAVS_FILM_ID_film_fk
        foreign key (id_film) references FILM (ID_film),
    constraint FAVS_USER_username_fk
        foreign key (username) references USER (username)
);

