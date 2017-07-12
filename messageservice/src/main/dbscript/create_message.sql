CREATE SEQUENCE public.message_id_seq;

CREATE TABLE public.message
(
  sender_token character varying(36) NOT NULL,
  message_token character varying(36) NOT NULL,
  sender integer NOT NULL,
  recipient integer NOT NULL,
  content character varying(2000) NOT NULL,
  CONSTRAINT message_pkey PRIMARY KEY (sender_token, message_token),
  CONSTRAINT sender_message_ibfk FOREIGN KEY (sender)
      REFERENCES public.customer (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT recipient_message_ibfk FOREIGN KEY (recipient)
      REFERENCES public.customer (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.message
  OWNER TO postgres;
