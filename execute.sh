#!/bin/bash
javac -cp bin/ -d bin/ -Xlint src/controleur/Controller.java
javac -cp bin/ -d bin/ src/CustomFrame1.java
javac -cp bin/ -d bin/ -Xlint src/model/ABR.java
javac -cp bin/ -d bin/ -Xlint src/model/TabABR.java
javac -cp bin/ -d bin/ src/Main.java
java -cp bin Main
