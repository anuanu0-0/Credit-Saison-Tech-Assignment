Frontend :
    1.Create a web page that accepts a string of numbers in an input box and sends to the backend.
    2.Create a second button for card statistics.
Backend :
    1. For every String:Number received from frontend make a call to the API provider (binlist.net)
    2. Store every string and their hit count as well as first hit timestamp and last hit timestamp.
    3. Build 2 GET APIs for -
        * One will get string:Num from frontend and use GET method to get data from the API Provider.
        * Another button on webpage named 'statistics' will call 2nd GET API which will get the unique strings 
            submitted to 1st API + No. of hits + Timestamps.



LEFT : 
1. Page styling - CSS
2. Integrate DOcker
3. Unit testing
4. Deploy Application
5. API Documentation