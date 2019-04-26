#!/bin/bash
cp -r upgrade/inspectors/common/src .
cp -r upgrade/inspectors/00/class_hierarchy/src .
cp -r upgrade/inspectors/01/class_hierarchy/src .
cp upgrade/inspectors/start_server.sh .
rm src/main/resources/templates/inspectors/showdownloadpage.html
if [ ! -d ./src/main/resources/static/inspectors ]; then
  mkdir src/main/resources/static/inspectors
fi
wget -O src/main/resources/static/inspectors/diep-org-chart.js https://github.com/phamsodiep/frontend_research/raw/master/angularjs/component/org_chart/jslib/diep-org-chart.js
echo " "
echo "Below is LICENSE notice for 'diep-org-chart.js' library"
wget -q -O /dev/stdout https://github.com/phamsodiep/frontend_research/raw/master/LICENSE
echo " "
echo "Above is LICENSE notice for 'diep-org-chart.js' library"
