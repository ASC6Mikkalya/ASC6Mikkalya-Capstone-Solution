use atsdb;
create table plane(
    id VARCHAR(6),
    model VARCHAR(50),
    manufacturer VARCHAR(50),
    image VARCHAR(50),
    seating_capacity INT
);
select * from plane;
drop table Plane;