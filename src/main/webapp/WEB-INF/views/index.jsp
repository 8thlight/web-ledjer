<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="iso-8859-1" content="text/html" http-equiv="Content-Type"/>
    <title>Web Ledjer</title>
    <link href="/resources/stylesheets/base.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Web Ledger</h1>

<div id="statement">
    <p>Your Statement</p>
    ${statement}
</div>
<form:form method="POST" action="/deposit" modelAttribute="deposit">
    <h3>Deposit</h3>
    <fieldset>
        <label for="deposit_amount">Date:</label>
        <form:input path="date" size="12" id="deposit_date"/>
        <label for="deposit_amount">Amount:</label>
        <form:input path="amount" size="5" id="deposit_amount"/>
        <input type="submit" value="Enter Deposit"/>
    </fieldset>
</form:form>
</body>
</html>