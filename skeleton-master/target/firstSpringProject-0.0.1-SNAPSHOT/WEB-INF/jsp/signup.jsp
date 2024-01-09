<%@ include file="include/importTags.jsp"%>

<div class="container mt-5 py-5">
    <div class="row">
        <div class="col-12 col-sm-8 col-md-6 m-auto">
            <c:if test="${usernameExists}">
                <p class="text-danger text-center">
                    <spring:message code="usernameExistsMessage"/>
                </p>
            </c:if>
            <c:if test="${passwordNotRepeats}">
                <p class="text-danger text-center">
                    <spring:message code="passwordNotRepeatsMessage"/>
                </p>
            </c:if>
            <div class="card border-0 shadow">
                <div class="card-body">
                    <form:form id="userForm" method="POST" action="/skeleton-master/signup" modelAttribute="user">
                        <h1 class="fw-bold text-center">
                            <spring:message code="signUp"/>
                        </h1>
                        <spring:message code="usernameLabel" var="usernamePlaceholder" />
                        <form:label path="username">
                            ${usernamePlaceholder}<span class="text-danger">*</span>
                        </form:label>
                        <form:input path="username" placeholder='${usernamePlaceholder}' cssClass="form-control my-3 py-2" />
                        <form:errors path="username" cssClass="text-danger"/>
                        <br/>
                        <spring:message code="emailLabel" var="emailPlaceholder" />
                        <form:label path="email">
                            ${emailPlaceholder}<span class="text-danger">*</span>
                        </form:label>
                        <form:input path="email" placeholder='${emailPlaceholder}' cssClass="form-control my-3 py-2" />
                        <form:errors path="email" cssClass="text-danger"/>
                        <br/>
                        <spring:message code="firstnameLabel" var="firstnamePlaceholder" />
                        <form:label path="firstname">
                            ${firstnamePlaceholder}
                        </form:label>
                        <form:input path="firstname" placeholder='${firstnamePlaceholder}' cssClass="form-control my-3 py-2" />
                        <form:errors path="firstname" cssClass="text-danger"/>
                        <br/>
                        <spring:message code="lastnameLabel" var="lastnamePlaceholder" />
                        <form:label path="lastname">
                            ${lastnamePlaceholder}
                        </form:label>
                        <form:input path="lastname" placeholder='${lastnamePlaceholder}' cssClass="form-control my-3 py-2" />
                        <form:errors path="lastname" cssClass="text-danger"/>
                        <br/>
                        <spring:message code="addressLabel" var="addressPlaceholder" />
                        <form:label path="address">
                            ${addressPlaceholder}<span class="text-danger">*</span>
                        </form:label>
                        <form:input path="address" placeholder='${addressPlaceholder}' cssClass="form-control my-3 py-2" />
                        <form:errors path="address" cssClass="text-danger"/>
                        <br/>
                        <spring:message code="phoneNumberLabel" var="phoneNumberPlaceholder" />
                        <form:label path="phoneNumber">
                            ${phoneNumberPlaceholder}<span class="text-danger">*</span>
                        </form:label>
                        <form:input path="phoneNumber" placeholder='${phoneNumberPlaceholder}' cssClass="form-control my-3 py-2" />
                        <form:errors path="phoneNumber" cssClass="text-danger"/>
                        <br/>
                        <spring:message code="passwordLabel" var="passwordPlaceholder" />
                        <form:label path="password">
                            ${passwordPlaceholder}<span class="text-danger">*</span>
                        </form:label>
                        <form:password path="password" placeholder='${passwordPlaceholder}' cssClass="form-control my-3 py-2" />
                        <form:errors path="password" cssClass="text-danger"/>
                        <spring:message code="passwordLabel" var="passwordPlaceholder" />
                        <br/>
                        <spring:message code="confirmPasswordLabel" var="confirmPasswordPlaceholder" />
                        <form:label path="confirmPassword">
                            ${confirmPasswordPlaceholder}<span class="text-danger">*</span>
                        </form:label>
                        <form:password path="confirmPassword" placeholder='${confirmPasswordPlaceholder}' cssClass="form-control my-3 py-2" />
                        <form:errors path="confirmPassword" cssClass="text-danger"/>
                        <p class="text-danger">
                            *<spring:message code="required"/>
                        </p>
                        <div class="text-center">
                            <form:button class="btn btn-primary m-2">
                                <spring:message code="signUp"/>
                            </form:button>
                        </div>
                        <a href="<spring:url value="/login"/>" class="nav-link text-center">
                            <spring:message code="signUpHref"/>
                        </a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>