package wherestreet.muaji.com.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyItemAdapter extends BaseAdapter {

    ArrayList<ItemData> items = new ArrayList<ItemData>();
    Context mContext;

    public MyItemAdapter(Context context) {
        mContext = context;
    }

    public void add(ItemData item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void addAll(List<ItemData> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MenuView v;
        if (convertView == null) {
            v = new MenuView(mContext);

        } else {
            v = (MenuView) convertView;

        }
        v.setItemData(items.get(position));
        return v;
    }
}
