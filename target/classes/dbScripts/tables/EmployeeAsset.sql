CREATE TABLE employee_asset
(
	employee_asset_id				BIGINT NOT NULL,
	employee_id						BIGINT,
	asset_id						BIGINT,
	use_time						VARCHAR (255),
	pu								VARCHAR (255),
	um								VARCHAR (255),
	reception_id					BIGINT,
	returning_id					BIGINT
);