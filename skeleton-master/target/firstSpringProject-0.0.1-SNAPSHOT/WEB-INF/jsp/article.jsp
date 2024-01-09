<%@ include file="include/importTags.jsp"%>

<div>
    <c:if test="${basketFull}">
        <p class="text-danger text-center">
            <spring:message code="basketFullMessage"/>
        </p>
    </c:if>
<h2 class="d-flex justify-content-center ">${product.name}</h2>
<div class="card mx-auto pt-2 " style="max-width: 650px;">
    <div class="row g-0 justify-content-center align-items-center h-100">
        <div class="col-md-4">
            <img src="<spring:url value="/images/Articles/${product.ID}.png "/>" class="img-fluid rounded-start" alt=${product.name}>
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <h5 class="card-title">${product.description}</h5>
                <p class="card-text"><small class="text-body-secondary">${product.price} <spring:message code="currency"/></small></p>
                <span>
              <form:form action="/skeleton-master/article/${id}/add" modelAttribute="quantityPurchased" method="POST">
                  <form:label path="quantity"><spring:message code="quantityLabel"/></form:label>
                  <form:input path="quantity" min="1" max="${max}" value="1" type="number" disabled="${basketFull}"/>
                  <form:button disabled="${basketFull}"><spring:message code="addToBasketButton"/></form:button>
              </form:form>
            </span>
            </div>
        </div>
    </div>
</div>
</div>
