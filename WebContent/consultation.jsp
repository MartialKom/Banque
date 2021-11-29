<%@page import="com.octest.servlets.Testservlet" import="com.octest.forms.Client" import="com.octest.forms.Consultation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Consultation</title>
	
   
      <link href="css1/bootstrap.min.css" rel="stylesheet">
      <link rel="stylesheet" type="text/css" href="css1/datatable.css">
      <script type="text/javascript" src="css1/Jquery.js" ></script>
      <script type="text/javascript" src="css1/datatable.js" ></script>
      <link href="css1/font-awesome.min.css" rel="stylesheet">
</head>
<body>

<%
Testservlet.clients.clear();
Testservlet.comptes.clear();
Consultation con = new Consultation();
con.insertion();
%>

			<div class="modal fade" data-keyboard="false"  id="modif" tabindex="-1">
     				<div class="modal-dialog">
     					<div class="modal-content">
     						<div class="modal-header">
     							<button class="close" data-dismiss="modal">&times;</button>
     							<h4 class="modal-title">Modifier le nom d'utilisateur</h4>
     						</div>
     						<div class="modal-body">
     							<form id="myform"  action="Servlet2"  id="form" onsubmit="valider(submit)" method="post" >
		     	                   <div class="form-group">
     							  	<label>Nouveau nom d'utilisateur</label>
     							  	<input type="text" class="form-control" id="userName" name="user1" placeholder="User name" required>
     							  </div>
		     	                  <div class="form-group">
		     		                  <label for="exampleInputPassword1">password</label>
		     		                  <input type="Password" class="form-control" id="exampleInputPassword1" name="Pass1" placeholder="Password" required>
		     		                  <span id="erreur"></span>
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
     			
<%
       		String resultat = (String) request.getAttribute("conn");
     		
     		if(resultat!=null){
     			out.println("<script type='text/javascript'>");
         		out.println("alert('"+resultat+"');");
         		out.println("</script>");
     		}
     	

     		%>
      <div class="row">
        
        
        <div class="col-sm-12">
          <div class="panel panel-danger">
            <div class="panel-heading">
              <center><h3 class="panel-title"><i>LISTE CLIENTS</i></h3></center>
            </div>
            <div class="panel-body">

            		<table class="table table-bordered table-striped" id="tableau">
                  <thead>
                    <tr>
                      <th style="width: 20px;  text-align: center"><b> # </b></th>
                      <th style="width: 20px;  text-align: center"><b> Nom </b></th>
                      <th style="width: 20px;  text-align: center"><b>Prenom</b> </th>
                      <th style="width: 20px;  text-align: center"><b>Mail</b></th>
                      <th style="width: 20px;  text-align: center"> <b>Nom d'Utilisateur</b> </th>
                          <th style="width: 20px; text-align: center"><b> compte(s)</b></th>
                          <th style="width: 20px; text-align: center"><b> Action</b></th> 
                           <th style="width: 20px; text-align: center"><b> Action</b></th>              				
                    </tr>
                     </thead>
                     <tbody>
  
  <% 
  int i=1;
              for (com.octest.forms.Client client : Testservlet.clients){
              out.println("<tr>");
              out.println("<th>"+i+"</th>");
              out.println("<th>"+client.nom+"</th>");
              out.println("<th>"+client.prenom+"</th>");
              out.println("<th>"+client.mail+"</th>");
              out.println("<th>"+client.user+"</th>");
              out.println("<th>"+client.nbre_compte+"</th>");
              out.println("<th><a href='consultationCompte.jsp?param="+client.user+"'><button style='width:150px;border-radius:20px;'  class='btn btn-primary btn-block bt'>Voir le(s) compte(s)</button> </a>");
              out.println("<th><button style='width:200px;border-radius:20px;'  class='btn btn-primary btn-block bt' data-target='#modif' data-toggle='modal' >Modifier Nom d'Utilisateur</button></th>");
              out.println("</tr>");
              i++;
                      }
              %>

            			
            			</tbody>
  <script type="text/javascript">
    $(document).ready(function() {
      $('#tableau').DataTable();
    });
  </script>
 
            </div>
          </div>
          </div>
          

        </div>
      </div>
</body>
</html>