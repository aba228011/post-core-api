# post-core-api

GET: http://localhost:8080/post/check
(in response you get a string that the application is running)

--------------------------------------------------

POST: http://localhost:8080/post 

Body
Media type: application/json
Type: object

Properties
postId: String
clientId: required(String)
postRecipientId: required(String)
postItem: String
status: String

--------------------------------------------------

UPDATE: http://localhost:8080/post/{postId}

URI Parameters
postId: required(String)

Body
Media type: application/json
Type: object

Properties
postId: String
clientId: required(String)
postRecipientId: required(String)
postItem: String
status: String

--------------------------------------------------

GET: http://localhost/post/all

Response type: Array

--------------------------------------------------

GET: http://localhost:8080/post/{postId}

URI Parameters
postId: required(String)

Response
Media type: application/json
Type: object

--------------------------------------------------

GET: http://localhost:8080/post/client/{clientId}

URI Parameters
clientId: required(String)

Response type: Array

--------------------------------------------------

DELETE: http://localhost:8080/post/{postId}

URI Parameters
postId: required(String)


