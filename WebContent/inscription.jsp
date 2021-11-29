<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	 body{
    width:100%;
    margin:auto;
    min-width:600px;
    max-width:2000px;
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
     							<form action="Testservlet"  id="form" onsubmit="valider(submit)" method="post" >
     							  <div class="form-group">
     							  	<label>Nom</label>
     							  	<input type="text" class="form-control" id="exempleIputName" name="nom" placeholder="Votre Nom" required>
     							  </div>
     							   <div class="form-group">
     							  	<label>Prenom</label>
     							  	<input type="text" class="form-control" id="exempleIputLasName" name="prenom" placeholder="Votre Prenom" required>
     							  </div>
     							  <div class="form-group">
		     		                  <label for="exampleInputEmail1">Adresse Electronique</label>
		     		                  <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Email" required>
		     	                  </div>
		     	                   <div class="form-group">
     							  	<label>Nom Utilisateur</label>
     							  	<input type="text" class="form-control" id="exempleIputName" name="user" placeholder="User Name" required>
     							  </div>
		     	                  <div class="form-group">
		     		                  <label for="exampleInputPassword1">Mot de Passe</label>
		     		                  <input type="Password" class="form-control" id="exampleInputPassword1" name="Pass" placeholder="Password" required>
		     	                  </div>
		     	                  <div class="form-group">
		     	                  <table> 
		     	                  <tr>
		     	                  	<td><label>Type de Compte: </label></td>
		     	                  	<td>
		     	                  	<select name="a">
		     	                  <option>	Compte Cheque </option>
		     	                  <option>  Compte Epargne</option>
		     	                  	</select>
		     	                  	</td>
		     	                  	</tr>
		     	                  	</table>
		     	                  </div>
		     	                  <div class="form-group">
		     	                  	<label>Solde de départ</label>
		     	                  	<input type="number" name="solde" class="form-control" placeholder="MIN 25.000(FCFA)" min="25000" required>
		     	                  </div>
                                  <div class="modal-footer">
     							     <input type="submit" value="Inscrire" class="btn btn-primary">
     							     <button class="btn btn-primary" data-dismiss="modal">Close</button>
     						</div>
     							</form>
     						</div>
     						
     					</div>
     				</div>
     			</div>
		    	
		   
		    </div>
		      <fieldset class="form-region" >
		     	<button class="btn btn-primary btn-block bt" data-target="#loginmodal" data-toggle="modal" >S'inscrire</button>
               
            </fieldset>
     		</div>
     		
</body>
</html>