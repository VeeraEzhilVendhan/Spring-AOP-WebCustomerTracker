<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Customer</title>

<link type="text/css" rel="stylesheet"  
href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />


</head>
<body>

<div id="wrapper">
  <div id="header">
     <h2>CRM - Customer Relationship Manager</h2>
  </div>
</div>

<div id="container">
   <h3>Save Customer</h3>
   <form:form action="savecustomer" method="POST" modelAttribute="customer">
       <table>
        <form:input path="id" type="hidden"/>
         <tbody>
            <tr>
              <td><label>First Name :</label></td>
              <td><form:input path="firstName" id="selectFN"/></td>          
            </tr>
             <tr>
              <td><label>Last Name :</label></td>
              <td><form:input path="lastName" id="selectLN"/></td>
            </tr>
             <tr>
              <td><label>Email :</label></td>
              <td><form:input path="email" id="selectE" /></td>
            </tr>
            <tr>
              <td><input type="submit" value="Save" class="save"/></td>
            </tr>
         </tbody>
       </table>
   </form:form>
   <div style="clear; both;"></div>
   <p>
     <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
   </p>
   
</div>

</body>
</html>