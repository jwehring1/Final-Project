drop database addressbook;
create database addressbook;
use addressbook;
create table address(
AddressID int not null auto_increment,
Street varchar(255) not null,
 City varchar(255) not null,
 State varchar(255) not null,
 Zipcode int not null,
 primary key(AddressID));
 
create table person(
PersonName varchar(255) not null,
Age int not null,
SSN int not null,
Race varchar(255) not null,
Height int not null,
Weight double not null,
AddressID int not null,
foreign key(AddressID) references address(AddressID),
primary key(SSN));