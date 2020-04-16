<!DOCTYPE html>

<?php
  setcookie("username", null, time()-(86400*30), "/");
  header("location:login_form.php");
?>
