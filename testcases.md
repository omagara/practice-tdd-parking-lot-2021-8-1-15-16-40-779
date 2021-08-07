#Story 1
[X] Case 1  
Given a parking lot, and a car  
when park the car  
then return the parking ticket

[X] Case 2  
Given a parking lot, and a parking ticket  
when fetch the car  
then return the car

[X] Case 3  
Given a parking lot, with two parked cars, and two parking tickets  
when fetch the car twice
then return the right car with each ticket

[X] Case 4  
Given a parking lot, and a wrong parking ticket  
when fetch the car  
then return no car

[X] Case 5  
Given a parking lot, and a used parking ticket  
when fetch the car  
then return no car

[X] Case 6  
Given a parking lot with all spaces occupied, and a car
when park the car  
then return no parking ticket


#Story 2  
[ ] Case 1  
Given a parking lot, and an unrecoginized ticket  
when fetch the car  
then return nothing with error message Unrecognized parking ticket

[ ] Case 2  
Given a parking lot, and a used ticket  
when fetch the car  
then return nothing with error message Unrecognized parking ticket

[ ] Case 3  
Given a parking lot without any position  
when park the car  
then return nothing with error message No available position