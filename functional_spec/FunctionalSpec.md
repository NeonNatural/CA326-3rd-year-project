# Functional Spec

## 0. Table of contents
### 1. Introduction    
1.1 Overview    
1.2 Business Context     
1.3 Glossary    
### 2. General Description     
2.1 Product/System functions         
2.2 User Characteristics and Objectives      
2.3 Operational Scenarios        
2.4 Constraints         
### 3. Functional requirements
3.1 Create account      
3.2 Log in       
3.3 Follow journalists         
3.4 Customize preferences        
3.5 Customize sports preferences          
3.6 Text to speech        
3.7 Notifications         
3.8 Audio message from journalist.       
3.9 Rate journalist/give feedback       
3.10 Tune into sporting events.     
### 4. System Architecture
4.1 System architecture diagram
### 5. High level design
5.1 High level design diagram    
5.2 Data flow diagram    
### 6. Preliminary schedule 
6.1 Project plan     
6.2 Gannt chart      
### 7. Appendices
7.1 Appendices


## 1. Introduction

#### 1.1 Overview:
The application will connect users to sports journalists and receive live updates on popular sporting events. The set of journalists will be active twitter profiles chosen by us, or journalists who have signed up directly to our app. Journalists with the highest popularity on twitter will be recommended to users.

Many people has busy lifestyles and often find themselves overloaded with work, resulting in them being unable to do keep up with their favorite sporting events efficiently. Currently, the information supplied by these Twitter profiles is text based and requires much more user input to follow. The aim of our application will be to resolve this issue. It will provide the option of following your favorite sporting events as a secondary action to other daily tasks(e.g. Listening to the updates while driving or cooking).

The application will need to interact with the Twitter database. 

#### 1.2 Business Context
* There are a few business contexts in relation to this project
* Advertising
   * If we were to release this product to the market we could create tiles along side the interface which could allow Sports betting companies to display advertisements personalized to each users sports preferences which could prove to be very powerful to maximizing user interaction with the advertisement.
* Highlighting sports journalist agencies
   * Deals could be made with large sport journalists agencies to promote their journalists and recommend them to our users, these deals could be highly profitable.
 

#### 1.3 Glossary:
Java: Java is a general-purpose computer-programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible 

Android Studio: Android Studio is the official integrated development environment for Google's Android operating system, built on JetBrains' IntelliJ IDEA software and designed specifically for Android development. 

Google drive: Google Drive is a file storage and synchronization service developed by Google.

MySql: SQL is a domain-specific language used in programming and designed for managing data held in a relational database management system, or for stream processing in a relational data stream management system. 

## 2. General description

#### 2.1 Product/System functions:

- Create account
- Log in           
- Follow journalists 
- Customise preferences
- Customise sport preferences
- Text-to-Speech
- Notifications
- Audio message from the journalist 
- Rate journalist/give feedback
- Tune into sporting events

#### 2.2 User Characteristics and Objectives
User functions:     
After the user has correctly installed the app, they will create an account with a username and password in our database, they will use this account for all subsequent logins.
Upon login the user will have the option to select which sports they are interested in, allowing them to receive recommendations of journalists they might want to follow. If a journalist they are following is live, they will be notified and can simply tune in to start following the event.
Every account will have an option to request journalist status, if they want to sign up as a journalist who posts live updates directly to our app. One a request is sent it must be accepted by an administrator for them to receive journalist functionality(Post voice messages).

#### 2.3 Operational Scenarios:
![alt text](https://i.imgur.com/fxXZOF9.png "Use case 1")     
![alt text](https://i.imgur.com/tnEYGe5.png "Use case 2")     
![alt text](https://i.imgur.com/HKaS5pg.png "Use case 3")    
![alt text](https://i.imgur.com/gOLEmJX.png "Use case 4")




#### 2.4 Constraints:     
Time
   * The project has a strict deadline for completion. We will not have the time to  be able to explore the multitude of possible features and directions our app could take.
 
Testing
   * Due to the scope of the third year project we will only be demonstrating without a real journalist and only showing the platform works. This could lead to some some of the journalist functionality to be 'Rough around the edges' as there isn't real life input however we will minimize this with rigorous testing.

Platform
   * We have decided to create and develop this project for android, however the experience on iOS and other platforms may vary greatly due to hardware etc. While this is not a critical constraint it is something we should be aware of for future development. 

## 3. Functional requirements 


#### 3.1 Create account:
Description:    
Our system must allow the user to have an account which they can use to log in when they open the app. Their usernames and passwords will be stored, along with any data attached
to their account(such as preferences on journalists/events).

Criticality:     
This is among the most critical features of our app because our app is centered around tailoring the users experience they must make an account so all their preferences are saved. 

Technical issues:    
We must have a database where can safely and securely store the username,passwords and other data connected to an individuals account.

Dependencies:    
None

#### 3.2 Log in
Description:    
After creating an account, the user will now be able to use their log in details to access their personal account. This will be done with a straightforward log in script that will reference the username entered with our database and either log them in or reject based on correct details entered. 

Criticality:
This goes along with creating an account without which our system will lose it's personalization which is the goal for our end system, very critical.     

Technical issues: 
Implementing sufficient security so that the users details are protected and only a person with the correct username and password is able to access their account.    

Dependencies:
Depends on the user having successfully created an account.

#### 3.3 Follow journalists
Description:    
The user upon entering the app for the first time will be prompted to select a few journalists they prefer, this is the first step into a fully tailored experience.

Criticality:
It is not critical as the user will be given suggestions of popular journalists based on their reviews and ratings if they choose not to select their own favorites.

Technical issues: 
We will have to build a robust rating system so that the user is not misled when they choose to follow a 'highly rated' journalist.

Dependencies:
If the user chooses to follow journalists this will have to be added into our database as their preference.


#### 3.4 Customise preferences
Description:    
The user will be able to access the settings tab and choose to customize/update their preferences. This will include choosing method of updates, notifications, text-to-speech from updates generated from twitter or audio messages from the journalist the user will be able to select a mixture of these. The user will also be able to update their personal details and set a 'blackout' time where updates will not be displayed.

Criticality:
This is moderately critical as the user will be able to greatly enhance their experience if the method they are received is chosen by them however to ensure the app wills still function 'notifications' will be automatically selected if user does not update.

Technical issues: 
Creating a preference system that will be saved everytime the user logs in will be challenging.

Dependencies:
Create account, log in

 Customise sport preferences 

#### 3.5 Customise sport preferences 

Description:    
This differs from 3.4 customizing preference as this is to do with the sports the user is interested in. The user will be able to select specific sports they would like to follow so that they only get updates and recommendation for that sport alone, further more the user will be able to select specific events within sport.

Criticality:
It is critical because the user will be getting recommendation for all sports even the ones they are not interested in.

Technical issues: 
Making sure the user is only viewing sports they have chosen and nothing else.

Dependencies:
Create account, log in

#### 3.6 Text - to - Speech 

Description:    
This is one of the mediums the user can experience our app through, the app will extract information from twitter and the applications will convert it into speech through an API and speak it out to the user.

Criticality:
This is a very critical function as it is one of the three main methods the app will relay information to the user. The text - to - speech will be one of the attractions as it is handsfree allowing the user to listen without interacting with the phone.

Technical issues: 
Finding a text-to-speech API and building it into our system and finding one that sounds the most 'human' so that the voice has little distortion and the user has a pleasant experience. 

Dependencies:
It is not exactly dependent on any other function however the app is dependent on this function in order to deliver a complete package.

#### 3.7 Notifications

Description:    
The user will be able to opt-out of any audio feedback and choose to receive notifications instead. This will occur live time and a message will be displayed to the user as a notifications and inform of the latest details of the events they are following.

Criticality:
Highly critical to the system as it provides a method for the user to enjoy our app in times where audio feedback may not be convenient. Giving them silent updates will insure the user is always tuned in.

Technical issues: 
Managing the notifications so that they are not overwhelming and figuring out a system that can narrow notifications down. 

Dependencies:
App dependent 

#### 3.8 Audio message from journalist

Description:    
This feature will allow a journalist to enter our app into the journalist platform and record an audio message when an event happens in live time. This will them be sent to our Google drive database and then extracted from there through the use of an API and then the user can then play the clip and be informed on the event details.

Criticality:
Highly critical as it allows our users to receive the personal touch of their favorite sport journalists.

Technical issues: 
Linking Our app to a database then extracting MP3 clips through the use of an API

Dependencies:
App dependent

#### 3.9 Rate journalist/give feedback

Description:    
The function to enable users to rate and give feedback to journalist profiles. This is to insure that our users know which journalists is highly rated and who to follow. Also if a journalist has high amount of negative reviews and they may be spam or fake account we can spot it with our rating and feedback system.

Criticality:
Critical because in order to provide a refined and clean experience to the users we have to make sure the content they are viewing is correct.

Technical issues: 
Implementing a simple star system for different categories and making sure they are displayed clearly.

Dependencies:
Create account, log in.

#### 3.10 Tune into sporting events
Description:    
This function is the foundation of our idea it will enable users after completing or choosing the functions mentioned above to tune in and get information on the sporting events of their choice through text-to-speech, notifications or audio clips from the journalist. This will happen in live time so that it may substitute watching the event and rather listening to it on the go.

Criticality:       
Most critical, the app is centered around this function

Technical issues:    
Receiving updates from Twitter heavily relies on the reliability of the Twitter servers staying up. If Twitter were to go down, our functions would end up failing however this is unlikely and this is why we chose to extract information from twitter.

Dependencies:
Create account, log in, customsie preferences, customise sport preferences.


## 4. System Architecture:    
#### Fig. 4.1
![alt text](https://i.imgur.com/MDwU2xg.png "System architecture")



## 5. High level design:

#### Fig 5.1 High-level design diagram

![alt text](https://i.imgur.com/tZ0IOAu.png "High level design")

#### Fig 5.2 Data flow diagram



![alt text](https://i.imgur.com/LbuNRGm.png "Data flow diagram")



## 6. Preliminary schedule:
#### 6.1 project plan:    
Our project plan will be to follow a structured schedule in order to produce components of our system incrementally on time. Our project will consist of the following phases
- Requirement/Analysis phase   
- Design Phase    
- Development Phase    
- Testing Phase.    

These phases will consist of different components that our necessary in the development of our system. We will assign completion deadlines for each component and also a completion deadline
for each phase. We will adhere to these deadlines strictly.
#### 6.2 Gannt chart:    
![alt text](https://i.imgur.com/9jZdBvZ.png "Gannt chart")



## 7. Appendices 
Software resources we will be using:    
https://go.java/index.html     
https://developer.android.com/studio/    
https://www.mysql.com/     
https://about.twitter.com/      


