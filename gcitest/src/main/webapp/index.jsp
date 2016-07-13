<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kramer POC Test Page</title>
        
        <script src="<%=request.getContextPath() %>/js/jquery-3.0.0.js"></script>
        <script>
            var ctxPath = "<%=request.getContextPath() %>";
            var contractJson = '{"contractId":"#SA-321", "expiring":"false", "amount":"33.00"}'; 
            var invoiceJson	= '{"invoiceId":"12345", "contractId":"#SA-333", "pastDue":"true"}';
            
            $(function(){
                $("#postServiceAgreementContract, #postInvoice").on("click", function(){
                    $.ajax({
                        url: $(this).attr("id") === "postServiceAgreementContract" ? 
                        		ctxPath+"/gcitestservice/contract/post" : ctxPath+"/gcitestservice/invoice/post",
                        type: "POST",
                        data: $(this).attr("id") === "postServiceAgreementContract" ? 
                        		contractJson : invoiceJson,
                        contentType: "application/json; charset=utf-8",
                        cache: false,
                        dataType: "text",
                        
                      	success: function(msg){
                      		alert( "Data saved: " + msg );
                      	},
                      	error: function(request, textStatus, errorThrown) {
                      	    alert("Error: " + errorThrown);
                      	}
                        
                        
                    }).fail(function(data, status) {
                        //alert(status);
                        alert(JSON.stringify(data));
                    });
                });                
            });
        </script>
                
    </head>
 
    <body>
       <h1>Kramer REST Jackson/Jersey Test Page</h1>
       <ul>
       	   <!-- 
           <li><a href="<%=request.getContextPath() %>/gcitestservice/contract/ping"><%=request.getContextPath() %>/gcitestservice/contract/ping</a></li>
            -->
           <li><a href="<%=request.getContextPath() %>/gcitestservice/contract/get/%23SA-999"><%=request.getContextPath() %>/gcitestservice/contract/get/#SA-999</a></li>
           <li><a href="<%=request.getContextPath() %>/gcitestservice/contract/get/%23SA-000"><%=request.getContextPath() %>/gcitestservice/contract/get/#SA-000</a></li>
		   <!-- 
           <li><a href="<%=request.getContextPath() %>/gcitestservice/invoice/ping"><%=request.getContextPath() %>/gcitestservice/invoice/ping</a></li>
            -->
           <li><a href="<%=request.getContextPath() %>/gcitestservice/invoice/get"><%=request.getContextPath() %>/gcitestservice/invoice/get</a></li>

           <li><button id="postServiceAgreementContract">Post SA Contract</button></li>
           <li><button id="postInvoice">Post Invoice</button></li> 
       </ul>
           
    </body>
    
</html>