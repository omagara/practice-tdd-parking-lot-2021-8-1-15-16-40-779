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
[X] Case 1  
Given a parking lot, and an unrecoginized ticket  
when fetch the car  
then return nothing with error message Unrecognized parking ticket

[X] Case 2  
Given a parking lot, and a used ticket  
when fetch the car  
then return nothing with error message Unrecognized parking ticket

[X] Case 3  
Given a parking lot without any position  
when park the car  
then return nothing with error message No available position


#Story 3
[X] Case 1  
Given a parking lot, a standard parking boy, and a car  
when park the car 
then return the parking ticket

[X] Case 2  
Given a parking lot, a standard parking boy, and a parking ticket  
when fetch the car 
then return the car

[X] Case 3  
Given a parking lot with two parked cars, a standard parking boy, and two parking tickets  
when fetch the car twice 
then return the right car with each ticket

[X] Case 4  
Given a parking lot, a standard parking boy, and a wrong parking ticket  
when fetch the car
then return nothing with error message Unrecognized parking ticket

[X] Case 5  
Given a parking lot, a standard parking boy, and a used parking ticket  
when fetch the car
then return nothing with error message Unrecognized parking ticket

[X] Case 6  
Given a parking lot with all spaces occupied, a standard parking boy, and a car
when park the car
then return nothing with error message No available position

#Story 4
[X] Case 1  
Given a standard parking boy, two available parking lots and a car  
when park the car  
then  the car will be parked to the first parking lot

[X] Case 2  
Given a standard parking boy, two parking lots, first is fully occupied, second is available, and a car  
when park the car  
then the car will be parked to the second parking lot

[X] Case 3  
Given two parking lots with two parked cars, a standard parking boy, and two parking tickets  
when fetch the car twice  
then return the right car with each ticket

[X] Case 4  
Given two parking lots, a standard parking boy, and an unrecognized parking ticket  
when fetch the car  
then return nothing with error message Unrecognized parking ticket

[X] Case 5  
Given two parking lots, a standard parking boy, and a used parking ticket  
when fetch the car  
then return nothing with error message Unrecognized parking ticket
  
[X] Case 6  
Given two parking lots,both fully occupied, a standard parking boy, and a car
when park the car  
then return nothing with error message No available position


#STORY 5
[ ] Case 1  
Given a smart parking boy, two available parking lots and a car  
when park the car  
then  the car will be parked to the first parking lot

[ ] Case 2  
Given a smart parking boy, two parking lots, second parking lot has more space than first, and a car  
when park the car  
then the car will be parked to the second parking lot

[ ] Case 3  
Given a smart parking boy, two parking lots, first parking lot has more space than second, and a car  
when park the car  
then the car will be parked to the first parking lot

[ ] Case 4  
Given two parking lots with two parked cars, a smart parking boy, and two parking tickets  
when fetch the car twice  
then return the right car with each ticket

[ ] Case 5  
Given two parking lots, a smart parking boy, and an unrecognized parking ticket  
when fetch the car  
then return nothing with error message Unrecognized parking ticket

[ ] Case 6  
Given two parking lots, a smart parking boy, and a used parking ticket  
when fetch the car  
then return nothing with error message Unrecognized parking ticket

[ ] Case 7  
Given two parking lots,both fully occupied, a smart parking boy, and a car  
when park the car  
then return nothing with error message No available position
