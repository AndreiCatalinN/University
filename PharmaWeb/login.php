<?php
require_once "connectdb.php";

$username= "";
$pass= "";

function inputStuff( $identifier)
{
  $var = trim( $_POST[$identifier]);
  #Strips sql injections
  $var = strip_tags($var);
  #puts special characters so it's unhackable
  $var = htmlspecialchars($var);
  return $var;
}

$username = inputStuff("user");
$pass = inputStuff("pass");

$stmt = $conn->prepare("SELECT Username, password FROM users WHERE username = ?");


$stmt->bind_param("s", $username);


if($stmt->execute())
{

  $stmt->bind_result($u, $p);

  $stmt->fetch();

  # fetch value
  if(  strcmp($result, $username) != 0 || strcmp($DatabasePass, $pass) != 0 )
  {
    echo "<script>
          window.location = 'index.php';
          alert('Wrong user or password');
          </script>";
  }
  else
  {
    $GLOBALS['registered'] = 1;
    echo "<script>
          window.location = 'index.php';
          alert('Connected');
          </script>";
  }
}
?>
