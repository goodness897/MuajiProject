package com.example.mu.myapplication;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CouponActivity extends AppCompatActivity {
    ListView listView;
    CouponAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        listView = (ListView)findViewById(R.id.listView);
        cAdapter = new CouponAdapter(this);
        listView.setAdapter(cAdapter);
        cAdapter.add(new CouponData(R.drawable.image1, "쿠폰", "20% 할인 쿠폰"));
    }
}
class CouponData {
    public int image;
    public String title;
    public String content;

    CouponData(int image, String title, String content){
        this.image = image;
        this.title = title;
        this.content = content;
    }
}

class CouponView extends FrameLayout {
    public CouponView(Context context){
        super(context);
        init();
    }

    ImageView imageView;
    TextView titleView,contentView;


    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.coupon_item,this);

    }
    CouponData mData;
    public void setCouponData(CouponData data){
        mData = data;
        titleView.setText(data.title);
        contentView.setText(data.content);


    }

}
class CouponAdapter extends BaseAdapter {

    ArrayList<CouponData> items = new ArrayList<CouponData>();
    Context mContext;

    public CouponAdapter(Context context) {
        mContext = context;
    }

    public void add(CouponData item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void addAll(List<CouponData> items) {
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
        CouponView v;
        if (convertView == null) {
            v = new CouponView(mContext);
        } else {
            v = (CouponView) convertView;
        }
        v.setCouponData(items.get(position));
        return v;
    }
}