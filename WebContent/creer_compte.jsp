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
	</style>
	<script type="text/javascript">
		let myform = document.getElementById('myform');
		
		myform.addEventListener('submit',function(e){
          let myInput = document.getElementById('userName');
          if (myInput.value.trim() =="") {
          	let myErreur = document.getElementById("erreur");
          	myErreur.innerHTML ="le champ userName est requi";
          	myErreur.style.color="red";



             e.preventDefault();
          }  
		});
		
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
</head>
<body>
<%
       		String resultat = (String) request.getAttribute("conn");
			String p = (String) request.getParameter("param");
     		if(resultat!=null){
     			out.println("<script type='text/javascript'>");
         		out.println("alert('"+resultat+"');");
         		out.println("</script>");
     		}
     		
     		
     		%>
     
     	<div class="row">
     		<!-- <button class="btn btn-primary btn-sm" data-target="#loginmodal" data-toggle="modal">login</button> -->
     			<div class="modal fade" data-keyboard="false"  id="loginmodal" tabindex="-1" >
     				<div class="modal-dialog">
     					<div class="modal-content">
     						<div class="modal-header">
     							<button class="close" data-dismiss="modal">&times;</button>
     							<h4 class="modal-title">Remplissez ce formulaire pour la création du compte</h4>
     						</div>
     						<div class="modal-body">
     							<form id="myform"  action="Servlet2"  id="form" onsubmit="valider(submit)" method="post" >
		     	                   <div class="form-group">
     							  	<label>Nom Utilisateur</label>
     							  	<input type="text" class="form-control" id="userName" name="user1" placeholder="User name" required>
     							  </div>
		     	                  <div class="form-group">
		     		                  <label for="exampleInputPassword1">Password</label>
		     		                  <input type="Password" class="form-control" id="exampleInputPassword1" name="Pass1" placeholder="Password" required>
		     		                  <span id="erreur"></span>
		     	                  </div>
		     	                  <div class="form-group">
		     	                     <table> 
		     	                  <tr>
		     	                  	<td><label>Type de Compte: </label></td>
		     	                  	<td>
		     	                  	<select name="a1">
		     	                  <option>	Compte Cheque </option>
		     	                  <option>  Compte Epargne</option>
		     	                  	</select>
		     	                  	</td>
		     	                  	</tr>
		     	                  	</table>
		     	                  </div>
		     	                  <div class="form-group">
		     	                  	<label>Solde de départ</label>
		     	                  	<input type="number" name="solde1" class="form-control" placeholder="MIN 50.000(FCFA)" required min="25000" />
		     	                  </div>
                                  <div class="modal-footer">
     							     <input type="submit" value="Créer" class="btn btn-primary">
     							     <span id="msg"></span>
     							     <button class="btn btn-primary" data-dismiss="modal">Close</button>
     						</div>
     							</form>
     						</div>
     						
     					</div>
     				</div>
     			</div>
     		

		    
		    	<div class="center">
		     	<button class="btn btn-primary btn-block bt" data-target="#loginmodal" data-toggle="modal">Créer un Compte</button>
		     	</div>
		    
     	</div>
</body>
</html>