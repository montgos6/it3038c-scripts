DATA=$(curl https://api.covidtracking.com/v1/us/current.json)
POSITIVE=$(echo $DATA | jq '.[0].positive')
NEGATIVE=$(echo $DATA | jq '.[0].negative')
HOSPITALIZED=$(echo $DATA | jq '.[0].hospitalized')
DEATHS=$(echo $DATA |jq '.[0].death')
TODAY=$(date)

echo "On $TODAY, there was $POSITIVE positive COVID cases, and $NEGATIVE negative COVID cases. There were also $HOSPITALIZED hospitalizations and $DEATHS deaths"

