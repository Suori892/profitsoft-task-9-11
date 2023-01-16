create table if not exists Buyer(
    buyer_id bigint auto_increment primary key,
    name varchar(255) not null,
    email varchar(255) not null unique check(email like '%@gmail.com')
    );

insert into Buyer(name, email) values ('John', 'john232@gmail.com'),
                                      ('Michael', 'michael897@gmail.com'),
                                      ('Bob', 'bobbb24@gmail.com'),
                                      ('Ann', 'ann90@gmail.com'),
                                      ('Albert', 'albert8975@gmail.com');

create table if not exists Item(
    item_id bigint auto_increment primary key,
    buyer_id bigint not null references Buyer(buyer_id),
    item_name varchar(255),
    item_category varchar(255),
    item_price int
    );

insert into Item(buyer_id, item_name, item_category, item_price) values (1, 'headphones', 'electronics', 100),
                                                                        (1, 'iphone', 'electronics', 500),
                                                                        (2, 'pan', 'kitchen', 100),
                                                                        (2, 'headphones', 'electronics', 100),
                                                                        (3, 'pot', 'kitchen', 200),
                                                                        (4, 'book', 'education', 100),
                                                                        (4, 'iphone', 'electronics', 500),
                                                                        (5, 'notebook', 'education', 100),
                                                                        (5, 'book', 'education', 100),
                                                                        (5, 'pan', 'kitchen', 100);