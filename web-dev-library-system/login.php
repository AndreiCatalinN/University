<?php

session_start();
include("conndb.php");

//check if the cookie already exists
if(isset($_COOKIE["username"]))
{
  header("location:account.php");
}
$email = $conn->escape_string($_POST['email']);
$result = $conn->query("SELECT * FROM users WHERE email='$email'");
$check_user = mysqli_num_rows($result);
/*$pass_ck = $conn->escape_string($_POST['password']);
$pass_result = $conn->query("SELECT * FROM users password='$pass_ck");
*/
if ( $check_user == 0 )
{ // User doesn't exist
  $_SESSION['message'] = "User with that email doesn't exist!";
  echo "<script>alert('user does not exist')</script>";
  echo "<script>alert('Try again ,chief!')</script>";
  echo "<script>window.open('login_form.php','_self')</script>";

}
else
{
  //user will become a array with all the user data in it
  $user = $result->fetch_assoc();
  if ( $_POST['password']==$user['password'] )
  {
    //set cookie for 1 day= 86400 multiplay with 30 days
    setcookie("username",$user['username'],time() + (86400*30),"/");
    // This is how we'll know the user is logged in
    //$_SESSION['logged_in'] = true;
    header("location: account.php");
  }
  else
  {
    $_SESSION['message'] = "You have entered wrong password, try again!";
    print_r($_SESSION['message']);die;

    header("location: login_form.php");

  }//end else
}
  $conn->close();
?>
