package model;

public class ReadingSession {

    private String id;
    private int currentPage;

    public ReadingSession(String id) {
        this.id = id;
        currentPage = 0;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void updateCurrentPage(int currentPage) {
        this.currentPage += currentPage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    
}
