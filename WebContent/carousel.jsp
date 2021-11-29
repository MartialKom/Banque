<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Carousel</title>
  <link rel="stylesheet" href="css1/bootstrap.min.css">
  <script  src="css1/jquery.min.js"></script>
   <script  src="css1/bootstrap.min.js"></script>
   <style type="text/css">
    /* body{
    width:200%;
    margin:none;
    min-width:600px;
    max-width:2000px;
    } */
   </style>
</head>
<body>
  <%
  String resultat = (String) request.getAttribute("conn");

if(resultat!=null){
  out.println("<script type='text/javascript'>");
    out.println("confirm('"+resultat+"');");
    out.println("</script>");
}

%>
<div class="container">
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img style=" height: 720px; border: none; border-radius: 20px;" alt="Second slide" src="images/nouv2.jpg">
        <div class="carousel-caption">
              <h3>SECURITE FINANCIERE</h3>
            </div>
      </div>
      <div class="item">
        <img style=" height:720px; weight: 800px; border: none; border-radius: 20px;" alt="Third slide" src="images/nouv11.jpg">
        <div class="carousel-caption">
              <h3>SECURITE FINANCIERE</h3>
            </div>  
      </div>
    </div>
    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
  </div>

</div>
<script src="js/jquery.min.js"></script>
<script src="js/transition.js"></script>
<script src="js/carousel.js"></script>

</body>
</html>
