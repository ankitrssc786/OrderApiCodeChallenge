-- =================================================================================================
-- ORDERS

DROP TABLE orders;

CREATE TABLE orders(id text,timestamp bigint,status int,orderTotal double,shippingCost double,customerId text,itemId text,quantity int,note text,PRIMARY KEY(id));

INSERT INTO test_keyspace. orders (id,timestamp,status,ordertotal,shippingcost,customerid,itemid,quantity,note) VALUES ('401a85e2-f5da-494b-9f3f-756a91982f00',1612487464353,0,10.23,3.45,'401a85e2-f5da-494b-9f3f-756a91982f01','401a85e2-f5da-494b-9f3f-756a91982f02',1,'test') IF NOT EXISTS;