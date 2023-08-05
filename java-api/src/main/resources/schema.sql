DROP TABLE IF EXISTS owners;

CREATE TABLE owners (
    owner_id INT NOT NULL primary key,
    name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS dogs;

CREATE TABLE dogs (
    dog_id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL,
    owner_id INT NOT NULL,
    FOREIGN key
        (owner_id) REFERENCES owners (owner_id)
);

create view dogs_n_owners as
select d.dog_id as id, o.name as dog_owner, d.name as dog
from dogs as d inner join owners as o on d.owner_id = o.owner_id;


DROP TABLE IF EXISTS books;

CREATE TABLE books (
    book_private_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_name VARCHAR(255) NOT NULL,
    book_public_id VARCHAR(255) NOT NULL
);


DROP TABLE IF EXISTS book_users;
  
CREATE TABLE book_users (
    book_user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_private_id BIGINT NOT NULL,
    book_private_id BIGINT NOT NULL,
    FOREIGN KEY (user_private_id) REFERENCES users (user_private_id) ON DELETE CASCADE,
    FOREIGN KEY (book_private_id) REFERENCES books (book_private_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS counterparties;

CREATE TABLE counterparties (
    counterparty_private_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    counterparty_public_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS securities;

CREATE TABLE securities (
    security_private_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    security_public_id VARCHAR(255) NOT NULL,
    issuer VARCHAR(255) NOT NULL,
    maturity_date DATE NOT NULL,
    coupon BIGINT NOT NULL,
    type VARCHAR(255) NOT NULL,
    faceValue BIGINT NOT NULL,
    status VARCHAR(255) NOT NULL
);


DROP TABLE IF EXISTS trades;

CREATE TABLE trades (
    trade_private_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    trade_public_id VARCHAR(255) NOT NULL,
    book_private_id BIGINT NOT NULL,
    security_private_id BIGINT NOT NULL,
    counterparty_private_id BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    status VARCHAR(255) NOT NULL,
    price BIGINT NOT NULL,
    trade_date DATE NOT NULL,
    settlement_date DATE NOT NULL,
    FOREIGN KEY (book_private_id) REFERENCES books (book_private_id) ON DELETE CASCADE,
    FOREIGN KEY (security_private_id) REFERENCES securities (security_private_id) ON DELETE CASCADE,
    FOREIGN KEY (counterparty_private_id) REFERENCES counterparties (counterparty_private_id) ON DELETE CASCADE
);



DROP TABLE IF EXISTS trades;
CREATE TABLE users (
    user_private_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_public_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

