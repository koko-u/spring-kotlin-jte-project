-- migrate:up
CREATE TABLE IF NOT EXISTS "messages"
(
    "id"         BIGINT      NOT NULL GENERATED ALWAYS AS IDENTITY,
    "message"    TEXT        NULL,
    "created_at" TIMESTAMPTZ NOT NULL DEFAULT now()
);

-- migrate:down
DROP TABLE IF EXISTS "messages";
