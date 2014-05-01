-- Table: cars

-- DROP TABLE cars;

CREATE TABLE cars
(
  carId  serial NOT NULL,
  lotId  integer NOT NULL,
  carType  character varying(20) NOT NULL,
  price integer NOT NULL,
  fuelLevel  integer NOT NULL,
  isHybrid  boolean NOT NULL,
  isOnSale  boolean NOT NULL,
  CONSTRAINT pk_cars PRIMARY KEY ( carId ),
  CONSTRAINT fk_lot_id FOREIGN KEY ( lotId )
      REFERENCES lot (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cars
  OWNER TO testuser;
