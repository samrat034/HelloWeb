<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <c:forEach var="cat1" items="${cat}">
   ${cat1.id}<br>
     ${cat1.name}<br>
</c:forEach>

    

</body>
</html>
