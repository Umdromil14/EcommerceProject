<%@include file="include/importTags.jsp"%>

<c:choose>
    <c:when test="${!purchases.isEmpty() && purchases != null}">
        <div class="container mt-5 py-5">
            <c:if test="${basketFull}">
                <p class="text-danger text-center">
                    <spring:message code="basketFullMessage"/>
                </p>
            </c:if>
            <div class="row">
                <div class="col-12 col-sm-8 col-md-6 m-auto text-center">
                    <div class="card border-0 shadow">
                        <c:forEach items="${purchases}" var="purchase">
                            <div class="row g-0 p-5">
                                <div class="col-md-4">
                                    <img src="<spring:url value="/images/Articles/${purchase.key.getID()}.png"/>" class="img-fluid rounded-start mx-auto" alt="${purchase.key.getName()}">
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">${purchase.key.getName()}</h5>
                                        <p class="card-text">
                                            <spring:message code="actualPrice"/> : ${purchase.key.getPrice()} <spring:message code="currency"/>
                                            <br/>
                                            <spring:message code="quantityLabel"/>
                                                ${purchase.value}
                                            <br/>
                                            <spring:message code="totalPrice"/> : ${purchase.key.getPrice() * purchase.value} <spring:message code="currency"/>
                                        </p>
                                    </div>
                                    <form:form modelAttribute="updateArticle" action="/skeleton-master/basket/update/${purchase.key.getID()}" method="POST">
                                        <form:input path="quantity" type="number" min="0" max="${purchase.value + max}" value="${purchase.value}" />
                                        <form:button><spring:message code="updateDeletePrice"/></form:button>
                                    </form:form>
                                </div>
                            </div>
                        </c:forEach>
                        <form:form modelAttribute="voucher" action="/skeleton-master/basket/addVoucher" method="POST">
                            <spring:message code="voucherCode" var="voucherPlaceHolder" />
                            <form:input path="code" type="text" placeholder='${voucherPlaceHolder}'/>
                            <form:errors path="code" cssClass="error" />
                            <form:button><spring:message code="addVoucher"/></form:button>
                        </form:form>
                        <p>
                            <spring:message code="totalPrice"/> <spring:message code="withoutVoucher"/> : ${totalPaymentWithoutVoucher}<spring:message code="currency"/>
                        </p>
                        <c:if test="${totalPayment != null}">
                            <p>
                                <spring:message code="totalPrice"/> <spring:message code="withVoucher"/> : ${totalPayment}<spring:message code="currency"/>
                            </p>
                        </c:if>
                        <c:if test="${wentIn}">
                            <p class="text-danger">
                                <spring:message code="voucherError"/>
                            </p>
                        </c:if>
                        <sec:authorize access="isAuthenticated()">
                            <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" class="row row-cols-auto justify-content-center">
                                <input type="hidden" name="business" value="sb-agcwp29047458@personal.example.com"/>
                                <input type="hidden" name="cert_id" value="AVc3JNvcoWnHwb8cQwIPM2dFVlHlDo-45KGGraody20-lV5ZRuoL-8BHBDx-Qcv7bpLaU_3CHnZWIQ-y"/>
                                <input type="hidden" name="cmd" value="_xclick"/>
                                <input type="hidden" name="amount" value="${totalPayment !=null ? totalPayment : totalPaymentWithoutVoucher}"/>
                                <input type="hidden" name="currency_code" value="EUR"/>
                                <input type="hidden" name="return" value="http://localhost:8082/skeleton-master/basket/success"/>
                                <input type="hidden" name="cancel_return" value="http://localhost:8082/skeleton-master/basket/failure"/>
                                <input type="image" name="submit" border="0" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif" alt="gif"/>
                            </form>
                        </sec:authorize>
                        <sec:authorize access="!isAuthenticated()">
                            <a class="navbar-brand" href="<spring:url value="/login"/>">
                                <spring:message code="Login"/>
                            </a>
                            <a class="navbar-brand pb-5" href="<spring:url value="/signup"/>">
                                <spring:message code="Register"/>
                            </a>
                        </sec:authorize>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="d-flex justify-content-center align-items-center" style="height: 80%">
            <h1 class="text-center">
                <spring:message code="basketEmpty"/>
            </h1>
        </div>
    </c:otherwise>
</c:choose>
