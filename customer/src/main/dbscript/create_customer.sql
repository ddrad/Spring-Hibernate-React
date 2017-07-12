CREATE SEQUENCE public.customer_id_seq;

CREATE TABLE public.customer
(
  id integer NOT NULL DEFAULT nextval('customer_id_seq'),
  first_name character varying(15) NOT NULL,
  last_name character varying(20) NOT NULL,
  middle_name character varying(15) NOT NULL,
  business_id integer NOT NULL,
  authorization_id integer NOT NULL,
  CONSTRAINT customer_pkey PRIMARY KEY (id),
  CONSTRAINT authorization_data_ibfk FOREIGN KEY (authorization_id)
      REFERENCES public.authorization_data (authorization_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT business_customer_ibfk FOREIGN KEY (business_id)
      REFERENCES public.business_customer (business_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.customer
  OWNER TO postgres;
