# SignlanguageLinkConverter

A simple converter which converts the following formats into two specific list formats:
# input
- 00001
- 00001,00002,00003
- https://teckensprakslexikon.su.se/sok/idnummer?q=00001%2C00002
- https://teckensprakslexikon.su.se/movies/00/skola-00001-tecken.mp4
- https://teckensprakslexikon.su.se/ord/00003

# output
- https://teckensprakslexikon.su.se/sok/idnummer?q=00001%2C00002%2C00003  
- {"name":"nameOfQuiz","link":["00001", "00002","00003"]}



# Usage:

Write the input top left and press add to add it, delete to remove it (doesn't work for the link to a sign list https://teckensprakslexikon.su.se/sok/idnummer?q=00001%2C00002  for these you have to add either a link to each word, or the five digit numbers for each word ).

<img width="249" alt="image" src="https://user-images.githubusercontent.com/14080408/160303253-4558b714-cdf6-44f6-9dd7-53f3f7946539.png">


When you've added all the words you want, you can press the convert to lexikon-link button to get a teckenspåkslexikon list

<img width="306" alt="image" src="https://user-images.githubusercontent.com/14080408/160303284-5f1e47c0-ee3e-4d8a-9725-a9e8ef1f71c8.png">

or the convert to import button to get a quiz link for https://tspquiz.se/app/#/start

<img width="151" alt="image" src="https://user-images.githubusercontent.com/14080408/160303348-afb384e3-f0df-4f29-9183-11a82f27fc1a.png">

The link will then be visible on the right middle of the screen.

<img width="771" alt="image" src="https://user-images.githubusercontent.com/14080408/160303368-043f6cb5-ce90-49f5-8303-489912f8c224.png">


On the left side you'll see all the currently added words (as numbers and the way they're found by the system)

The "Remove all data" button removes all added links, resetting the program 

<img width="264" alt="image" src="https://user-images.githubusercontent.com/14080408/160303412-62e310bc-be51-428f-8061-08bc49fb5428.png">



# Install instructions:

Make sure you have [java 8](https://www.java.com/en/download/manual.jsp) installed.

Then go to [releases](https://github.com/Simon-Eklundh/SignlanguageLinkConverter/releases)
and download the latest jar file.

You can then run the program by double clicking it or right clicking and pressing run.
