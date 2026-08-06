-- V7__fix_currency_type.sql

ALTER TABLE pricing_plan ALTER COLUMN currency TYPE VARCHAR(3);
