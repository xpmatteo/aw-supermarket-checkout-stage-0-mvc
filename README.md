
# Supermarket Checkout

This is a sample application; it is meant to show how to organize server-side code in a web application.

This is a Supermarket Checkout application.  We suppose that a supermarket cash operator will scan the barcode of items.  The application receives the barcode, and will look up the price of the item in a price list.  It will then show the price on a display.

There are three URLs that work.  If you go to http://localhost:8080/, you will see the user interface that simulates the supermarket hardware.

If you go to http://localhost:8080/scan?code=A, you will simulate scanning an item with barcode "A".

If you go to http://localhost:8080/total, you will see the current total.


## Exercise 1: make it work

We have the UI in the index.html file, but it does not work.  Your task is to add behaviour in JavaScript so that the index page calls the server with Ajax.

When we enter code "A" and press the button "Scan", the display should show "Price: 123"


## Exercise 2: show total

Add a button on the UI that will show "Total: 123" on the display when it is pressed.


## Exercise 3: reset.

Add a button on the UI that will reset the total to 0.  You will need to make changes to both UI and server-side code.





## Import the project in Eclipse

Install Maven.

Then run

    mvn eclipse:clean eclipse:eclipse -DdownloadSources -DdownloadJavadocs

Then use Import... > Existing Project in Eclipse.

## Run the project in Eclipse

In Eclipse, right-click on the it.xpug.example.main.Main class and select Debug As... > Java Application.

Then observe the application at http://localhost:8080/

## Run the project from the command line

Install maven.  Open a terminal window and cd to the directory of this project.  Then run

    mvn clean package
    java -cp target/classes:"target/dependency/*" it.xpug.example.main.Main

Then observe the application at http://localhost:8080/


