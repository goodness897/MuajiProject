package com.example.mu.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CouponActivity extends Activity {
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
        String title = getString(R.string.app_name);
        setActionBar(title);
    }
    public void setActionBar(String title){

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);

        final TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        final EditText searchEdit = (EditText)mCustomView.findViewById(R.id.search_text);
        mTitleTextView.setText(title);

        ImageButton imageButton = (ImageButton) mCustomView
                .findViewById(R.id.search_image);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                MainActivity.flag = !MainActivity.flag;
                if(MainActivity.flag){ //검색창 활성화
                    searchEdit.setVisibility(View.VISIBLE);
                    mTitleTextView.setVisibility(View.GONE);
                } else { // 검색
                    searchEdit.setVisibility(View.GONE);
                    mTitleTextView.setVisibility(View.VISIBLE);
                }
            }
        });
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);

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
    TextView couponTitle,couponMenu;


    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.coupon_item,this);
        imageView = (ImageView)findViewById(R.id.coupon_image);
        couponTitle = (TextView)findViewById(R.id.coupon_title);
        couponMenu = (TextView)findViewById(R.id.coupon_menu);


    }
    CouponData mData;
    public void setCouponData(CouponData data){
        mData = data;
        imageView.setImageResource(data.image);
        couponTitle.setText(data.title);
        couponMenu.setText(data.content);
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