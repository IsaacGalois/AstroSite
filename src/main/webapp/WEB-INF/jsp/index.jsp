<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<c:url value="/static/js/index.js" var="index" />
<Script src="${index}"></Script>

<script>
    $(document).ready(function() {
        $('.filterContainer').hide();
    });
</script>

<div class="container">
    <div class="jumbotron">
        <h2>Astronomy Resource Center</h2>
        <p>Enter a keyword or phrase to see images and data related to an Astronomical phenomenon.</p>
        <div class="container">
            <%--<form class="form-horizontal">--%>
                <form:form cssClass="form-horizontal" modelAttribute="nasaQueryRequestVO" action="/result" method="post">
                <fieldset>
                    <hidden id="nasaQueryRequestId" />
                    <hidden id="nasaQueryRequestVersion" />

                    <div class="form-group">
                        <label for="inputSearchText" class="col-lg-2 control-label">Astronomy Resource Search</label>
                        <div class="col-lg-8">
                            <form:input path="newSearchText" type="text" cssClass="form-control" id="inputSearchText" placeholder="Enter Search Here..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-default" onclick="addFilter()" id="addFilterBtn">Add Filter</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="centerContainer">
                        <label for="inputCenterText" class="col-lg-2 control-label">NASA Centers</label>
                        <div class="col-lg-8">
                            <form:input path="newNasaCenter" type="text" cssClass="form-control" id="inputCenterText" placeholder="Enter NASA Centers Here..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removeCenterBtn">x</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="descriptionContainer">
                        <label for="inputDescriptionText" class="col-lg-2 control-label">Description</label>
                        <div class="col-lg-8">
                            <form:input path="newDescription" type="text" cssClass="form-control" id="inputDescriptionText" placeholder="Enter Description Here..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removeDescriptionBtn">x</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="keywordsContainer">
                        <label for="inputKeywordsText" class="col-lg-2 control-label">Keywords</label>
                        <div class="col-lg-8">
                            <form:input path="newKeywords" type="text" cssClass="form-control" id="inputKeywordsText" placeholder="Enter Keywords Here..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removeKeywordsBtn">x</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="locationContainer">
                        <label for="inputLocationText" class="col-lg-2 control-label">Locations</label>
                        <div class="col-lg-8">
                            <form:input path="newLocation" type="text" cssClass="form-control" id="inputLocationText" placeholder="Enter Locations Here..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removeLocationBtn">x</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="mediaTypeContainer">
                        <label for="inputMediaTypeText" class="col-lg-2 control-label">Media Types</label>
                        <div class="col-lg-8">
                            <form:input path="newMediaType" type="text" cssClass="form-control" id="inputMediaTypeText" placeholder="Enter Media Types Here..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removeMediaTypeBtn">x</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="nasaIdContainer">
                        <label for="inputNasaIdText" class="col-lg-2 control-label">NASA IDs</label>
                        <div class="col-lg-8">
                            <form:input path="newNasaId" type="text" cssClass="form-control" id="inputNasaIdText" placeholder="Enter NASA IDs Here..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removeNasaIdBtn">x</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="photographerContainer">
                        <label for="inputPhotographerText" class="col-lg-2 control-label">Photographers</label>
                        <div class="col-lg-8">
                            <form:input path="newPhotographer" type="text" cssClass="form-control" id="inputPhotographerText" placeholder="Enter Photographers Here..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removePhotographerBtn">x</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="titleContainer">
                        <label for="inputTitleText" class="col-lg-2 control-label">Titles</label>
                        <div class="col-lg-8">
                            <form:input path="newTitle" type="text" cssClass="form-control" id="inputTitleText" placeholder="Enter Title Here..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removeTitlesBtn">x</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="beginningYearContainer">
                        <label for="inputBeginningYearText" class="col-lg-2 control-label">Beginning Year</label>
                        <div class="col-lg-8">
                            <form:input path="newYearStart" type="text" cssClass="form-control" id="inputBeginningYearText" placeholder="Enter Beginning Year Here (YYYY format)..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removeBeginningYearBtn">x</button>
                        </div>
                    </div>

                    <div class="form-group filterContainer" id="endYearContainer">
                        <label for="inputEndYearText" class="col-lg-2 control-label">Ending Year</label>
                        <div class="col-lg-8">
                            <form:input path="newYearEnd" type="text" cssClass="form-control" id="inputEndYearText" placeholder="Enter Ending Year Here (YYYY format)..."></form:input>
                        </div>
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" onclick="removeFilter(this)" id="removeEndYearBtn">x</button>
                        </div>
                    </div>

                    <form:button type="reset" value="cancel" class="btn btn-default" onclick="window.location.reload()">Reset</form:button>
                    <form:button type="submit" value="save" class="btn btn-primary">Search MVC</form:button>
                    <button type="button" class="btn btn-primary" onclick="getResults()">Search Ajax</button>
                    <%--<a href="http://localhost:8080/resultAjax" type="button" class="btn btn-primary" onclick="getResults()">Search Ajax</a>--%>

                </fieldset>
            </form:form>

        </div>
    </div>

    <div class="modal" id="addFilterModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Add Filter</h4>
                </div>
                <div class="modal-body">
                    <p>Please choose which filters to apply to the images returned from your search.</p>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputCenter" class="checkbox-inline"><input type="checkbox" value="" id="inputCenter">- NASA Center</label>
                            </div>
                        </div>
                    </div>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputDescription" class="checkbox-inline"><input type="checkbox" value="" id="inputDescription">- Description</label>
                            </div>
                        </div>
                    </div>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputKeywords" class="checkbox-inline"><input type="checkbox" value="" id="inputKeywords">- Keywords</label>
                            </div>
                        </div>
                    </div>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputLocations" class="checkbox-inline"><input type="checkbox" value="" id="inputLocations">- Locations</label>
                            </div>
                        </div>
                    </div>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputMediaType" class="checkbox-inline"><input type="checkbox" value="" id="inputMediaType">- Media Types</label>
                            </div>
                        </div>
                    </div>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputMediaType" class="checkbox-inline"><input type="checkbox" value="" id="inputNasaId">- NASA IDs</label>
                            </div>
                        </div>
                    </div>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputMediaType" class="checkbox-inline"><input type="checkbox" value="" id="inputPhotographer">- Photographers</label>
                            </div>
                        </div>
                    </div>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputMediaType" class="checkbox-inline"><input type="checkbox" value="" id="inputTitle">- Titles</label>
                            </div>
                        </div>
                    </div>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputMediaType" class="checkbox-inline"><input type="checkbox" value="" id="inputBeginningYear">- Beginning Year</label>
                            </div>
                        </div>
                    </div>

                    <div class="row checkbox-row">
                        <div class="col-sm-6">
                            <div class="checkbox-inline" style="text-align:center">
                                <label for="inputMediaType" class="checkbox-inline"><input type="checkbox" value="" id="inputEndYear">- Ending Year</label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary btn-ok" data-dismiss="modal" onclick="showAppliedFilters()" id="confirmAddFiltersBtn">Apply Filters</button>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>