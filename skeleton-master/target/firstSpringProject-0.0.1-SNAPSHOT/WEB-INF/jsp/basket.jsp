<%@include file="include/importTags.jsp"%>

    <c:choose>
        <c:when test="${!purchases.isEmpty() && purchases != null}">
            <c:if test="${basketFull}">
                <p class="text-danger text-center">
                    <spring:message code="basketFullMessage"/>
                </p>
            </c:if>
            <div class="card bg-secondary mx-auto" style="width: 60%">
                <c:forEach items="${purchases}" var="purchase">
                <div class="card mb-3" style="max-width: 80%;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="<spring:url value="/images/Articles/${purchase.key.getID()}.png"/>" class="img-fluid rounded-start" alt="...">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${purchase.key.getName()}</h5>
                                <p class="card-text">
                                    Actual price per unit : ${purchase.key.getPrice()} <spring:message code="currency"/>
                                     <br/>
                                    <spring:message code="quantityLabel"/>
                                    ${purchase.value}
                                    <br/>
                                    total price : ${purchase.key.getPrice() * purchase.value} <spring:message code="currency"/>
                                </p>
                            </div>
                            <form:form modelAttribute="deleteArticle" name="delete" action="/skeleton-master/basket/delete/${purchase.key.getID()}" method="POST">
                                <form:input path="quantity" type="number" min="0" max="${purchase.value + max}" value="${purchase.value}" />
                                <form:button>Update/Delete this article</form:button>
                            </form:form>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
            <form:form modelAttribute="voucher" action="/skeleton-master/basket/addVoucher" method="POST" name="addVoucher">
                <form:input path="code" type="text" placeholder="Voucher code" />
                <form:errors path="code" cssClass="error" />
                <form:button>Add voucher</form:button>
            </form:form>
            <p>total price without voucher: ${totalPaymentWithoutVoucher}<spring:message code="currency"/></p>
            <c:if test="${totalPayment != null}">
                <p>total price with voucher: ${totalPayment}<spring:message code="currency"/></p>
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
                <a class="navbar-brand" href="<spring:url value="/signup"/>">
                    <spring:message code="Register"/>
                </a>
            </sec:authorize>
        </c:when>
        <c:otherwise>
            <Label>Basket empty</Label>
        </c:otherwise>
    </c:choose>
