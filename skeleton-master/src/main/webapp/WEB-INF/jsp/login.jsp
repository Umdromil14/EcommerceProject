<%@ include file="include/importTags.jsp"%>

<div class="container mt-5" style="padding-top: 56px">
    <div class="row">
        <div class="col-12 col-sm-8 col-md-6 m-auto text-center">
            <c:if test="${param.error != null}">
                <p class="text-danger">
                    <spring:message code="loginFailedMessage"/>
                </p>
            </c:if>
            <div class="card border-0 shadow">
                <div class="card-body">
                    <form:form method="POST" modelAttribute="userDetails">
                        <h1 class="fw-bold">
                            <spring:message code="signIn"/>
                        </h1>
                        <spring:message code="usernameLabel" var="usernamePlaceholder" />
                        <form:input path="username" placeholder='${usernamePlaceholder}' cssClass="form-control my-3 py-2" />

                        <spring:message code="passwordLabel" var="passwordPlaceholder" />
                        <form:password path="password" placeholder='${passwordPlaceholder}' cssClass="form-control my-3 py-2"/>

                        <form:button class="btn btn-primary m-2">
                            <spring:message code="signIn"/>
                        </form:button>
                        <a href="<spring:url value="/signup"/>" class="nav-link">
                            <spring:message code="signInHref"/>
                        </a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

