<html>
  <head>

    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome</title>
    <style>
      html {
    height: 100%;
  }
  body {
    display: flex;
    height: 100%;
    background-color: rgb(0, 0, 0);
  }
  .word {
    margin: auto;
    color: white;
    font: 700 normal 2.5em 'tahoma';
    text-shadow: 5px 2px #222324, 2px 4px #222324, 3px 5px #222324;
  }
  a
  {
    opacity: 0;
    color: white;
    position: absolute;
    top:48%;
    left: 46%;
    color: white;
    font-size: 40px;
    font-weight: bold;
    animation: fade-in 1s forwards;
    animation-delay: 11s;
    
  }
  a:hover
  {
      border: 2px solid #73ff00;
      color: #73ff00;
      box-shadow: 0px 0px 10px 10px #73ff00;
    
  }
  
  
  
  @keyframes fade-in {
    0% { opacity: 0;font-size: 16px; }
    100% { opacity: 1;font-size: 50px; }
  }
    </style>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  </head>
<body>

<!-- <a href="${pageContext.request.contextPath}/jsps/login.jsp">log in</a> -->

<div class="word"></div>
<a id="login" href="${pageContext.request.contextPath}/jsps/login.jsp">Start</a>
<script>
  var words = ['Hello, Welcome', 'Project - Teachers App', ' aueb / 2022 '],
    part,
    i = 0,
    offset = 0,
    len = words.length,
    forwards = true,
    skip_count = 0,
    skip_delay = 15,
    chec_to_login = false;
    speed = 70;
    
var wordflick = function () {
  setInterval(function () {
    if (forwards) {
      if (offset >= words[i].length) {
        ++skip_count;
        if (skip_count == skip_delay) {
          forwards = false;
          skip_count = 0;
        }
      }
    }
    else {
      if (offset == 0) {
        forwards = true;
        i++;
        offset = 0;
        // if (i >= len) {
        //   i = 0;
        // }
      }
    }
    part = words[i].substr(0, offset);
    if (skip_count == 0) {
      if (forwards) {
        offset++;
      }
      else {
        offset--;
      }
    }
    $('.word').text(part);
  },speed);
};

$(document).ready(function () {
  wordflick();
  
});


</script>
</body>
</html>
