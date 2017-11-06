package astroSite.domain.VO;

import java.util.ArrayList;
import java.util.List;

public class NasaQueryRequestVO {

    private String newSearchText;
    private String newNasaCenter;
    private String newDescription;
    private String newKeywords;
    private String newLocation;
    private String newMediaType;
    private String newNasaId;
    private String newPhotographer;
    private String newTitle;
    private String newYearStart;
    private String newYearEnd;

    private List<List<String>> filterList;

    public NasaQueryRequestVO () {}

    public NasaQueryRequestVO(List<List<String>> a2dList) {
        this.setFilterList(a2dList);
    }

    public List<List<String>> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<List<String>> filterList) {
        this.filterList = filterList;
    }

    public String getNewSearchText() {
        return newSearchText;
    }

    public void setNewSearchText(String newSearchText) {
        this.newSearchText = newSearchText;
    }

    public String getNewNasaCenter() {
        return newNasaCenter;
    }

    public void setNewNasaCenter(String newNasaCenter) {
        this.newNasaCenter = newNasaCenter;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public String getNewKeywords() {
        return newKeywords;
    }

    public void setNewKeywords(String newKeywords) {
        this.newKeywords = newKeywords;
    }

    public String getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }

    public String getNewMediaType() {
        return newMediaType;
    }

    public void setNewMediaType(String newMediaType) {
        this.newMediaType = newMediaType;
    }

    public String getNewNasaId() {
        return newNasaId;
    }

    public void setNewNasaId(String newNasaId) {
        this.newNasaId = newNasaId;
    }

    public String getNewPhotographer() {
        return newPhotographer;
    }

    public void setNewPhotographer(String newPhotographer) {
        this.newPhotographer = newPhotographer;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewYearStart() {
        return newYearStart;
    }

    public void setNewYearStart(String newYearStart) {
        this.newYearStart = newYearStart;
    }

    public String getNewYearEnd() {
        return newYearEnd;
    }

    public void setNewYearEnd(String newYearEnd) {
        this.newYearEnd = newYearEnd;
    }

    //Helper Methods
    public void makeFilterList() {
        List<List<String>> filterList = new ArrayList<>();
        List<String> row = new ArrayList<>();
        row.add("q");
        row.add(this.newSearchText);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("center");
        row.add(this.newNasaCenter);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("description");
        row.add(this.newDescription);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("keywords");
        row.add(this.newKeywords);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("location");
        row.add(this.newLocation);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("media_type");
        row.add(this.newMediaType);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("nasa_id");
        row.add(this.newNasaId);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("photographer");
        row.add(this.newPhotographer);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("title");
        row.add(this.newTitle);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("year_start");
        row.add(this.newYearStart);
        filterList.add(row);

        row = new ArrayList<>();
        row.add("year_end");
        row.add(this.newYearEnd);
        filterList.add(row);

        this.filterList = filterList;
    }
}
