CREATE SEQUENCE public.token_data_id_seq;

CREATE TABLE token_data(
        id integer NOT NULL default nextval('token_data_id_seq'),
        alias              character varying(100),
        token_data         bytea NOT NULL,
        expiration_time    TIMESTAMP NOT NULL,
        status             character(10) NOT NULL,
        remove_after_expiration boolean NOT NULL DEFAULT false
)
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.token_data
  OWNER TO postgres;
