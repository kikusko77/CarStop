# ELORYKS Authorization Server

Run the authorization server (install and configure `Docker` and `Docker-compose`):

```shell
$ docker-compose build
```

```shell
$ docker-compose up -d
```

## Documentation in Open API 3

The backend service is documented via Open API 3 (all the REST API calls)

```shell
http://localhost:8081/eloryks/api/v1/swagger-ui/index.html
```

## Inserting Vehicle Request for Approval

This example shows how to insert a new request (SPEED_LIMIT or for vehicle STOP) for approval

```shell
curl --location --request POST 'http://localhost:8081/eloryks/api/v1/vehicle-authorization-request?Content-Type=application/json&Accept=application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "vin": "4Y1-SL658-4-8-Z-41-1439",
    "key": "asdqweczzxc",
    "action": "SPEED_LIMIT"
}'
```

Example result (`request_id` that should be used for further reference)

```json
{
  "vehicleAuthorizationRequestId": 3
}
```

## Getting Info About the Vehicle Request for Approval

This example shows how to recieve if the request with id: 1 (can be replaced by any) is approved or now.

```shell
curl --location --request GET 'http://localhost:8081/eloryks/api/v1/vehicle-authorization-request/1'
```

Example result:

```json
{
  "id": 1,
  "vin": "4Y1-SL658-4-8-Z-41-1439",
  "key": "asdqweczzxc",
  "actionTimestamp": "2007-11-13T10:00:00",
  "action": "SPEED_LIMIT",
  "authorizedToSpeedLimitTargetVehicle": "NOT_DECIDED_YET"
}
```

# New Backend

## Getting Info About All the Vehicles

This example shows how to recieve all vehicles

```shell
curl -X 'GET' \
  'http://localhost:8081/eloryks/api/v1/its/vehicle/all?timestamp=2023-10-25T11%3A34%3A21.267Z&responsible=hv' \
  -H 'accept: application/json'
  ```

Example result

```json
{
  "Vehicle": [
    {
      "StationId": 0,
      "StationType": "string",
      "Position": {
        "Speed": 0,
        "Heading": 0,
        "Latitude": 0,
        "Longitude": 0,
        "Timestamp": "2023-10-27T13:15:33.204Z"
      },
      "CertificateId": "string",
      "EncryptionKey": {
        "KeyType": 0,
        "CoordX": "string",
        "CoordY": "string"
      },
      "SignKey": {
        "KeyType": 0,
        "CoordX": "string",
        "CoordY": "string"
      }
    },
    {
      "StationId": 1,
      "StationType": "string",
      "Position": {
        "Speed": 0,
        "Heading": 0,
        "Latitude": 0,
        "Longitude": 0,
        "Timestamp": "2023-10-27T13:15:33.204Z"
      },
      "CertificateId": "string",
      "EncryptionKey": {
        "KeyType": 0,
        "CoordX": "string",
        "CoordY": "string"
      },
      "SignKey": {
        "KeyType": 0,
        "CoordX": "string",
        "CoordY": "string"
      }
    }
  ]
}
```

## Getting Info About Vehicle by ID

This example shows how to retrieve specific vehicle by its ID

```shell
curl -X 'GET' \
  'http://localhost:8081/eloryks/api/v1/its/vehicle/2?timestamp=2023-10-25T11%3A34%3A21.267Z&responsible=jhv' \
  -H 'accept: application/json'
  ```

Example output

```json
{
  "Vehicle": [
    {
      "StationId": 2,
      "StationType": "string",
      "Position": {
        "Speed": 0,
        "Heading": 0,
        "Latitude": 0,
        "Longitude": 0,
        "Timestamp": "2023-10-27T13:15:33.204Z"
      },
      "CertificateId": "string",
      "EncryptionKey": {
        "KeyType": 0,
        "CoordX": "string",
        "CoordY": "string"
      },
      "SignKey": {
        "KeyType": 0,
        "CoordX": "string",
        "CoordY": "string"
      }
    }
  ]
}
```

## Inserting Vehicle

This Example Shows how to insert a new vehicle

```shell
curl -X 'POST' \
  'http://localhost:8081/eloryks/api/v1/its/vehicle?timestamp=2023-10-25T11%3A34%3A21.267Z&responsible=wef' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "Vehicle": [
    {
      "StationId": 0,
      "StationType": "string",
      "Position": {
        "Speed": 0,
        "Heading": 0,
        "Latitude": 0,
        "Longitude": 0,
        "Timestamp": "2023-10-25T11:34:21.267Z"
      },
      "CertificateId": "string",
      "EncryptionKey": {
        "KeyType": 0,
        "CoordX": "string",
        "CoordY": "string"
      },
      "SignKey": {
        "KeyType": 0,
        "CoordX": "string",
        "CoordY": "string"
      }
    }
  ]
}'
```

Example output

```json
{
  "responseStatus": {
    "ErrorCode": 0,
    "Message": "string"
  },
  "responseVehicle": [
    {
      "StationId": 0,
      "ErrorCode": 0,
      "Message": "string"
    }
  ]
}
```

## Updating a Vehicle by ID

This example shows how to update vehicle by its ID

```shell
curl -X 'PUT' \
  'http://localhost:8081/eloryks/api/v1/its/vehicle?timestamp=2023-10-25T11%3A34%3A21.267Z&responsible=df' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "Vehicle": [
    {
      "StationId": 1,
      "SpeedLimit": {
        "Speed": 10,
        "EngineSpeed": 10
      },
      "Position": {
        "Speed": 10,
        "Heading": 10,
        "Latitude": 10,
        "Longitude": 10,
        "Timestamp": "2023-10-25T11:34:58.215Z"
      }
    }
  ]
}'
```

Example output

```json
{
  "responseStatus": {
    "ErrorCode": 0,
    "Message": "Vehicle updated successfully"
  },
  "responseVehicle": [
    {
      "StationId": 1,
      "SpeedLimit": {
        "Speed": 0,
        "EngineSpeed": 0
      },
      "SpeedLimitEncrypted": "string",
      "ErrorCode": 0,
      "Message": "Vehicle updated successfully"
    }
  ]
}
```

## Deleting a Vehicle by ID

This example shows how to delete a vehicle\vehicles by its id

```shell
curl -X 'DELETE' \
  'http://localhost:8081/eloryks/api/v1/its/vehicle?timestamp=2023-10-25T11%3A34%3A21.267Z&responsible=gc&vehicles=1' \
  -H 'accept: application/json'
 ```

Example output

```json
{
  "responseStatus": {
    "ErrorCode": 0,
    "Message": "Vehicle deleted successfully"
  },
  "responseVehicle": [
    {
      "StationId": 0,
      "ErrorCode": 0,
      "Message": "Vehicle deleted successfully"
    }
  ]
}
```

