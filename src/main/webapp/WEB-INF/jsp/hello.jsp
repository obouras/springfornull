<%--
  Created by IntelliJ IDEA.
  User: obouras
  Date: 04/08/2014
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<head><title><fmt:message key="title"/></title></head>
<body>
<h1>Hello - Spring Application</h1>
<p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
<h3>Products</h3>
<c:forEach items="${model.products}" var="product">
    <c:out value="${product.description}: "/><i>dt<c:out value=" ${product.price}"/></i><br><br>
</c:forEach>
<br>
<a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
<br>
</body>
</html>
