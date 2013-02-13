<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>HEllo</h1>
<h2>${ledger.getClass()}</h2>


<form:form method="POST" action="/deposit" modelAttribute="deposit">
    <fieldset>
        <label for="deposit_amount">Amount</label>
        <form:input path="amount" size="5" id="deposit_amount"/>
        <input type="submit" value="Enter Deposit"/>
    </fieldset>
</form:form>

<form:form method="POST" action="pay" modelAttribute="payment">
    <fieldset>
        <label for="payment_amount">Amount</label>
        <form:input path="amount" size="5" id="payment_amount"/>
        <label for="payment_payee">Payee</label>
        <form:input path="payee" size="20" id="payment_payee"/>
        <input type="submit" value="Enter Payment"/>
    </fieldset>
</form:form>