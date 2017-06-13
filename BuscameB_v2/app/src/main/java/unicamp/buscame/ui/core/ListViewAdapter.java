package unicamp.buscame.ui.core;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import unicamp.buscame.R;

/**
 * @author ArchyWin on 8/31/2015.
 */
public class ListViewAdapter extends ArrayAdapter<ListViewItem> {
    public ListViewAdapter(Context context, List<ListViewItem> items) {
        super(context, R.layout.fragment_item_result, items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            // inflate the item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_item_result, parent, false);//inflate decode

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.cache_imgMain = (ImageView) convertView.findViewById(R.id.img_main_item);

            viewHolder.cache_textTitle = (TextView) convertView.findViewById(R.id.text_title_item);
            viewHolder.cache_textDescription = (TextView) convertView.findViewById(R.id.text_description_item);
            viewHolder.cache_imgOpen = (ImageView) convertView.findViewById(R.id.img_open_item);
            convertView.setTag(viewHolder);

        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        ListViewItem item = getItem(position);
        viewHolder.cache_imgMain.setImageBitmap(item.img);
        viewHolder.cache_textTitle.setText(item.title);
        viewHolder.cache_textDescription.setText(item.description);

        viewHolder.cache_imgOpen.setBackgroundColor(item.color);

        return convertView;
    }

    private static class ViewHolder {
        ImageView cache_imgMain;
        TextView cache_textTitle;
        TextView cache_textDescription;
        ImageView cache_imgOpen;
    }
}
