<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" type="text/css" />	 
		<title></title>
	</head>
	
	<body>
		<table border="1" cellpadding="2" cellspacing="2" align="center">
		    <tr>
		        <td height="30" colspan="2">
		        	<tiles:insertAttribute name="header" />
		        </td>
		    </tr>
		    <tr>
		        <td height="250" width="20%"><tiles:insertAttribute name="menu" /></td>
		        <td><tiles:insertAttribute name="body" /></td>
		    </tr>
		    <tr>
		        <td height="30" colspan="2"><tiles:insertAttribute name="footer" />
		        </td>
		    </tr>
		</table>
	</body>
	
</html>