<?php
    require "connection.php";
    $user_name = $_POST["student_No"];
    $user_first = $_POST["firstName"];
    $user_last = $_POST["lastName"];
    $user_pass = $_POST["password"];
    //$user_name = "beef";
    //$user_first = "mister";
    //$user_last = "beefy";
    //$user_pass = "123";
    $user_null = "null";
    $mysql_qry = "INSERT INTO `student`(`student_No`, `firstName`, `lastName`, `password`, 
    `submissionRate`, `Teacher_userName`) VALUES ('$user_name','$user_first','$user_last','$user_pass',
    '$user_null','$user_null')";
    
    if($con->query($mysql_qry) === TRUE) {
        echo $user_first;
    }
    else {
        echo "Failure";
    }
    $con->close();
?>