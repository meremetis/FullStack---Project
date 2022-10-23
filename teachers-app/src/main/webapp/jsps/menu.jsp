<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>menu</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/menu.css"/>
</head>

<body>
  <canvas id="c"> </canvas>
  <!-- forms -->

  <!-- teachers  -->
  <div class="teachers">
    <div class="center">
      <div class="section-title">Teachers</div>
      <!-- search -->
      <div class="search-raper">
        <div class="bot-gap">
          <h1 class="teacher-search-title">Search</h1>
        </div>

        <div>
          <form action="${pageContext.request.contextPath}/search-teacher" method="get">
            <input type="text" name="teacherlastname" id="teacher-name" placeholder="insert teacher lastname" autofocus />
            <br /><br />
            <button type="submit">search teacher</button>
          </form>
          <div class="errors-teacher-insert">
            <div>
              <c:if test="${sqlError}">
                <p>Error in insert</p>
              </c:if>
            </div>
          </div>
        </div>
      </div>
      <!-- search -->

      <!-- insert-->
      <div class="insert-raper">
        <div class="bot-gap">
          <h1 class="teacher-insert-title">Insert</h1>
        </div>

        <div>
          <form action="${pageContext.request.contextPath}/insert-teacher" method="post">
            <input type="text" name="teacher-lastname" id="teacher-lastname" placeholder="lastname" required autofocus /><br />
            <input type="text" name="teacher-firstname" id="teacher-firstname" placeholder="firstname" required />
            <br /><br />

            <button type="submit">insert teacher</button>
          </form>
          <div class="errors-teacher-search">
            <div>
              <c:if test="${teacherNotFound}">
                <p>teacher not found error</p>
              </c:if>
            </div>
            <div>
              <c:if test="${sqlErrorsearch}">
                <p>sqlError at search</p>
              </c:if>
            </div>
          </div>
        </div>
      </div>
      <!-- insert-->

      <!-- errors-->
    </div>
    <!--center div-->
    <!-- errors-->
  </div>
  <!-- teachers  -->






  <!-- students  -->
  <div class="students">
    <div class="center">

      <div class="section-title-student">Students</div>

      <!-- search -->

      <!-- search -->
      <div class="students-search-raper">

        <div class="bot-gap">
          <h1 class="students-search-title">Search</h1>
        </div>

        <form action="${pageContext.request.contextPath}/search-student" method="get">
          <input type="text" name="studentlastname" id="student-name" placeholder="insert student lastname" autofocus />

          <br /><br />
          <button type="submit">search student</button>

        </form>

        <div class="student-search-errors">
          <c:if test="${sqlErrorStudent}">
            <p>Error in insert Student</p>
          </c:if>
        </div>
      </div>



      <!-- search -->
      <!-- insert-->
      <div class="students-insert-raper">
        <div class="bot-gap">
          <h1 class="students-insert-title">Insert</h1>
        </div>



        <form action="${pageContext.request.contextPath}/insert-student" method="post">
          <input type="text" name="student-lastname" id="student-lastname" placeholder="lastname" required autofocus />
          <br />
          <input type="text" name="student-firstname" id="student-firstname" placeholder="firstname" required />
          <br /><br />

          <button type="submit">insert student</button>
        </form>
        <div class="student-insert-errors">
          <div>
            <c:if test="${studentNotFound}">
              <p>student not found error</p>

            </c:if>
          </div>

          <div>
            <c:if test="${sqlErrorsearchstudents}">
              <p>sqlError at search</p>
            </c:if>
          </div>
        </div>

      </div>
      <!-- insert-->
      <!-- errors-->



    </div>
  </div>
  <!-- errors-->
  <!-- students  -->
  <!-- students  -->
  <!-- students  -->
  <!-- students  -->
  <!-- students  -->

  <!-- courses  -->
  <!-- courses  -->
  <!-- courses  -->
  <!-- courses  -->
  <!-- courses  -->
  <div class="courses">
    <div class="center">

      <div class="section-title-courses">Courses</div>


      <div class="courses-search-raper">



        <div class="bot-gap">
          <h1 class="courses-search-title">Search</h1>
        </div>

        <form action="${pageContext.request.contextPath}/search-course" method="get">
          <input type="text" name="studentlastname" id="student-name" placeholder="insert student lastname" autofocus />
          <br /><br />
          <button type="submit">search course</button>
        </form>
        <div class="search-course-error">
          <c:if test="${sqlErrorcourse}">
            <p>Error in insert Course</p>
          </c:if>
        </div>
      </div>
      <!-- search -->
      <!-- insert-->
      <div class="courses-insert-raper">
        <div class="bot-gap">
          <h1 class="courses-insert-title">course insert</h1>
        </div>
        <div>
          <form action="${pageContext.request.contextPath}/insert-course" method="post">
            <input type="text" name="course-description" id="course-description" placeholder="desctription" required autofocus /><br />
            <input type="number" name="course-teacher-id" id="teacher-id" placeholder="teacher-id" required />
            <br /><br />
            <button type="submit">insert course</button>
          </form>

          <div class="insert-course-error">
            <div>
              <c:if test="${courseNotFound}">
                <p>course not found error</p>

              </c:if>
            </div>
            <div>
              <c:if test="${sqlErrorsearchcourse}">
                <p>sqlError at search course</p>
              </c:if>
            </div>
          </div>

        </div>
      </div>
      <!-- insert-->
      <!-- errors-->
      <!-- <div class="errors">


        </div> -->
      <!-- errors-->
    </div>
  </div>
  <!-- courses -->
  <!-- courses  -->
  <!-- courses  -->
  <!-- courses  -->

  <!-- studentcourse  -->
  <!-- studentcourse  -->
  <!-- studentcourse  -->
  <!-- studentcourse  -->
  <div class="studentcourse">
    <div class="center">

      <h1 class="studentcourse-title">Student Courses</h1>





      <div class="studentcourse-search-raper">
        <div class="bot-gap">
          <h1 class="courses-search-title">search</h1>
        </div>

        <div>
          <form action="${pageContext.request.contextPath}/search-studentcourse" method="get">
            <input type="text" name="studentlastname" id="student-name" placeholder="insert student lastname" autofocus />
            <br /><br />
            <button type="submit">studentcourse course</button>
          </form>
        </div>
        <div class="studentcourse-search-title">
          <!-- <c:if test="${sqlErrorstudentcourse}">
            <p>Error in insert StudentCourse</p>
          </c:if> -->
        </div>
      </div>
      <!-- search -->









      <!-- insert-->
      <div class="studentcourse-insert-raper">
        <div class="bot-gap">
          <h1 class="courses-search-title">Insert</h1>
        </div>

        <div>
          <form action="${pageContext.request.contextPath}/insert-studentcourse" method="post">
            <input type="number" name="studentcourse-studentId" id="" placeholder="studentcourse-studentId" required autofocus /><br />
            <input type="number" name="studentcourse-courseId" id="" placeholder="studentcourse-courseId" required />
            <br /><br />

            <button type="submit">student insert</button>
          </form>
        </div>
        <div class="studentcourse-insert-title">
          <div>

            <div class="studentcourse-search-title">
              <c:if test="${sqlErrorstudentcourse}">
                <p>Error in insert StudentCourse</p>
              </c:if>
            </div>
            <c:if test="${sqlErrorsearchstudentcourse}">
              <p>sqlError at search studentcourse</p>
            </c:if>
          </div>
          <div>
            <c:if test="${sqlErrorstudentcourseupdate}">
              <p>kati pige strava sto update</p>
            </c:if>
          </div>
        </div>
      </div>

    </div>
  </div>
  <!-- studentcourse  -->
  <!-- studentcourse  -->
  <!-- studentcourse  -->
  <!-- studentcourse  -->
  <!-- studentcourse  -->

  <script src="${pageContext.request.contextPath}/static/js/script.js"></script>
</body>

</html>
