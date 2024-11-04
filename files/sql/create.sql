CREATE TABLE "users" (
    "id" serial PRIMARY KEY,
    "name" varchar,
    "username" varchar,
    "email" varchar,
    "password" varchar,
    "created_at" timestamp,
    "updated_at" timestamp
);
