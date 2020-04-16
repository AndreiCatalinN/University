<?php
    #get connection
    /*                  Hostname, User,   password, database name*/
    $conn = new mysqli('localhost','root', '','project' );
    #check if i can connect
    if ($conn->connect_error)
        die("Connection failed: " . $conn->connect_error . "<br/>");

    if ( $conn->connect_error )
        die("Connection failed : " . mysql_error());
?>
