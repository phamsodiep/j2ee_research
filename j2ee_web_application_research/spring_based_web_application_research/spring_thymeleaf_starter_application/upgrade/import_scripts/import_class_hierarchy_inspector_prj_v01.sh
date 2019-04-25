#!/bin/bash
cp -r upgrade/inspectors/common/src .
cp -r upgrade/inspectors/00/class_hierarchy/src .
cp -r upgrade/inspectors/01/class_hierarchy/src .
cp upgrade/inspectors/start_server.sh .
rm src/main/resources/templates/inspectors/showdownloadpage.html
