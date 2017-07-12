CREATE SEQUENCE public.language_info_id_seq;

CREATE TABLE public.language_info
(
   language_info_id integer NOT NULL  default nextval('language_info_id_seq'),
   native character varying(20),
   taught_language_1 character varying(32),
   taught_language_2 character varying(32),
   taught_language_3 character varying(32),
   learning_language_1 character varying(32),
   learning_language_2 character varying(32),
   learning_language_3 character varying(32),
   CONSTRAINT language_info_pkey PRIMARY KEY (language_info_id)
)
WITH (
  OIDS = FALSE
)
;
ALTER TABLE public.language_info
  OWNER TO postgres;