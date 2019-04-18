<?php
 
// Create connection
$con=mysqli_connect("localhost","root","","sefinal");
//$con=mysqli_connect("sefinaldb.cor8aj5k23q6.us-east-2.rds.amazonaws.com","root","rootroot","AssignmentTracker");
 
/*Check connection
if (mysqli_connect_errno())
{
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
if($con){
  echo "Success";
}
 else{
   echo "failure";
 }
// Select all of our students from table 'student'
$sql = "SELECT * FROM student";
 
// Confirm there are results
if ($result = mysqli_query($con, $sql))
{
 // We have results, create an array to hold the results
        // and an array to hold the data
 $resultArray = array();
 $tempArray = array();
 
 // Loop through each result
 while($row = $result->fetch_object())
 {
 // Add each result into the results array
 $tempArray = $row;
     array_push($resultArray, $tempArray);
 }
 
 // Encode the array to JSON and output the results
 echo json_encode($resultArray);
}
 
// Close connections
mysqli_close($con);*/
?>
