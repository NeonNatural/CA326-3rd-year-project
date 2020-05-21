# AudioSportUpdates Technical Specification
### CA326
##### Fawaz Alsafadi and Ayman Elgendy
---
### 0.Table of contents
---
- 1.Introduction
  - 1.1 Overview
  - 1.2 Glossary
- 2.System Architecture
- 3.High-level design
    - Fgure 1 - Activity diagram
    - Figure 2 - Context diagram
    - Figure 3 - Data flow diagram
    - Figure 4 - Sequence diagrams
- 4.Problems and resolution
- 5.Development and testing
    - 5.1 Development
    - 5.2 Testing
- 6.Installation guide
    - 6.1 Requirements
    - 6.2 Installation steps
 

### 1.Introduction

#### 1.1 Overview
---
AudioSportUpdates is an app that is designed to give the user updates and keep the user informed on their favourite sports all through a hands-free expreience. This is done through the various audio and notification features that our app includes. The main features of our app are; Sport updates from twitter journalists and a facility that allows the users to record a audio clip that could be an update for a sporting match and then anyone using the app can play back the audio message using a username.

The twitter update feautre, retreives the latest tweets from a public twitter profile and relays them back to the user. This is done in two ways. The first is text-to-speech, this simply takes a tweet and converts it to speech and the user is then able to listen to it on the phone speakers. The second form the tweet is shown to the user is through the use of push notifications, the latest tweet that has come in gets displayed to the user through a push notifications so that they may be able to read it if they are unable to listen. 

The Audio update feature, allows the user to playback a audio clip that another user has recorded. Any user can navigate to the audio update page of the app and press the record button which will begin recording the voice through the microphone. Then after the user is happy with the recording they can uplaod it for anyone else on the app to listen to.

The app is desgined for a fast-paced lifestyle where the user may not have the time to tune into long sport matches so the app caters to these users through all the functions mentioned above. It also provides a great level of accesibltyy to wide range of users as it can be experinced through various human senses thanks to the audio and notifictaion functionailty of the app.
#### 1.2 Glossary
***Retrofit***: Rest client library for android that makes it easy to consume/parson JSON    

***Rxjava***: Library for composing asynchronous and event-based programs by using observable sequences

***XML*** - Extensible Markup Language

***JSON*** - JavaScript Object Notation, Data interchange format

***Google firebase*** - Firebase is a mobile and web application development platform

***Android studio*** - Android Studio is the official integrated development environment for Google's Android operating system



### 2.System Architecture
---
![alt text](https://i.imgur.com/8dC70Zb.jpg "System Architecture")


### 3. High-Level Design
---
##### Figure 1 - Activity diagram
---
![alt text](https://i.imgur.com/6p5q8tS.jpg "Activity Diagram")
##### Figure 2 - Context diagram
---
![alt text](https://i.imgur.com/ZrRzrn2.png "Context diagram")
##### Figure 3 - Data flow diagram
---
![alt text](https://i.imgur.com/qfCg6vC.png "Data flow diagram")

##### Figure 4 - Sequence diagrams
---
| Fig 4.1 Registration       | Fig 4.2 Twitter updates |Fig 4.3 Audio updates|
| :-------------: |:-------------:| :-----:|
|![alt text](https://i.imgur.com/vsXEBad.png "registration sequence diagram")| ![alt text](https://i.imgur.com/F117iAy.png "Twitter updates sequence diagram")|   ![alt text](https://i.imgur.com/CNHRnUh.png "Audio update sequence diagram")|


### 4.Problems and Resolution
---
##### 4.1
 ***Problem***:  Learning the intricacies of Android Studio and how projects are built.      
 ***Solution***: Began by following numerous introductions to Android Studio early on in the year, followed by implementing some basic Applications to perform simple tasks.
 Once we completed these we became familiar Android studio and also learned how to read and fix common errors thrown when first beginning with the IDE.
##### 4.2
***Problem***: Figuring out how to build the correct requests to interact with the Twitter API. Initially we were not adding the correct parameters to our Oauth2 and struggled
to understand why we were not getting a bearer token in response to our requests.      
***Solution***: Read all of the relevent API documentations in the Twitter Api docs and used the retrofit and rxjava libraries figure out how to handle requests and responses.
Figured out which required parameters were missing from the initial request(Which was an authorization header) and resolved the issue.
##### 4.3 
***Problem***: Have alot of the same code used in many classes.                  
***Solution***: Tried to implement some dependency injection using Dagger 2 but did not successfully implement it by deadline.
##### 4.4 
***Problem***: Understanding segments of the code written by the other person.                    
***Solution***: Resolved by using frequent and clear communication with each other about our individual work.
##### 4.5
***Problem***: We were nearing the end of the project without implementing many of the personalisation features we had planned.     
***Solution***: We had to abandon the ability for users to create a personalised list of their favourite twitter profiles for easy access and instead
allowed the user to simply search for any Twitter page via a textbox.

### 5.Development and testing
---
##### 5.1 Development
- To develop our android application we used Android studio, this was a free and reliable platform for android app development and it is used by the vast majority of developers in the industry. For our server we used Google Firebase, Firebase comes with a great amount of tools that we used it is also free and stable as it is provided by google. The firebase services that we used we're storage to store users audio clips and authentication to allow users to create accounts and login to our app
- The final implementation of the project is very similar to the orginal ideas set out in the functional sepcification at the begining of this development cycle. All the main features that we set out to do such as audio updates, twitter updates, text-to-speech and updates by text have been succefully implemented and are working as intended. 
- Some features however had to be left out of the final app due to us running out of time. For example we intended to allow a deeper level of customisation for the user for example get a list of journalists based on the users sport prefrence. 
- If given more time and if we continue work on this application in our spare time these features would be implemented and the app will be exactly as we set out in the functional specification.
##### 5.2 Testing
Information on the tests carried out can be found in the 'Testing' directory of our gitlab repo -  https://gitlab.computing.dcu.ie/alsafaf2/2019-ca326-alsafaf2-audiosportsupdates
- These are the tests that were carried out during the life cycle of the application
    - Functional testing
    - User interface testing
    - Unit testing
    - Heuristic analysis
    - Universal design




### 6.Installation Guide
---
##### 6.1 Requirements
- Android stuido 3.3.1
- Java 8
- Android device 5.0.1 Lollipop or higher

##### 6.2 Installation steps
- Download our GitLab repo at https://gitlab.computing.dcu.ie/alsafaf2/2019-ca326-alsafaf2-audiosportsupdates and save it to desired folder.
- Make sure developer mode is enabled on your Android device and USB Debugging is enabled.
- Open the project in Android studio and plug in your Android phone to the computer using a USB cable.
- Click the run button that looks like a green play button in the top right corner of the Android studio project and select your android phone as the target device.
- The app will automatically install and run on your phone.     
- 


### 7. References 
https://firebase.google.com/docs/android/setup     
https://developer.android.com/studio      
https://square.github.io/retrofit/      
https://github.com/ReactiveX/RxJava       
https://medium.com/3xplore/handling-api-calls-using-retrofit-2-and-rxjava-2-1871c891b6ae         
https://developer.twitter.com/en/docs.html        















