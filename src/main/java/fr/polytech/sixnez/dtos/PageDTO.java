package fr.polytech.sixnez.dtos;

public class PageDTO {

    private int pageNumber;
    private int pageSize;
    private FilterDTO filter;

    public PageDTO(int pageNumber, int pageSize, FilterDTO filter) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.filter = filter;
    }

    public PageDTO() {
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int page) {
        this.pageNumber = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public FilterDTO getFilter() {
        return filter;
    }

    public void setFilter(FilterDTO filter) {
        this.filter = filter;
    }
}
