# PAGG
Pathfinder Action Grid Game

Just started learning Java. First project is a Pathfinder supplement for PC vs PC fights in a client/server application. Rules are simplified in this first version.

great goals: fov-basic or -diamond<br>
fog of war<br>
threading<br>

until most of the game is finished the code will be full of comments with old code parts.
I'll tidy things up, when i feel its time to do it. Deal with it! ;)


10-06-2015 ---------------------------------------------------------

Took me a couple of days to invent a sight algorithm. It's not fully functional. Up until now only single sight blocks are working. Still have to combine vectors from sight blocks that are linked (walls). But for now i am happy with the results.

![sightdemo1](https://cloud.githubusercontent.com/assets/12558206/8083568/dc3968f6-0f85-11e5-9b0c-921b8bbee768.jpg)
![sightdemo2](https://cloud.githubusercontent.com/assets/12558206/8083571/e0a16146-0f85-11e5-831b-20d4a2e7caaf.jpg)
![sightdemo3](https://cloud.githubusercontent.com/assets/12558206/8083576/e448b132-0f85-11e5-9793-c3b10aaac6ff.jpg)

04-06-2015 ---------------------------------------------------------

movement fixed and done.
added MapSelection, player start and grid toggle in MenuBar
trying to understand LOS/FOV algorithm for implementation

03-06-2015 ---------------------------------------------------------

Movement algorithm almost done. Working just as i planed.
Have to fix OutOfBoundsException when calculating near field border.

But so far:
![path1](https://cloud.githubusercontent.com/assets/12558206/7956158/5f0611d8-09de-11e5-8689-382fd2fc5146.jpg)
![path2](https://cloud.githubusercontent.com/assets/12558206/7956161/645f71d8-09de-11e5-9f97-b0020676ba06.jpg)
or in the forest temple:
![path3](https://cloud.githubusercontent.com/assets/12558206/7956731/6874b9dc-09e2-11e5-9ae3-5ecd69dd0d7e.jpg)


29-05-2015 ---------------------------------------------------------

testing written breadth-first-algorithm for movement calculation!
generating a list of possible coordinates calculated on character movement speed almost reachable

28-05-2015 ---------------------------------------------------------

This is my first small TileSet i use to make the first maps and code tests:
(some space reserved for later tiles)

![tilesetcompletenumbers](https://cloud.githubusercontent.com/assets/12558206/7860479/d3e938a2-0549-11e5-90b7-7e97708bc9c7.jpg)

The first map was build in gimp with copying tile per tile in a big picture map
the tiles were not numbered at this time, so i had to write the integer map by comparing picture with the filename of the pictures.

![map1-2](https://cloud.githubusercontent.com/assets/12558206/7860557/5d7a0646-054a-11e5-8233-9d4d09aed066.jpg)


After i made the above TileSet with numbers i build a new map in gimp. The finished picture is easy to transscript into a integerMap.

![mapplain](https://cloud.githubusercontent.com/assets/12558206/7860561/660bbde0-054a-11e5-8797-972e1fc74f84.jpg)


Some adjustments to the tiles were made to improve the detail
Now the map ingame looks like this:
(small changes to the map and map-tiles)

![workinprogress](https://cloud.githubusercontent.com/assets/12558206/7860589/af808852-054a-11e5-9be8-e5fa5e08654a.jpg)


next ToDo: breadth-first-algorithm tests to generate a List of possible coordinates the player can move to
