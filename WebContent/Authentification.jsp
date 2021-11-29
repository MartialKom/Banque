<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager" import="java.sql.Connection" import="java.sql.SQLException" import="java.sql.Statement" import="com.mysql.jdbc.PreparedStatement"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link href="css/globale.css" rel="stylesheet" type="text/css" >
	<script src="jquery/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<style type="text/css">
	.erreur{
	background: red;
	}
	 #bas{
	height: 10px;
	border-left: none;
	margin-top: 150px;
}
 body{
    width:100%;
    margin:auto;
    min-width:600px;
    max-width:2000px;
    }
#bas{
	font-size: 5px;
}
	</style>
	<script>
	function valider () { 
	var form_inscription = document.getElementById("form");
	var champ_solde=form_inscription.elements["solde"];
	
	var form_ok="true";
	
	if(isNaN(champ_solde.value)){
		form_ok = false;
		champ_solde.classList.add("erreur");
		alert("Le solde est incorrect");
		return false;
	}
	
	if(!form_ok){
		event.preventDefault();
		return false;
	}
	
	}
	form_inscription.addEventListener("submit", valider, false);
	</script>
	
	<!-- <script src="js/popper.js"></script> -->
</head>
<body>
     <div class="container-fluid bg">
     	<div class="row">
     		<!-- <button class="btn btn-primary btn-sm" data-target="#loginmodal" data-toggle="modal">login</button> -->
     			<div class="modal fade" data-keyboard="false"  id="loginmodal" tabindex="-1" >
     				<div class="modal-dialog">
     					<div class="modal-content">
     						<div class="modal-header">
     							<button class="close" data-dismiss="modal">&times;</button>
     							<h4 class="modal-title">Remplissez ce formulaire pour l'inscription</h4>
     						</div>
     						<div class="modal-body">
     						</div>
     						
     					</div>
     				</div>
     			</div>
     		<%
       		String resultat = (String) request.getAttribute("conn");
     		
     		
     		
     		
     		if(resultat!=null){
     			out.println("<script type='text/javascript'>");
         		out.println("confirm('"+resultat+"');");
         		out.println("</script>");
     		}
     		
     		%>
     		
     		
     		
     	

     		<div class="col-md-4 col-sm-4 col-xs-12"></div>
		    <div class="col-md'4 col-sm-4 col-xs-12">
		    	
		     <fieldset class="form-region" >
		     	<form action="monlien" method="post">
		     		<h2><img src="images/user1.png" class="image"></h2>
		     		
		     	
	     	<div class="form-group">
		     		<label for="exampleInputEmail1">Nom d'Utilisateur</label>
		     		<input type="text" class="form-control" id="exampleInputName1" placeholder="User Name" name="UserN2" required>
		     	</div>
		     	<div class="form-group">
		     		<label for="exampleInputPassword1">Mot de Passe</label>
		     		<input type="Password" class="form-control" id="exampleInputPassword2" placeholder="Password" name="pass2" required>
		     	</div>
		     	<div class="checkbox">
		     		<label>
		     			<input type="checkbox"> Remember
		     		</label>
		     	</div>
		     	<button type="submit" class="btn btn-primary btn-block bt"> Connexion</button><br>
		     </form>
            </fieldset>
		    </div>
     		</div>
     		<footer id="bas">
			<h6>Copyright <b>MoK-Dev</b> 2021.<b> +237 698-64-69-34</b> </h6>
			<h6>En vous enregistrant ou en utilisant cette application, vous acceptez notre contrat utilisateur.</h6>
	</footer>
     	</div>
     	
</body>
</html>