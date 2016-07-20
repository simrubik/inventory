CREATE TABLE asset
(
	asset_id				BIGINT NOT NULL,
	name					VARCHAR (255),
	serie					VARCHAR (255),
	available				BOOLEAN,
	active					BOOLEAN
);

ALTER TABLE asset ADD COLUMN available BOOLEAN DEFAULT 't';