package fr.polytech.sixnez.dtos;

public class PageDTO {

    private int pageNumber;
    private int pageSize;

    public PageDTO(int page, int pageSize) {
        this.pageNumber = page;
        this.pageSize = pageSize;
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
}
