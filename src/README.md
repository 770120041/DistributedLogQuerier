# DistributedLogQuerier
a simple distributed log querier written with Java

# Usage
using command line argument to set up the server for each client
The first argument is **an integer**, indicating the **port number** of the server.
The second message indicates the folder path that stores the data for the query. 

So after the Main class is compiled, we can use
1. java Main.java 9001 test 
1. java Main.java 9002 test 
1. java Main.java 9003 test 
1. java Main.java 9004 test 

to set up 4 nodes.

Also, before using this program, you need to change the value in the memberTable in Interpreter.java 
because the Member of the Distributed Querier and the root path for the data are hard coded now.

# Design Ideas
I have set up 4 modules for this project.
1. Package FileHandler: this module provides the basic ability for Clean a folder(delete all files it have)
(in FolderCleaner.java),
 List the files in a folder(DirLister.java) and Get Lines from a file(LineFeeder.java)
2. Package Greper: this module provides the ability for grep a regular expression for a Line(Greper.java), for a file
(FileGreper.java) and Grep for the whole folder(FolderGreper.java), and the following files are built upon the former ones.
3. Module MemberShip: used for each node knows how many members are there in the whole system, thus it can send 
grep request to each node. This module is now just a simple ArrayList stroing all members, this can be changed to a SWIM 
based Ping-Ack module later.
4. Module Com: this module provides the ablity for network communicaton between each nodes using TCP connection,
each node will set up a TCP server and can also set up a TCP connection with those servers. Each node in the distributed
System will use such method to communicate with each other.
  
  
 for the first and second modules, I have also written two unit Test which resides in package Test to test their functionality


  
