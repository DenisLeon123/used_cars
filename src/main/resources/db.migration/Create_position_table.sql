create table cars_position
(
    c_id              integer          not null unique,
    c_marka           integer          not null,
    c_model           integer          not null,
    c_year_production integer          not null,
    c_mileage         double precision not null,
    c_price           double precision
);