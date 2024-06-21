# Clash Guide API

This RESTful API is built using Spring Boot with a clean MVC architecture that displays all the available Troops in Clash Of Clans along with their details.

# Features

- MVC architecture.
- Uses MongoDB Atlas for Database.

# Routes

### Get all Troops

| Parameter    | Description                                                                              |
|--------------|------------------------------------------------------------------------------------------|
| `size` (int) | (optional) by default the size is unlimited. Example: `GET /get-all-troops?size=1`       |
| `sort` (int) | (optional) by default there is not sort. Example: `GET /get-all-troops?size=1?sort=name` |

Output:

```json
{
    "content": [
      {
        "_id": "6612bba0ced75d1ea06af6d2",
        "name" : "Super Barbarian",
        "description" : "Superior in health, power, speed and most importantly, hair, the Super Barbarians are what regular Barbarians dream of becoming!",
        "image" : "https://firebasestorage.googleapis.com/v0/b/clash-guide-app.appspot.com/o/Super%20Troops%2FSuper_Barbarian.png?alt=media&token=75f32d7e-12e1-48e8-b486-c97dc9288727",
        "color" : "0XFFDDEE19",
        "isSuperTroop" : true
      }
    ],
    {...},
    ...
}
```

<br>

### Add a Troop

| Parameter      | Description                                                                  |
|----------------|------------------------------------------------------------------------------|
| `key` (string) | This operation requires an Auth key. Example: `POST /add-troop?key=AUTH_KEY` |
| `body`         | Add a Troop by providing a body. Example: `POST /add-troop`                  |


Request Body:

```json

{
  "name" : "Golem",
  "description" : "The mighty Golem loves to soak up damage! When destroyed, it explodes and splits into Golemites. The resulting Golemites have one-fifth the Golem's strength and hitpoints.",
  "image" : "https://firebasestorage.googleapis.com/v0/b/clash-guide-app.appspot.com/o/Troops%2FGolem.png?alt=media&token=6cdf4c29-6940-4efa-93a1-d1fcd058bac5",
  "color" : "0XFF606D68",
  "isSuperTroop" : false
}
```

Output:

```json
  Troop added successfully!
```

<br>

### Update a Troop

| Parameter      | Description                                                                                               |
|----------------|-----------------------------------------------------------------------------------------------------------|
| `_id` (string) | Update a Troop by providing it's _id. Example: `PATCH /update-troop/6612bba0ced75d1ea06af6d2`             |
| `key` (string) | This operation requires an Auth key. Example: `PATCH /update-troop/6612bba0ced75d1ea06af6d2?key=AUTH_KEY` |
| `body`         | Provide a body.                                                                                           |


Request Body:

```json

{
  "name" : "Super Valkyrie",
  "description" : "Not only are Super Valkyries superior to regular Valkyries in every way, they're also way more angry!",
  "image" : "https://firebasestorage.googleapis.com/v0/b/clash-guide-app.appspot.com/o/Super%20Troops%2FSuper_Valkyrie.png?alt=media&token=2834d3b1-ae82-4ffb-a09e-6652bf833be1",
  "color" : "0XFFF75B2A",
  "isSuperTroop" : true
}
```

Output:

```json
  Troop updated successfully!
```

<br>

### Delete a Troop

| Parameter      | Description                                                                                                |
|----------------|------------------------------------------------------------------------------------------------------------|
| `_id` (string) | Delete a Troop by providing it's _id. Example: `DELETE /delete-troop/6612bba0ced75d1ea06af6d2`             |
| `key` (string) | This operation requires an Auth key. Example: `DELETE /delete-troop/6612bba0ced75d1ea06af6d2?key=AUTH_KEY` |


Output:

```json
  Troop removed successfully!
```

<br>

### Delete all Troops

| Parameter      | Description                                                                            |
|----------------|----------------------------------------------------------------------------------------|
| `key` (string) | This operation requires an Auth key. Example: `DELETE /delete-all-troops?key=AUTH_KEY` |


Output:

```json
  All troops removed successfully!
```

<br>

## Run locally

- Create a env.properties file in resources directory:

  ```
  KEY = AUTH_KEY
  USER_NAME = your username
  PASSWORD = your password
  CLUSTER = your cluster
  DEV_DB = test DB name
  PROD_DB = Production DB name
  ```

- Change the connection string to yours in application.properties

- Run command:

  ```
  ./gradlew bootRun
  ```

- Navigate to:

  ```
  localhost:8080/
  ```

<br>

## Create your own Instance on Render

- [Fork](https://github.com/prasidhanchan/clash-guide-api/fork) this repository.
- Change the connection string to yours in application.properties
- Provide the Environment variables in the setup process on Render or any other platform:

  ```
  KEY = AUTH_KEY
  USER_NAME = your username
  PASSWORD = your password
  CLUSTER = your cluster
  DEV_DB = test DB name
  PROD_DB = Production DB name
  ```

- Deploy your app.
