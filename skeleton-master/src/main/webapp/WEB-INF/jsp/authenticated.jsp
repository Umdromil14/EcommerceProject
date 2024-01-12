<%@ include file="include/importTags.jsp"%>
<div class="container mt-5 py-5">
    <div class="row">
        <div class="col-12 col-sm-8 col-md-6 m-auto">
            <c:if test="${usernameExists}">
                <p class="text-danger text-center">
                    <spring:message code="usernameExistsMessage"/>
                </p>
            </c:if>
            <div class="card border-0 shadow">
                <div class="card-body">
                    <form:form
                            id="form"
                            method="POST"
                            action="/produx/authenticated"
                            modelAttribute="user"
                    >
                        <h1 class="fw-bold text-center">
                            <spring:message code="modifyTitle"/>
                        </h1>
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
                        <p class="text-danger">
                            *<spring:message code="required"/>
                        </p>
                        <div class="text-center">
                            <form:button class="btn btn-primary m-2">
                                <spring:message code="confirmChange"/>
                            </form:button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


