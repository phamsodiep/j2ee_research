#!/usr/bin/python

import requests
import sys
import json

end_point = "http://localhost:8080/sourcecodebrowser/config"

post_data = {"host": "sjc.local", "port": "9999", "authorizationKey": "banananananananananananana"}
headers = {"Content-type": "application/json"}
response = requests.post(end_point, data = json.dumps(post_data), headers = headers, verify = False)

print "[" + str(response.raw.read()) + "]"

