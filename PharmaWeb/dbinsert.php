
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <?php
      require_once "connectdb.php";

      $username= "";
      $pass= "";
      $repass= "";

      $fname= "";
      $sname= "";
      $email= "";
      $address = "";
      $gender = "";

      $error = true;
      $emailError= "";
      $repassError= "";

      function inputStuff( $identifier)
      {
        $var = trim( $_POST[$identifier]);
        #Strips sql injections
        $var = strip_tags($var);
        #puts special characters so it's unhackable
        $var = htmlspecialchars($var);
        return $var;
      }

      function displayAlert($message)
      {
        echo "<script>

                alert(".$message.");
              </script>";
      }


      $username = inputStuff("user");
      $pass = inputStuff("pass");
      $repass = inputStuff("repass");
      $fname = inputStuff("fname");
      $sname = inputStuff("sname");
      $email = inputStuff("email");
      $address = inputStuff("address");
      $gender = inputStuff("gender");
      $birthday = inputStuff("birthday");

      #compare the passwords
      if(strcmp($pass, $repass) == 0)
        $error =  false;
      else
      {
        $error = true;
        $errormsg = "Passwords don't match";
      }
      #Check if email is already in the database
      $stmt = $conn->prepare("SELECT email FROM users WHERE email = ?");
      $stmt->bind_param("s", $email);

      if($stmt->execute())
      {
        # bind result variables
        $stmt->bind_result($result);
        # fetch value
        if($stmt->fetch() != true)
          $error = false;
        else
        {
          $error = true;
          $errormsg = "Email is already in use";
        }
      }

      $stmt -> close();

      $stmt = $conn->prepare("SELECT Username FROM users WHERE username = ?");
      $stmt->bind_param("s", $username);

      if($stmt->execute())
      {
        # bind result variables
        $stmt->bind_result($result);
        # fetch value
        if($stmt->fetch() != true)
          $error = false;
        else
        {
          $errormsg = "username is already in use";
          $error = true;
        }
      }

      #do the insert
      # If everything is ok, insert into database
      if(!$error)
      {
        $insert ="INSERT INTO users (Username, password, First_name, surname, email, address, gender, Birthday)VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        $stmt2 = $conn->prepare($insert);
        $stmt2->bind_param("ssssssss", $username, $pass, $fname, $sname, $email, $address, $gender, $birthday );

        if( $stmt2->execute() )
        {
          $errormsg = "Successfully registered";
          echo "<script>
                  window.location = 'index.php');
                  alert('Account has been created You can log in now');
                </script>";
        }
        else
          $errormsg = "Something went wrong";

        $stmt2->close();
        $conn ->close();
      }
      else
      {
        # from stack overflow
        #https://stackoverflow.com/questions/22745425/how-to-return-to-the-previous-page-after-a-submit-form-with-php
        echo" <script> window.location = 'Register.php';
                      alert('".$errormsg."')
        </script>";
      }
      ?>
  </head>
</html>
