MORCIPID=$(/opt/prod_jdk/bin/jps -l | grep morci-travel-api-.*.jar | awk '{print $1}')
if [ -n "$MORCIPID" ]; then kill -9 $MORCIPID; else echo 'App not running, maybe the server was restarted'; fi