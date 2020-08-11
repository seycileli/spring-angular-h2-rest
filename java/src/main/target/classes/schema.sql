DROP TABLE if EXISTS tbl_expenses;

CREATE TABLE tbl_expenses (

    id INT AUTO_INCREMENT PRIMARY KEY,
    expense VARCHAR(250),
    description VARCHAR(250),
    amount DECIMAL DEFAULT NOT NULL
);