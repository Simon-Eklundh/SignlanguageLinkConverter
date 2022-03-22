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
