# ticTacToe

This is a project for building a 3 player ticTacToe game for a variable size(3->9) board. The project makes use of
deterministic algo. There is an implementation of min-max algo present to which the code can be easily switched to.

The main program is the org.ab.ticTacToe.Game Class. By running execute() on it, the program loads the config(config.properties) in src/main/resources and begins. The config can be kept outside of the project by changing the stream.

**Below are the assumptions the game makes:**<br />
*1) The player symbols are case sensitive and can only be non space characters.* <br />
*2) Game is over if one player wins or the game is draw*<br />
*3) The program wont proceed until valid input (from human) is entered. Computer enters valid input is assumed.*<br />
*4) The character asterik is reserved for decoration of playing board.*<br />


The project is a maven project, and can be built in eclipse. 

To Test  : **maven test**
 
To Build : **maven install**

To run   : **cd ${jar_location}**<br />
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; **java -jar ticTacToe-1.0.jar**



