create table admin_account (
                               user_id varchar(50) not null,
                               created_at datetime not null,
                               created_by varchar(100) not null,
                               modified_at datetime not null,
                               modified_by varchar(100) not null,
                               email varchar(100),
                               memo varchar(255),
                               nickname varchar(100),
                               role_types varchar(255) not null,
                               user_password varchar(255) not null,
                               primary key (user_id)
);