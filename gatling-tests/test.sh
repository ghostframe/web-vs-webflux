echo "Amount of users?"
read users
mvn clean gatling:test -Dusers=$users
cat target/gatling/lastRun.txt | while read -d $'\r\n' line 
do
  report=".\\target\\gatling\\$line\\index.html"
  explorer $report
done