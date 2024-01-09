<%@ include file="include/importTags.jsp"%>
<body>
    <form:form
        id="form"
        method="POST"
        action="/skeleton-master/authenticated/send"
        modelAttribute="user"
    >
        <div class="form-group">
            <div class="mb-3 row">
                <label for="username" class="col-sm-2 col-form-label"><spring:message code="usernameLabel"/></label>
                <div class="col-sm-10">
                    <form:input path="username"/>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="lastname" class="col-sm-2 col-form-label"><spring:message code="lastnameLabel"/></label>
                <div class="col-sm-10">
                    <form:input path="lastname"/>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="firstname" class="col-sm-2 col-form-label"><spring:message code="firstnameLabel"/></label>
                <div class="col-sm-10">
                    <form:input path="firstname"/>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="address" class="col-sm-2 col-form-label"><spring:message code="addressLabel"/></label>
                <div class="col-sm-10">
                    <form:input path="address"/>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="email" class="col-sm-2 col-form-label"><spring:message code="emailLabel"/></label>
                <div class="col-sm-10">
                    <form:input path="email"/>
                </div>
            </div>
        </div>

        <form:button><spring:message code="confirmChange"/></form:button>
    </form:form>
    <form class="row g-3">
        <div class="col-md-6">
            <label for="inputEmail4" class="form-label">Email</label>
            <input type="email" class="form-control" id="inputEmail4">
        </div>
        <div class="col-md-6">
            <label for="inputPassword4" class="form-label">Password</label>
            <input type="password" class="form-control" id="inputPassword4">
        </div>
        <div class="col-12">
            <label for="inputAddress" class="form-label">Address</label>
            <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
        </div>
        <div class="col-12">
            <label for="inputAddress2" class="form-label">Address 2</label>
            <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
        </div>
        <div class="col-md-6">
            <label for="inputCity" class="form-label">City</label>
            <input type="text" class="form-control" id="inputCity">
        </div>
        <div class="col-md-4">
            <label for="inputState" class="form-label">State</label>
            <select id="inputState" class="form-select">
                <option selected>Choose...</option>
                <option>...</option>
            </select>
        </div>
        <div class="col-md-2">
            <label for="inputZip" class="form-label">Zip</label>
            <input type="text" class="form-control" id="inputZip">
        </div>
        <div class="col-12">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck">
                <label class="form-check-label" for="gridCheck">
                    Check me out
                </label>
            </div>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Sign in</button>
        </div>
    </form>
</body>


