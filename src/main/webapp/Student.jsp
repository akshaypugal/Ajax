<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>


<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" id ="launch">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Student</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="form1">
         <input type="hidden" name="sid" id="sid">
  <div class="form-group">
    <label for="exampleInputEmail1">Student Name</label>
    <input type="email" class="form-control" name="sname" id="sname">
    
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Student Course</label>
    <input type="text" class="form-control" name ="scourse" id="scourse" >
  </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Student Fees</label>
    <input type="text" class="form-control" name="sfee" id="sfee" >
    
  </div>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="add">Add</button>
        <button type="button" class="btn btn-primary" id="edit">Save Edit</button>
      </div>
    </div>
  </div>
</div>



<table class="table table-dark" id="tableData">
  <thead>
    <tr>
      <th scope="col">Student ID </th>
      <th scope="col">Student Name</th>
      <th scope="col">Student Course</th>
      <th scope="col">Student Fee</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody id="tablebody">
   
    
    
  </tbody>
</table>


<script src="jq.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="Ajax.js"></script>
</body>
</html>