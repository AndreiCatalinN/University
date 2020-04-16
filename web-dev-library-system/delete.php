<?php


include("conndb.php");

$usr = $_COOKIE['username'];
$sql="Delete from users where username like '$usr';";


  if ($conn->query($sql) === True)
  {
    echo "<script>alert('the account was deleted!')</script>";
    echo "<script>window.open('login_form.php','_self')</script>";
    include("logout.php");

  }
  else
  {
    echo " An   error ". $conn->error;
  }

  $conn->close();

 ?>
