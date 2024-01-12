<%@ include file="include/importTags.jsp"%>

<div style="text-align: center">
    <div class="container pt-3">
        <h1>
            <spring:message code="About" />
        </h1>
        <p>
            <spring:message code="AboutUsTexte" />
        </p>
    </div>
    <h2 style="text-align:center">
        <spring:message code="OurTeam" />
    </h2>
    <div class="row" style="text-align: center">
        <div class="column">
            <div class="card mb-5">
                <img src="<spring:url value="/images/CEO.jpg"/>" alt="Jean" class="mx-auto" style="width:50%">
                <div class="container">
                    <h2>Jean Vascript</h2>
                    <p class="title" style="text-decoration: underline">
                        <spring:message code="CEOAndFounder" />
                    </p>
                    <p>
                        <spring:message code="CEODescription" />
                    </p>
                    <p style="font-weight: bold">Jean.Vascript@produx.com</p>
                </div>
            </div>
        </div>

        <div class="column">
            <div class="card mb-5">
                <img src="<spring:url value="/images/GRH.jpg"/>" alt="Json" class="mx-auto" style="width:50%">
                <div class="container">
                    <h2>Json Travolta</h2>
                    <p class="title" style="text-decoration: underline">
                        <spring:message code="ArtDirector" />
                    </p>
                    <p>
                        <spring:message code="ArtDescription" />
                    </p>
                    <p style="font-weight: bold">JSON.travolta@produx.com</p>
                </div>
            </div>
        </div>

        <div class="column">
            <div class="card mb-5">
                <img src="<spring:url value="/images/Manager.jpg"/>" alt="Python" class="mx-auto" style="width:50%">
                <div class="container">
                    <h2>Python McSnaky</h2>
                    <p class="title" style="text-decoration: underline">
                        <spring:message code="WebDesigner" />
                    </p>
                    <p>
                        <spring:message code="WebDescription" />
                    </p>
                    <p style="font-weight: bold">Python.snake@produx.com</p>
                </div>
            </div>
        </div>
        <div class="column">
            <div class="card mb-5">
                <img src="<spring:url value="/images/Jabba.jpg"/>" alt="Java the hutt" class="mx-auto" style="width:50%">
                <div class="container">
                    <h2>Java The Hutt</h2>
                    <p class="title" style="text-decoration: underline">
                        <spring:message code="Programmer" />
                    </p>
                    <p>
                        <spring:message code="ProgrammerDescription" />
                    </p>
                    <p style="font-weight: bold">JavaTheHutt@produx.galaxy</p>
                </div>
            </div>
        </div>
    </div>
</div>