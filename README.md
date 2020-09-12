# Shop-API

## Run using IDE

 - Select **Shop-API/src/main/java/com/shop/Shop/API/ShopApiApplication.java**
 - Run as a simple Java application

## Running as a Packaged Application
If you use the Spring Boot Maven 

 - Create an executable jar using command **./mvnw clean package** 
 - Run your application using **java -jar target/Shop-API-0.0.1-SNAPSHOT.jar**

## Endpoints
* ### Get All items
		GET http://localhost:8080/items
	
* ### Create a new Cart
		GET http://localhost:8080/cart
		
		Response
		[
			{
				"id": 1,
				"name": "Macbook pro laptop",
				"price": 1500.0,
				"stockQuantity": 10
			},
			{
				"id": 2,
				"name": "HP laptop",
				"price": 1000.0,
				"stockQuantity": 20
			}
		]
		
* ### Get a Cart by ID
		GET http://localhost:8080/cart/{cartId}

		Response
		{
			"id": 3,
			"price": 14000.0,
			"itemOrders": [
				{
					"id": 4,
					"item": {
									"id": 1,
									"name": "Macbook pro laptop",
									"price": 1500.0,
									"stockQuantity": 2
							},
					"quantity": 8,
					"cartId": 3
				},
				{
					"id": 5,
					"item": {
									"id": 2,
									"name": "HP laptop",
									"price": 1000.0,
									"stockQuantity": 18
							},

					"quantity": 2,
					"cartId": 3
				}
			]
		}
		
* ### Make an order and get Summary
		POST  http://localhost:8080/cart/{cartId}/order

		Summary Response
		
		{
			"Cart Items": [
				{
					"name": "Macbook pro laptop",
					"price": 1500.0,
					"order_quantity": 8,
					"price_per_quantity": 12000.0
				},
				{
					"name": "HP laptop",
					"price": 1000.0,
					"order_quantity": 2,
					"price_per_quantity": 2000.0
				}
			],
			"Total price": 14000.0
		}
