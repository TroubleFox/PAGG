# PAGG
Pathfinder Action Grid Game

Just started learning Java. First project is a Pathfinder supplement for PC vs PC fights in a client/server application. Rules are simplified in this first version.

Goals: fov-basic or -diamond;
fog of war


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
