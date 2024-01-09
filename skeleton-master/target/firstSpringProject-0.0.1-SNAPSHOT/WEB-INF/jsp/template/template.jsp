<%@ include file="../include/importTags.jsp" %>
<html>
    <head>
        <title>Produx</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <spring:url var="localeEN" value="">
            <spring:param name="locale" value="en"/>
        </spring:url>
        <spring:url var="localeNL" value="">
            <spring:param name="locale" value="nl"/>
        </spring:url>
        <spring:url var="localeDE" value="">
            <spring:param name="locale" value="de"/>
        </spring:url>
    </head>
    <body>
        <div class="container">
            <div class="row">
    <nav class="navbar fixed-top navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <img alt="logo" src='<spring:url value="/images/produx.png"/> ' height="40" width="40"/>
            <a class="navbar-brand" href="<spring:url value="/home"/>">
                Produx
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="navbar-brand" aria-current="page" href="<spring:url value="/home"/>">
                            <spring:message code="Home"/>
                        </a>
                    </li>

                    <c:if test="${not empty categories}">
                    <li class="nav-item dropdown">
                        <a class="navbar-brand dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <spring:message code="Categories"/>
                        </a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${categories}" var="category">
                            <li class="nav-item">
                                <a class="dropdown-item" href="<spring:url value ="/catalog/${category.category}"/>">
                                        ${category.label}
                                </a>
                            </li>
                            </c:forEach>
                        </ul>
                    </li>
                    </c:if>
                </ul>
                <sec:authorize access="isAuthenticated()">
                    <a class="navbar-brand" href="<spring:url value="/authenticated"/>">
                        <img alt="profile" src='<spring:url value="/images/profil.png"/>' height="30" width="30"/>
                            ${pageContext.request.userPrincipal.name}
                    </a>

                    <a class="navbar-brand" href="<spring:url value="/logout"/>">
                        <spring:message code="Logout"/>
                    </a>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <a class="navbar-brand" href="<spring:url value="/login"/>">
                        <spring:message code="Login"/>
                    </a>
                    <a class="navbar-brand" href="<spring:url value="/signup"/>">
                        <spring:message code="Register"/>
                    </a>
                </sec:authorize>
                <a class="navbar-brand" href="<spring:url value="/basket"/>">
                    <img alt="cart" src='<spring:url value="/images/cart.png"/> ' height="40" width="40"/>
                </a>
            </div>

        </div>
    </nav>
            </div>
            <div style="padding-top: 56px; padding-bottom: 56px">
                <tiles:insertAttribute name="main-content"/>
            </div>

        </div>
    </body>
    <footer>
        <nav class="navbar fixed-bottom navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" aria-current="page" href="<spring:url value="/about"/>">
                    <spring:message code="About"/>
                </a>
                <div class="justify-content-end" >
                    <a class="navbar-brand" href="${localeEN}">
                        <img alt="en" src='<spring:url value="/images/localeEN.png"/>' height="30" width="30"/>
                    </a>
                    <a class="navbar-brand" href="${localeNL}">
                        <img alt="nl" src='<spring:url value="/images/localeNL.png"/>' height="30" width="30"/>
                    </a>
                    <a class="navbar-brand" href="${localeDE}">
                        <img alt="de" src='<spring:url value="/images/localeDE.png"/>' height="30" width="30"/>
                    </a>
                </div>
            </div>
        </nav>
    </footer>
</html>