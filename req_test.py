import requests
import json

#curl --location --request POST 'http://localhost:8081/eloryks/api/v1/vehicle-authorization-request?Content-Type=application/json&Accept=application/json' \
#--header 'Content-Type: application/json' \
#--data-raw '{
#    "vin": "4Y1-SL658-4-8-Z-41-1439",
#    "key": "asdqweczzxc",
#    "action": "SPEED_LIMIT"
#}'

addr = 'localhost'
request_url = 'http://' + addr + ':8081/eloryks/api/v1/vehicle-authorization-request'
header = {'Content-Type': 'application/json'}
data_raw = {"vin": "4Y1-SL658-4-8-Z-41-1439","key": "asdqweczzxc","action": "SPEED_LIMIT"}

x = requests.post(request_url, json=data_raw, headers=header)
print(x.text)


car_request_id = 1
url_approval = 'http://' + addr + ':8081/eloryks/api/v1/vehicle-authorization-request/' + str(car_request_id)

y = requests.get(url_approval)
response_json = json.loads(y.text)
response_str = json.dumps(response_json, indent=2)

#print(response_str)

