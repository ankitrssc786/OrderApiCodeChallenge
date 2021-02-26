# OrderApiCodeChallenge
Prerequisites:

Java 8+,
Cassandra,
Spring Suite,
Docker,
Docker-Compose,

Start Environment (Steps to run locally) :

Create a pull Request or download project from GitHub Repository (Shared Url in the email).
Import code in the eclipse.
Install spring suite to run spring boot application.
Run project as a Spring boot or Run as Java Application.


ORDER API:

Spring Boot Web Java application that exposes a REST API to manage orders. It uses Cassandra as storage.

Get details about the order created:

Request (Hit URL)
http://localhost:9001/api/orders/401a85e2-f5da-494b-9f3f-756a91982f23

Resposne - 200 Success
{
    "id": "401a85e2-f5da-494b-9f3f-756a91982f23",
    "timestamp": 1612487464353,
    "status": 0,
    "orderTotal": 17.23,
    "shippingCost": 6.45,
    "customerId": "401a85e2-f5da-494b-9f3f-756a91982f33",
    "itemId": "401a85e2-f5da-494b-9f3f-756a91982f44",
    "quantity": 1,
    "note": "test value"
}


Create Orders with all Details :

Request (Hit URL)
http://localhost:9001/api/orders

[
    {"id": "401a85e2-f5da-494b-9f3f-756a91982f24",
"timestamp": 1612487464353,
"status": 0,
"orderTotal": 17.23,
"shippingCost": 6.45,
"customerId": "401a85e2-f5da-494b-9f3f-756a91982f33",
"itemId": "401a85e2-f5da-494b-9f3f-756a91982f44",
"quantity": 1,
"note": "test value"
    },
     {"id": "401a85e2-f5da-494b-9f3f-756a91982f55",
"timestamp": 1612487464353,
"status": 0,
"orderTotal": 17.23,
"shippingCost": 6.45,
"customerId": "401a85e2-f5da-494b-9f3f-756a91982f77",
"itemId": "401a85e2-f5da-494b-9f3f-756a91982f88",
"quantity": 1,
"note": "test value third"
    }
]

Response - 200 Success


Attached PDF
Attaching PDF screenshots which i took during developing application.
