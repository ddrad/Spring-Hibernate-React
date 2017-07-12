CREATE SEQUENCE public.address_info_id_seq;

CREATE TABLE public.address_info
(
   address_info_id integer NOT NULL  default nextval('address_info_id_seq'),
   country character varying(20),
   city character varying(32),
   district character varying(50),
   street character varying(50),
   building character varying(10),
   customer_id integer NOT NULL,
   CONSTRAINT address_info_pkey PRIMARY KEY (address_info_id),

   CONSTRAINT customer_address_info_ibfk FOREIGN KEY (customer_id)
      REFERENCES public.customer (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.address_info
  OWNER TO postgres;