<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All HCC</title>
<style>
      table,
      th,
      td {
        padding: 10px;
        border: 1px solid black;
        border-collapse: collapse;
      }
</style>
</head>

<body>
</body>
<table border="1">
    <tr>
        <th>Index</th>
        <th>Code</th>
        <th>RAF</th>
        <th>Children</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${lists}" var="lists">
        <tr>
            <td>${lists.index}</td>
            <td>${lists.code}</td>
            <td>${lists.raf}</td>
            <td>${lists.children}</td>
            <td>${lists.description}</td>
        </tr>
    </c:forEach>
</table>
