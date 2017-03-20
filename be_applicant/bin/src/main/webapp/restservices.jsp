<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>

<%
	request.setAttribute("timemilies", System.currentTimeMillis());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eHealth Restservices</title>
</head>
 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
 
<script type="text/javascript">
	
	function callJson(url, data, req_type) {
		$.ajax({
			  dataType: "json",
			  type:req_type,			  
			  url: url,
			  contentType: "application/json; charset=utf-8",
			  data: data,
			  success: function (data, statusText, xhr, data) {
				   alert("HTTP Status: " + xhr.status + " Data: "+ data);
			  }, 
			  error: function(xhr, status, text){
				  alert("HTTP Status: " + xhr.status + " - " + text + " - Reason: " );
			  }
			});
	}
	
</script>


<body>
	<h1>Restservices Overview</h1>


</body>
</html>