
<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%--<c:url value="/static/js/index.js" var="index" />--%>
<%--<Script src="${index}"></Script>--%>

<script>
//    $(document).ready(function() {
//        $('.filterContainer').hide();
//    });
</script>

<br />
<div class="container">
    <div class="col-sm-12">
        <c2:choose>
            <c2:when test="${strudelResponse.hasArray[2] == 1}">
                <div>
                    <h2>${strudelResponse.strudelTarget.name} Astronomical Data:</h2>
                </div>
                <div>
                    <h2>Object Category</h2>
                    <p>${strudelResponse.strudelCategory.avmdesc}</p>
                </div>
                <div>
                    <h1>Right Ascension</h1>
                    <p>${strudelResponse.strudelRA.decimal}</p>

                    <h1>Declination</h1>
                    <p>${strudelResponse.strudelDec.decimal}</p>
                </div>
                <div>
                    <h1>Galactic Location</h1>
                    <p>Longitude: ${strudelResponse.strudelGalactic.lon}</p>
                    <p>Latitude: ${strudelResponse.strudelGalactic.lat}</p>
                </div>
                <div>
                    <h2>Links to Additional Data:</h2>
                    <p>${strudelResponse.strudelServOb.name}: <a href="${strudelResponse.strudelServOb.href}">${strudelResponse.strudelServOb.href}</a></p>
                </div>
                <div>
                    <p><i>Right Ascension, Declination, & Galactic Data relevant for Julian Date: ${strudelResponse.jd} (approximately the current moment)</i></p>
                </div>
            </c2:when>
            <c2:otherwise>
                <div>
                    <h2>${strudelResponse.strudelTarget.name}</h2>
                </div>
            </c2:otherwise>
        </c2:choose>
        <hr>
        <h2>Media</h2>
        <c2:forEach var="mediaItem" items="${itemList}">
            <hr>
            <div>
                <p>Image</p>
            </div>
            <c1:forEach var="data" items="${mediaItem.nasaDataList}">
                <c1:choose>
                    <c1:when test="${data.media_type == 'image'}">
                        <c:forEach var="link" items="${mediaItem.nasaLinkList}">
                            <img src="${link.href}" href="${link.href}">
                                <p>Description: ${data.description}</p>
                                <p>Date Created: ${data.date_created}</p>
                                <p>NASA ID: ${data.nasaId}</p>
                            </img>
                        </c:forEach>
                    </c1:when>
                    <c1:when test="${data.media_type == 'video'}">
                        <hr>
                        <div>
                            <p>Video</p>
                        </div>
                    </c1:when>
                    <c1:when test="${data.media_type == 'audio'}">
                        <hr>
                        <div>
                            <p>Audio</p>
                        </div>
                    </c1:when>
                </c1:choose>
            </c1:forEach>
        </c2:forEach>
    </div>
</div>
