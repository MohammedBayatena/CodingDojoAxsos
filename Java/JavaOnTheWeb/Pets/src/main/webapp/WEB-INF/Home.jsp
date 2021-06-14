<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" 
crossorigin="anonymous">
</head>
<body>


<div class="row  flex" >

<form class="flex flex-column m-3 border border-1 col" action="animals/dog" method="get">
<p> Make a Dog!</p>

<div class="row m-2">
  <div class="col-4">
    <input required type="text" class="form-control" placeholder="Name" aria-label="Name" name=dogName>
  </div>
</div>


<div class="row m-2">
  <div class="col-4">
    <input required type="text" class="form-control" placeholder="Breed" aria-label="Breed" name=dogBreed>
  </div>
</div>


<div class="row m-2">
  <div class="col-4">
    <input required type="text" class="form-control" placeholder="Weight(lb)" aria-label="Weight" name=dogWeight>
  </div>
</div>
<div class="row m-2">
	<input class="btn btn-primary offset-md-3 col-md-3" type= "submit" value="Submit" >
</div>
</form>


<form class="flex flex-column m-3 border border-1 col" action="animals/cat" method="get"   >  
<p> Make a Cat!</p>

<div class="row m-2">
  <div class="col-4">
    <input required type="text" class="form-control" placeholder="Name" aria-label="Name" name=catName>
  </div>
</div>


<div class="row m-2">
  <div class="col-4">
    <input required type="text" class="form-control" placeholder="Breed" aria-label="Breed" name=catBreed>
  </div>
</div>


<div class="row m-2">
  <div class="col-4">
    <input required type="text" class="form-control" placeholder="Weight(lb)" aria-label="Weight" name=catWeight>
  </div>
</div>
	<input class="btn btn-primary offset-md-3 col-md-3" type= "submit" value="Submit" >
</form>

</div>










</body>
</html>