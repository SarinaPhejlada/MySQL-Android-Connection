<?php
    require "connection.php";
    $user_name = $_POST["student_No"];
    $user_pass = $_POST["password"];
    //$user_name = "bDylan1";
    //$user_pass = "12345";
    //$user_name = "sarinap";
    //$user_pass = "password";
    $mysql_qry = "select * from student where student_No like '$user_name' and password like '$user_pass';";
    //$mysql_qry = "SELECT * FROM AssignmentTracker.Teacher WHERE username like '$user_name' and passcode like '$user_pass';";
    $result = mysqli_query($con ,$mysql_qry);
    if(mysqli_num_rows($result) > 0) {
        $row = mysqli_fetch_assoc($result);
        $name = $row["firstName"];
        echo $name;
    }
    else {
        echo "Failure";
    }
?>