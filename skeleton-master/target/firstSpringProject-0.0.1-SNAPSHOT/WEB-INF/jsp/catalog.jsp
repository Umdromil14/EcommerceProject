<%@ include file="include/importTags.jsp"%>
<div>
  <c:if test="${basketFull}">
    <p class="text-danger text-center">
      <spring:message code="basketFullMessage"/>
    </p>
  </c:if>
  <h2 class="d-flex justify-content-center">${categoryTitle}</h2>
  <div class="row row-cols-1 row-cols-md-3 g-4">
    <c:forEach items="${products}" var="article">
      <div class="col">
        <div class="card">
          <img src="<spring:url value="/images/Articles/${article.ID}.png "/>" class="mt-5 rounded mx-auto d-block" style="width: 50%; height: 50%; object-fit: cover" alt=${article.name}>
          <div class="card-body">

            <h5 class="card-title">${article.name}</h5>
            <p class="card-text">

              price : ${article.price} <spring:message code="currency"/>
              <a href="<spring:url value="/article/${article.ID}"/>">
                <spring:message code="detailsButton"/>
              </a>
            </p>
            <span>
              <form:form action="/skeleton-master/catalog/${category}/add/${article.ID}" modelAttribute="quantityPurchased" method="POST">
                <form:label path="quantity"><spring:message code="quantityLabel"/></form:label>
                <form:input path="quantity" min="1" max="${max}" value="1" type="number" disabled="${basketFull}"/>
                <form:button disabled="${basketFull}"><spring:message code="addToBasketButton"/></form:button>
              </form:form>
            </span>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
