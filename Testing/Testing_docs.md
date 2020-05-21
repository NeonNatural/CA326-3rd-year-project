## AudioSportUpdates Testing
##### Fawaz Alsafadi & Ayman Elegendy
---
### Table of contents
---
1. Functional testing
   - 1.1 Functional tests
   - 1.2 Installation testing
   - 1.3 performance testing
2. User interface tesing
3. Unit testing
4. Heursitic analysis 
5. Universal design
---

### 1. Functional testing
---
#### 1.1: Functional tests

***Test Case: Login with email and password***              
Input: "AudioUpdates@gmail.com", "123456"            
Expected Output: User successfully logs in          
Output: User logged in.        
Result: Success

***Test Case: Login with invalid email and password***           
Input: "Obama1260", "123456"            
Expected Output: Login will fail       
Output: User failed to login.        
Result: Success

***Test Case: User tries to register account***           
Input: Username="AudioUpdates@", Email = "AudioUpdates@gmail.com", Password = "123456", Confirm Password = "123456"                      
Expected Output: New account created in database.                                                                     
Output: Account has been registered.           
Result: Success

***Test Case: User follows a twitter page***         
Input: "fkaofsaf"
Expected Output: User begins following twitter page stream.     
Output: No twitter page related to input.    
Result: Failure     

***Test Case: User follows a twitter page***           
Input: "SkySportsBoxing"    
Expected Output: User begins following SkySportsBoxing twitter page stream.     
Output: User begins receiving tweets.     
Result: Success

#### 1.2: Installation Testing:
- Tested that the installation method earlier worked as intended.    
- Tested that the application ran an multiple different android devices.


#### 1.3: Performance testing 
CPU Usage:    
![alt text](https://i.imgur.com/z5tBoF4.png "CPU usage")  
Uses minimal CPU usage on average between 0-10%, Maximum spike recorded was 23 percent CPU usage.     

Memory:
![alt text](https://i.imgur.com/ZcMi0TC.png "CPU usage")

### 2. User interface testing
---
As shown below the app works well on a variety of screens and phones the two examples here are a 'Nexus 5x' which has a screen size of 5.2 and a 'Samsung galaxy s7 edge' which has a screen size of 5.5 and as the images show there is no distortion of scaling issues from screen size to another screen size.
##### Figure 2.1 Nexus 5x 5.2 inch display
![alt text](https://i.imgur.com/WG21lzR.png "Nexsus 5X phone")
##### Figure 2.2 Samsung galaxy s7 edge 5.5 inch display
![alt text](https://i.imgur.com/ew7d6Dj.png "Samsung s7 egde phone")
### 3. Unit testing
---
![alt text](https://i.imgur.com/LrIdLXt.png "Unit test1")
![alt text](https://i.imgur.com/N29wyPT.png "Unit test2")
![alt text](https://imgur.com/RnoKGHH.png "Unit test3")
![alt text](https://i.imgur.com/G15v6ar.png "Unit test4")    

![alt text](https://i.imgur.com/9z64Ryz.png "Unit test5")
![alt text](https://i.imgur.com/5LhngEj.png "Unit test6")
![alt text](https://i.imgur.com/xTTaLi9.png "Unit test7")
![alt text](https://i.imgur.com/dabO2ye.png "Unit test8")


### 4. Heuristic analysis
---
##### In order to carry out the heuristic analysis I will be using Jakob Nielsen's heuristics as guidelines.(https://www.nngroup.com/articles/ten-usability-heuristics/)

##### 4.1 Visibilty of system status
The status of the system is always aparent to the user, From logging on the user can see a progress icon that informs the user that the app is attempting to log the user in. Inside the app the user can at any time swipe left on the left of the screen to access the navigation drawer which will indicate that the system is working as it should be.
##### 4.2 User control and freedom
The user has complete control of the applicaion, they are always able to see where they are in the app by the text in the top toolbar which will tell them of the page they are on for example "Home" or "Audio updates". If the user accidentally enters a page they did not wish to go to they can at all time use the back and home buttons on the android device to nvaigate back to the home page alternatively the user can press the back button in the top toolbar to also go back out of any action.
##### 4.3 Consistency and standards 
Our application is consistent throughout, from the moment the user enter the app the text boxes are all labeled with hints to insure the user is aware of what to input and all the buttons of the app are the same colour and size. Inside the app the navigation drawer is present across all the pages and it is accessed in the same manner throughout the app. There are no contradictory design elements and everything unique is labeled and explained in the app.

##### 4.4 Error prevention
The app is carefulyl labbled through out with information on how to use the different system features this allows a good degree of error prevention and the user is not made guess. There are also error messages in place where the user has to manually enter a piece of information, for example if the user attempts to search a username to play audio and that username does not exist the user will be informed using an error message.

##### 4.5 Recognition rather than recall
The app uses many elements of the real world. For example the twitter updates page of the app has little play icons on the button which indicate to the user that they need to press this button to play and after a stop button will replace it indicating to the user that they can stop the stream by pressing the button again. The app uses inuitive layout so that it is easy to navigate and the user regardless of their technical background can use the app like any other app they may be already using.

### 5. Universal design
---
From the inception of the idea for this app we have always strived to create a universally accessible app. We have achieved this by ensuring that the information our app provides is relayed through multiple ways. Our app offers text-to-speech which can be used in place of having to read updates and also notifications which allow the user to read the information rather than listen. The app also uses large buttons and clear text with no distortion to enable people with weaker senses to also benefit from the app.

The app has a clean and simple design which aims to be accesible to any user regardless of how 'tech savy' they are, this helps create a rich and rounded experience for any user.
















