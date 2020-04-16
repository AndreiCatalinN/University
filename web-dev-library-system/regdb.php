
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <?php

    include("conndb.php");
    session_start();


    $username = $_POST['username'];
    $pass = $_POST['password'];
    $email = $_POST['email'];
    $code = $_POST['code'];
    $phone_no = $_POST['phone_no'];
    $firstname =$_POST['firstname'];
    $lastname =$_POST['lastname'];

    $photo = $_FILES['image']['name'];
    $photo_tmp = $_FILES['image']['tmp_name'];

    $username1 = $conn->escape_string($_POST['username']);
    $result = $conn->query("SELECT * FROM users WHERE username='$username1'");
    $check_user = mysqli_num_rows($result);

    $email = $conn->escape_string($_POST['email']);
    $result1 = $conn->query("SELECT * FROM users WHERE email='$email'");
    $check_mail = mysqli_num_rows($result1);


   if(($check_user == 0) && ($check_mail == 0))
   {
     $sql = "INSERT INTO users(username,password,email,code,phone_no,profile_pic,firstname,lastname) VALUES ('$username','$pass','$email','$code','$phone_no','$photo','$firstname','$lastname')" ;
     if ($conn->query($sql) === True)
     {
       echo "   record enterd successfully!";

     }
     else
     {
       echo "    error " . $sql . "<br>" . $conn->error;;
     }

     $conn->close();

     echo "<script>alert('new account was created')</script>";
     echo "<script>window.open('index.php','_self')</script>";
   }
   else
     {
       echo "<script>alert('change the username or email  // username or email is already used')</script>";
       echo "<script>window.open('Register.php','_self')</script>";
     }



    ?>
  </head>
</html>
