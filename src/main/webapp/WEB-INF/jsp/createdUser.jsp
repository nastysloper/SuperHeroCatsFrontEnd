<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Created User</title>
</head>
<body>
<h2>Submitted Cat Information</h2>
<table>
    <tr>
        <td>Name</td>
        <td>${user.getName}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${user.getEmail}</td>
    </tr>
    <tr>
        <td>ID</td>
        <td>${user.getId}</td>
    </tr>
    <tr>
        <td>image</td>
        <td>${user.getImage}</td>
    </tr>

</table>
</body>
</html>
