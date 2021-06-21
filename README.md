# Submission by Garrett Quintero

## Running Instructions
To run the project, run ` java -jar MessageTemplateMaker-v1.jar ` in your terminal.
That should start the version of this project that took approximately 5 hours of honest work. <br>

When prompted for the files you would like to use, the application should process the filename you provide relative 
to where you are running it.

For the version of my code that went into this JAR, see commit ` e0c2aa59af6a8d1c2c5294293d2dcd96b4364755 `

I plan to continue working on this project for my own exercise. There will be a v2 version of the MessageTemplateMaker 
JAR once I feel happy with what it can do.

## Design Decisions
When I set out to start this project, I hadn't worked with any form of JSON file before. That lead me to searching for 
a toolset to work with instead of attempting to write my own JSON parser. The library I wound up using is listed as 
`com.googlecode.json-simple:json-simple:1.1.1 `.

Within some of the more basic classes like Guest and Company, there are some constant strings defined mostly for my 
own use. Their purpose was to make it easier for me to avoid misspelling the keys from the JSON files provided as I 
worked from file to file. My goal with them was to have a tool in place so that anywhere I needed those keys, they'd be 
consistently spelled, even if I had to change them at some point.

My skills aren't as geared towards front-end development as much as I'd like, so this became a terminal based 
application to make sure I spent most of my time working on the project itself instead of just a GUI.

### Language Decision
I chose to work on this project in Java because of its portability between systems. Java is also one of the languages 
I originally learned and feel most comfortable working with. With those factors in mind, and my familiarity with the 
IntelliJ IDEA IDE, it just seemed like the best choice.


## Verification
Originally I had planned to use JUnit tests for automated testing of the application, but ran out of time.
Instead, I tested mostly by manually running the application and tracking its outputs. As I was building the Loader 
tools, I was frequently using IDEA's debugging tools to track what was being processed and verify that the information 
I wanted to be processed was correct.

Ideally, I would continue developing and create tests that can be run every time the application is built to ensure no 
new errors are produced by any new changes.


## What's left undone
As I write this, my application does not generate the desired messages from the selected data. I do presently have a 
plan to complete its functionality, but ran out of time within the five-hour limit I had set for myself.

The ability to change a time-based greeting was something I had planned to implement as a part of the message 
generation process. At the moment, it stands incomplete.

There are also several points throughout the application that I would like to implement more data validation, 
especially in the message generation process that is in place. As it stands, wrong inputs should cause errors. I would
also like to take the time to work on the error handling to make it more easily readable than the default system errors.

### My personal checklist
 [x] Create format for template JSON files
 [x] Load in template from JSON
 [x] Generate new templates within application
 [x] Write new templates to JSON for later use
 [x] Load in Guests from JSON
 [x] Load in Companies/Hotels from JSON
 [ ] Modify messages based on time
 [X] Be able to select elements used in message generation
 [ ] Generate message based on input criteria
 