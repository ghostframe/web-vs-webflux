while true
do
  echo "===================="
  echo "=== NUEVA PRUEBA ==="
  echo "===================="
  echo
  echo "- ¿Cantidad de usuarios?"
  read users
  echo "- ¿Tardanza en responder del API externa (ms)?"
  read apiDelay
  echo "Corriendo gatling..."
  mvn clean gatling:test -Dusers=$users -DapiDelay=$apiDelay
  cat target/gatling/lastRun.txt | while read -d $'\r\n' line 
  do
    report=".\\target\\gatling\\$line\\index.html"
    explorer $report
  done
done