DROP DATABASE IF EXISTS company;
CREATE DATABASE IF NOT EXISTS company;
SHOW DATABASES ;
USE company;

#--------------------------------------------- ITEM TABLE -----------------------------------------------------------

DROP TABLE IF EXISTS Customer;
CREATE TABLE IF NOT EXISTS Customer(
    CustomerId      VARCHAR (6),
    CustomerName    VARCHAR (50),
    CustomerAddress VARCHAR (20),
    CustomerContact VARCHAR (20),
    CONSTRAINT      PRIMARY KEY (CustomerId)
    );

# DROP TABLE IF EXISTS Item;
# CREATE TABLE IF NOT EXISTS Item(
#     itemId      VARCHAR (6),
#     itemName    VARCHAR (50),
#     itemQty VARCHAR (20),
#     unitPrice DOUBLE
#     CONSTRAINT      PRIMARY KEY (itemId)
# );