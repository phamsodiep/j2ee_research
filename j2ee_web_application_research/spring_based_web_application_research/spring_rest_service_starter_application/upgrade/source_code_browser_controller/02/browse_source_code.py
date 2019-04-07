#!/usr/bin/python

import requests
import sys
import json

end_point = "http://localhost:8080/sourcecodebrowser/target"
targetfile = "untitled.java"
pos = 2048

if len(sys.argv) >= 2:
    targetfile = sys.argv[1]
    pos = sys.argv[2]


post_data = {"file": targetfile, "position": pos}
headers = {"Content-type": "application/json"}
response = requests.post(end_point, data = json.dumps(post_data), headers = headers, verify = False)

print "[" + str(response.raw.read()) + "]"

