Transform Hierarchy for an Animated Character

Author: Mike Gao
Student ID: 260915701
Character Name: /dev/null

Demo: Can be found under demo/pose.png (task 10: sample pose) and demo/animation.mp4 (task 12: animation video)
Character file: Can be found under data/character.xml (task 9)
Keyframe file: Can be found under data/character-keyposes.javabin (task 11)

Design Decision:
For the graphics stack, I simply used java stack because it worked fine and for this assignment no extra optimization is necessary. 
Since everything constructed essentially act as "final", I decide to pass everything into the constructor. With that, the only problem became null handling, and I'm particularly careful in the ReadXML java file to handle the missing property and filling in the default value.
Used a single geometry class to handle different shape so that I can instantiate it easily in CharacterFromXML.java
