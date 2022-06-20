```
http :8084/users id="jyjang@uengine.org" city="PARIS" #portal
http http://localhost:8084/personalizedRecommendations

http :8085/weathers city="PARIS" weather="WINDY"  #weather
http "http://localhost:8084/personalizedRecommendations"

http :8081/attireRecommendations attire="바람막이" key="PARIS_WINDY"   #wear
http "http://localhost:8084/personalizedRecommendations"

http :8083/foodRecommendations key="PARIS_WINDY" restraunt="뱅쇼"    #food
http "http://localhost:8084/personalizedRecommendations"
```