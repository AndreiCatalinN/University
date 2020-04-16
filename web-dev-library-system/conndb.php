<?php


$servername = "localhost";
$dbname = "proiect";
// Create connection
$conn = new mysqli("localhost","root","","web2");

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
//echo "<script>alert('Connection successfully');</script>";

?>
