package manageme.managemeapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import static manageme.managemeapp.R.drawable.ic_picture;


public class Request {
    DataBank bank = DataBank.getDataBank();
    private String title;
    private String description;
    private String status;
    private String severity;

    private Bitmap photo;

    public Request(String _title, String _description, String _status, String _severity, Bitmap _photo){
        title = _title;
        description = _description;
        status = _status;
        severity = _severity;
        photo = _photo;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public Bitmap getPhoto() {
        if (photo == null){
            Drawable drawable = bank.getPendingScreen().getDrawable(ic_picture);
            Canvas canvas = new Canvas();
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            canvas.setBitmap(bitmap);
            drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        }
        else{
            return photo;
        }
    }
    public void setPhoto(Bitmap photo) { this.photo = photo; }
}
