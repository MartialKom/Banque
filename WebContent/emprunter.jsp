<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link href="css/globale.css" rel="stylesheet" type="text/css" >
	<script src="jquery/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- <script src="js/popper.js"></script> -->
	<!-- controle du formulaire -->
	<style>
		
		.center {
			position: absolute;
			top:50%;
			left: 50%;
			transform: translate(-50%,-50%);
		}
		body{
			background:#ddd;
			font-family: "Raleway";
		}
		 body{
    width:100%;
    margin:auto;
    min-width:600px;
    max-width:2000px;
    }
	</style>

<meta charset="ISO-8859-1">
<title>Crediter</title>
</head>
<body>

 <%
       String numero = (String) request.getParameter("param");
 String nom=(String) request.getParameter("param2");
 

  
        %>
	<div class="row">
     		<!-- <button class="btn btn-primary btn-sm" data-target="#loginmodal" data-toggle="modal">login</button> -->
     			<div class="modal fade" data-keyboard="false"  id="loginmodal" tabindex="-1" >
     				<div class="modal-dialog">
     					<div class="modal-content">
     						<div class="modal-header">
     							<button class="close" data-dismiss="modal">&times;</button>
     							<h4 class="modal-title">Remplissez ce formulaire pour l'emprunt</h4>
     						</div>
     						<div class="modal-body">
     							<form id="myform"  action="Client"  id="form" method="post" >
		     	                   <div class="form-group">
     							  	<label>Nom Utilisateur</label>
     							  	<input type="text" class="form-control" id="userName" name="nomE" value='<%=nom %>' readonly="readonly" >
     							  </div>

		     	                  <div class="form-group">

		     	                  	<label>N° du Compte: </label>
		     	         			<input type="number" class="form-control" name="numeroCompteE"  value='<%=numero %>' readonly="readonly" >
		     	                  </div>
		     	                  <div class="form-group">
		     	                  	<label>Montant de l'emprunt</label>
		     	                  	<input type="number" name="montantE" class="form-control" placeholder="MIN 15.000(FCFA)" required min="15000"  required max="200000"/>
		     	                  </div>
                                  <div class="modal-footer">
     							     <input type="submit" value="Créditer" class="btn btn-primary">
     							     <span id="msg"></span>
     							     <button class="btn btn-primary" data-dismiss="modal">Close</button>
     						</div>
     							</form>
     						</div>
     						
     					</div>
     				</div>
     			</div>
     		

		    
		    	<div class="center">
		     	<button class="btn btn-primary btn-block bt" data-target="#loginmodal" data-toggle="modal">Valider l'emprunt</button>
		     	</div>
		    
     	</div>

</body>
</html>