<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Course update</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/update.css">
</head>
<body>
  <canvas id="c"> </canvas>
  <div class="from-wraper">
    <form action="${pageContext.request.contextPath}/update-course" method="post">

      <input class="hide" hidden type="text" name="id" value="${course.id}"><br> 
      <input type="text" name="description" value="${course.description}"><br> 
      <input type="text" name="teacherId" value="${course.teacherId}"><br> 

      <button type="submit">Update Course</button>
    </form>
</div>

<script src="${pageContext.request.contextPath}/static/js/script.js"></script>
</body>
</html>