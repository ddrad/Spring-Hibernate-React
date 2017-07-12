CREATE SEQUENCE public.business_customer_id_seq;

CREATE TABLE public.business_customer
(
   business_id integer NOT NULL default nextval('business_customer_id_seq'),
   type character varying(10) NOT NULL,
   status character varying(10) NOT NULL,
   CONSTRAINT business_customer_pkey PRIMARY KEY (business_id)
   )
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.business_customer
  OWNER TO postgres;