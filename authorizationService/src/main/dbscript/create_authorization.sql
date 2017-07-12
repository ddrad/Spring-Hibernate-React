CREATE SEQUENCE public.authorization_data_id_seq;

CREATE TABLE public.authorization_data
(
  authorization_id integer NOT NULL DEFAULT nextval('authorization_data_id_seq'),
  login character varying(35) NOT NULL,
  pswd character varying(35) NOT NULL,
  CONSTRAINT authorization_pkey PRIMARY KEY (authorization_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.authorization_data
  OWNER TO postgres;