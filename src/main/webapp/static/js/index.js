
function getResults() {
    getNasaResults();
}


function getNasaResults() { //change spaces in any content to %20
    var types = ['q','center','description','keywords','location','media_type','nasa_id','photographer','title','year_start','year_end'];
    var first = true;
    var url = 'https://images-api.nasa.gov/search?';
    var id;
    var version;
    var filterList = [];


    //region BUILD URL AND POPULATE FILTER LIST
    if($('#inputSearchText').val() !== '') {
        first = false;
        url = url + 'q=' + $('#inputSearchText').val().replace(/ /g,'%20');
        filterList.push({filterName:"q",filterContent:$('#inputSearchText').val()});
    };

    if($('#inputCenterText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'center=' + $('#inputCenterText').val().replace(/ /g,'%20');
        filterList.push({filterName:"center",filterContent:$('#inputCenterText').val()});
    };

    if($('#inputDescriptionText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'description=' + $('#inputDescriptionText').val().replace(/ /g,'%20');
        filterList.push({filterName:"description",filterContent:$('#inputDescriptionText').val()});
    };

    if($('#inputKeywordsText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'keywords=' + $('#inputKeywordsText').val().replace(/ /g,'%20');
        filterList.push({filterName:"keywords",filterContent:$('#inputKeywordsText').val()});
    };

    if($('#inputLocationText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'location=' + $('#inputLocationText').val().replace(/ /g,'%20');
        filterList.push({filterName:"location",filterContent:$('#inputLocationText').val()});
    };

    if($('#inputMediaTypeText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'media_type=' + $('#inputMediaTypeText').val().replace(/ /g,'%20');
        filterList.push({filterName:"media_type",filterContent:$('#inputMediaTypeText').val()});
    };

    if($('#inputNasaIdText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'nasa_id=' + $('#inputNasaIdText').val().replace(/ /g,'%20');
        filterList.push({filterName:"nasa_id",filterContent:$('#inputNasaIdText').val()});
    };

    if($('#inputPhotographerText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'photographer=' + $('#inputPhotographerText').val().replace(/ /g,'%20');
        filterList.push({filterName:"photographer",filterContent:$('#inputPhotographerText').val()});
    };

    if($('#inputTitleText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'title=' + $('#inputTitleText').val().replace(/ /g,'%20');
        filterList.push({filterName:"title",filterContent:$('#inputTitleText').val()});
    };

    if($('#inputBeginningYearText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'year_start=' + $('#inputBeginningYearText').val().replace(/ /g,'%20');
        filterList.push({filterName:"year_start",filterContent:$('#inputBeginningYearText').val()});
    };

    if($('#inputEndYearText').val() !== '') {
        if(first) {
            first = false;
        } else {
            url = url + '&';
        };
        url = url + 'year_end=' + $('#inputEndYearText').val().replace(/ /g,'%20');
        filterList.push({filterName:"year_end",filterContent:$('#inputEndYearText').val()});
    };
    //endregion

    var nasaRequest = {
        filterList: filterList
    };

    //Debug print off of NASA URL and filterList
    // console.log('NASA URL: '+url);
    // console.log('filterList: '+filterList);

    $.ajax({
        type: "get",
        url: url,
        async: true,
        dataType: "json",
        contentType: "application/json",
        success: function(nasaResponse){
            // console.log("S- getNasaResults NASA Response:");
            // console.log(nasaResponse);
            nasaResponse["nasaQueryRequest"] = nasaRequest;
            saveNasaResponse(nasaResponse);
        },
        error: function(nasaCollection) {
            console.log("E- getNasaResults NASA Response:");
            console.log(nasaCollection);
        }
    });
};

function saveNasaResponse(nasaResponse) {

    // console.log("nasaResponse: ");
    // console.log(JSON.stringify(nasaResponse));

    $.ajax({
        type: "post",
        data: JSON.stringify(nasaResponse),
        url: "http://localhost:8080/api/nasaResponse/",
        async: true,
        dataType: "json",
        contentType: "application/json",
        success: function(dbResponse) {
            console.log("S- saveNasaResponse DB Response: ");
            console.log(dbResponse);
            getStrudelResults(dbResponse);
        },
        error: function(dbResponse) {
            console.log("E- saveNasaResponse DB Response: ");
            console.log(dbResponse);
        }
    });
};

function getStrudelResults(dbNasaResponse) {
    var url = 'http://www.strudel.org.uk/lookUP/json/?name=' + $('#inputSearchText').val().replace(/ /g,'%20') + '&callback=lk';
    // var url = 'http://www.strudel.org.uk/lookUP/json/?name=' + $('#inputSearchText').val().replace(/ /g,'%20');
    // console.log("Strudel URL: "+url);

    $.ajax({
        type: "get",
        url: url,
        async: true,
        dataType: "jsonp",
        contentType: "application/json",
        success: function(strudelResponse){
            console.log("S- getStrudelResults Strudel Response:");
            console.log(strudelResponse);
            saveStrudelData(strudelResponse,dbNasaResponse);
        },
        error: function(strudelResponse) {
            console.log("E- getStrudelResults Strudel Response: ");
            console.log(strudelResponse);
        }
    });
};

function saveStrudelData(strudelResponse, dbNasaResponse){
    $.ajax({
        type: "post",
        data: JSON.stringify(strudelResponse),
        url: "http://localhost:8080/api/strudelResponse/",
        async: true,
        dataType: "json",
        contentType: "application/json",
        success: function(dbResponse) {
            console.log("S- saveStrudelResponse DB Response: ");
            console.log(dbResponse);
            ajaxRedirect(dbNasaResponse, dbResponse);
        },
        error: function(dbResponse) {
            console.log("E- saveStrudelResponse DB Response: ");
            console.log(dbResponse);
        }
    });
};

function ajaxRedirect(dbNasaResponse, dbStrudelResponse) {
    console.log("dbNasaResponse");
    console.log(dbNasaResponse);

    console.log("dbStrudelResponse");
    console.log(dbStrudelResponse);


    var naId = dbNasaResponse['id'];
    var srId = dbStrudelResponse['id'];

    window.location = "http://localhost:8080/resultAjax/" + naId + "_" + srId;
};

//region Filters
function addFilter() {
    $('#addFilterModal').modal('show')
};

function showAppliedFilters(){

    if($('#inputCenter').is(':checked')) {
        $('#centerContainer').show();
    } else {
        $('#centerContainer').hide();
    }

    if($('#inputDescription').is(':checked')) {
        $('#descriptionContainer').show();
    } else {
        $('#descriptionContainer').hide();
    }

    if($('#inputKeywords').is(':checked')) {
        $('#keywordsContainer').show();
    } else {
        $('#keywordsContainer').hide();
    }

    if($('#inputLocations').is(':checked')) {
        $('#locationContainer').show();
    } else {
        $('#locationContainer').hide();
    }

    if($('#inputMediaType').is(':checked')) {
        $('#mediaTypeContainer').show();
    } else {
        $('#mediaTypeContainer').hide();
    }

    if($('#inputNasaId').is(':checked')) {
        $('#nasaIdContainer').show();
    } else {
        $('#nasaIdContainer').hide();
    }

    if($('#inputPhotographer').is(':checked')) {
        $('#photographerContainer').show();
    } else {
        $('#photographerContainer').hide();
    }

    if($('#inputTitle').is(':checked')) {
        $('#titleContainer').show();
    } else {
        $('#titleContainer').hide();
    }

    if($('#inputBeginningYear').is(':checked')) {
        $('#beginningYearContainer').show();
    } else {
        $('#beginningYearContainer').hide();
    }

    if($('#inputEndYear').is(':checked')) {
        $('#endYearContainer').show();
    } else {
        $('#endYearContainer').hide();
    }
}

function removeFilter(caller) {
    switch($(caller).attr('id')) {
        case "removeCenterBtn":
            $('#inputCenter').prop('checked', false);
            $('#inputCenterText').val('');
            $('#centerContainer').hide();
            break;

        case "removeKeywordsBtn":
            $('#inputKeywords').prop('checked', false);
            $('#inputKeywordsText').val('');
            $('#keywordsContainer').hide();
            break;

        case "removeLocationBtn":
            $('#inputLocations').prop('checked', false);
            $('#inputLocationsText').val('');
            $('#locationContainer').hide();
            break;

        case "removeMediaTypeBtn":
            $('#inputMediaType').prop('checked', false);
            $('#inputMediaTypeText').val('');
            $('#mediaTypeContainer').hide();
            break;

        case "removeNasaIdBtn":
            $('#inputNasaId').prop('checked', false);
            $('#inputNasaIdText').val('');
            $('#nasaIdContainer').hide();
            break;

        case "removeDescriptionBtn":
            $('#inputDescription').prop('checked', false);
            $('#inputDescriptionText').val('');
            $('#descriptionContainer').hide();
            break;

        case "removePhotographerBtn":
            $('#inputPhotographer').prop('checked', false);
            $('#inputPhotographerText').val('');
            $('#photographerContainer').hide();
            break;

        case "removeTitlesBtn":
            $('#inputTitle').prop('checked', false);
            $('#inputTitleText').val('');
            $('#titleContainer').hide();
            break;

        case "removeBeginningYearBtn":
            $('#inputBeginningYear').prop('checked', false);
            $('#inputBeginningYearText').val('');
            $('#beginningYearContainer').hide();
            break;

        case "removeEndYearBtn":
            $('#inputEndYear').prop('checked', false);
            $('#inputEndYearText').val('');
            $('#endYearContainer').hide();
            break;

        default:
            console.log('ERROR: Filter Name not found.');
    }
};
//endregion