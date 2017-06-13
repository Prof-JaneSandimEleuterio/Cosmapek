package unicamp.buscame.ui.core;

import android.graphics.Bitmap;

/**
 * @author ArchyWin on 8/31/2015.
 */
public class ListViewItem {
    public final String id;
    public final Bitmap img;       // the drawable for the ListView item ImageView
    public final String title;        // the text for the ListView item title
    public final String description;  // the text for the ListView item description
    public final int color;

    public ListViewItem(String id, Bitmap img, String title, String description, int color) {
        this.id=id;
        this.img = img;
        this.title = title;
        this.description = description;
        this.color =color;
    }
}
