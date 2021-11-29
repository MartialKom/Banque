<%@page import="com.octest.servlets.Testservlet" import="com.octest.forms.Compte" import="java.text.DecimalFormat" import="java.text.DecimalFormatSymbols"%>
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

      <div class="row">
       
        
        <div class="col-sm-12">
          <div class="panel panel-danger">
            <div class="panel-heading">
              <center><h3 class="panel-title"><i>Compte(s) Epargne </i></h3></center>
            </div>
            <div class="panel-body">

            		<table class="table table-bordered table-striped" id="tableau">
                  <thead>
                    <tr>
                    
                      <th style="width: 10px; text-align: center"><b> Numero </b></th>
                      <th style="width: 20px; text-align: center"><b>Solde</b> </th>
                      <th style="width: 20px; text-align: center"> <b>Date création</b> </th>
                          <th style="width: 20px; text-align: center"><b> Nom d'Utilisateur</b></th>
                          <th style="width: 20px; text-align: center"><b> Action</b></th>      
                          <th style="width: 20px; text-align: center"><b> Action</b></th>        				
                    </tr>
                     </thead>
                     
                     <tbody>
  <% 
  DecimalFormat format = new DecimalFormat("###,###,###");
  DecimalFormatSymbols s = format.getDecimalFormatSymbols();
  s.setGroupingSeparator('.');
  format.setDecimalFormatSymbols(s);
 
              for (com.octest.forms.Compte compte : Testservlet.comptes){
            	  String type=compte.type;
               if(type.equals("Compte Epargne")){
              out.println("<tr>");
              out.println("<th>"+compte.numero+"</th>");
              out.println("<th>"+format.format(compte.solde)+" FCFA</th>");
              out.println("<th>"+compte.date+"</th>");
              out.println("<th>"+compte.nomU+"</th>");
              out.println("<th><a href='Crediter.jsp?param="+compte.numero+"&param2="+compte.nomU+"' target='zone1' ><button  style='border-radius:20px; width:100px;margin-left:50px;' class='btn btn-primary btn-block bt'>Crediter</button></a></th>");
              out.println("<th><a href='Debiter.jsp?param="+compte.numero+"&param2="+compte.nomU+"' target='zone1' ><button style='border-radius:20px; width:100px;margin-left:50px;' class='btn btn-primary btn-block bt'>Debiter</button></a>");
              out.println("</tr>");
              
                }
                
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
</body>
</html>