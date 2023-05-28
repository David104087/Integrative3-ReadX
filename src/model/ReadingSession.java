package model;

/**
 * This class represents a reading session.
 */
public class ReadingSession {

    /**
     * This attribute represents the id of the reading session.
     */
    private String id;
    /**
     * This attribute represents the current page of the reading session.
     */
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

    /**
     * This function updates the current page of the reading session.
     * @param currentPage the current page of the reading session
     */
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
