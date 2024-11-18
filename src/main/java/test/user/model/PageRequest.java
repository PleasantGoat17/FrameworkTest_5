package test.user.model;

public class PageRequest {
    private int offset;
    private int pageSize;

    public PageRequest(int page, int size) {
        this.offset = page * size;
        this.pageSize = size;
    }

    public int getOffset() {
        return offset;
    }

    public int getPageSize() {
        return pageSize;
    }
}
