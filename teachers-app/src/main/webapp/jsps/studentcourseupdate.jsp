<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/update.css">
    </head>
    <body>
      <canvas id="c"> </canvas>
      <div class="from-wraper">
        <form action="${pageContext.request.contextPath}/update-studentcourse" method="post">
          <input class="hide"  type="number" name="oldstudentId" value="${studentcourse.studentId}"><br> 
          <input class="hide"  type="number" name="oldcourseId" value="${studentcourse.courseId}"><br> 

          <input type="number" name="studentId" value="${studentcourse.studentId}"><br> 
          <input type="number" name="courseId" value="${studentcourse.courseId}"><br> 
    
          <button type="submit">Update StudentCourse</button>
        </form>
    </div>

    <script src="${pageContext.request.contextPath}/static/js/script.js"></script>
    </body>
    </html>