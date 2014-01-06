<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head></head>
<body>
   <h1>Please Login</h1>
   <c:if test="${'fail' eq param.auth}">
        <div style="color:red">
                Login Failed!!!<br />
                Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
         </div>
    </c:if>
    <c:if test="${'logout' eq param.auth}">
        <div style="color:red">
                You are logged out.
         </div>
    </c:if>
   <form name='f' action="j_spring_security_check" method='POST'>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='j_username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="Submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html>