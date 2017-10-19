package manageme.managemeapp;

/**
 * Created by david on 10/18/17.
 */

public class Request {
    private String title;

    private String description;
    private String status;
    private String severity;
    public Request(String _title, String _description, String _status, String _severity){
        title = _title;
        description = _description;
        status = _status;
        severity = _severity;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
}
