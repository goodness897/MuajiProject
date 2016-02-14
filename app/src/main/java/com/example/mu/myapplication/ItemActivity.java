package com.example.mu.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.SyncStateContract;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ItemActivity extends Activity {

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    ImageView menuImage1;
    ImageView menuImage2;
    ImageView menuImage3;
    ImageView menuImage4;
    ListView listView;
    My2Adapter mAdapter;
    TextView textView;

    RatingBar ratingBar;
    int[] mResources = {
            R.drawable.first,
            R.drawable.second,
            R.drawable.third,
            R.drawable.four,
            R.drawable.fifth,
    };
    String[] menuName = {"1", "2", "3", "4", "5"};
    private int position;
    private int count;
    private float totalRank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        position = this.getIntent().getExtras().getInt("position");
        listView = (ListView) findViewById(R.id.listView);

        if(android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        String title = getString(R.string.app_name);
        setActionBar(title);

        mAdapter = new My2Adapter(this);
        listView.setAdapter(mAdapter);
        menuImage1 = (ImageView)findViewById(R.id.menu_image1);
        menuImage2 = (ImageView)findViewById(R.id.menu_image2);
        menuImage3 = (ImageView)findViewById(R.id.menu_image3);
        menuImage4 = (ImageView)findViewById(R.id.menu_image4);
        textView = (TextView)findViewById(R.id.textView);
        textView.setText(menuName[0]);

        setImage(menuImage1, "http://www.hsd.co.kr/resources/uploads/lunch/1433477392252_rrqnwbzu.jpg");
        setImage(menuImage2, "http://www.hsd.co.kr/resources/uploads/lunch/1433477371928_hdujnuwk.jpg");
        setImage(menuImage3, "http://www.hsd.co.kr/resources/uploads/lunch/1435645212983_kkqeuafp.jpg");
        setImage(menuImage4, "http://www.hsd.co.kr/resources/uploads/lunch/1433486885624_xijfduwu.jpg");
        mAdapter.add(new ItemData("개나리 도시락", "8,000원"));
        mAdapter.add(new ItemData("진달래 도시락", "7,000원"));
        mAdapter.add(new ItemData("불고기 비빔밥", "4,500원"));
        mAdapter.add(new ItemData("고기고기 도시락", "3,600원"));
        //listView.setAdapter(menuArray);
        mCustomPagerAdapter = new CustomPagerAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        radioGroup.check(R.id.radioButton);
                        textView.setText(menuName[0]);
                        break;
                    case 1:
                        radioGroup.check(R.id.radioButton2);
                        textView.setText(menuName[1]);
                        break;
                    case 2:
                        radioGroup.check(R.id.radioButton3);
                        textView.setText(menuName[2]);
                        break;
                    case 3:
                        radioGroup.check(R.id.radioButton4);
                        textView.setText(menuName[3]);
                        break;
                    case 4:
                        radioGroup.check(R.id.radioButton5);
                        textView.setText(menuName[4]);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setAdapter(mCustomPagerAdapter);
    }

    public class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;


        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(mResources[position]);
            // textView = (TextView) container.findViewById(R.id.textView);
            //textView.setText(menuName[position]);
            container.addView(itemView);
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }

    public void onButton1Clicked(View v) {

        Intent intent = new Intent(Intent.ACTION_VIEW);

        Uri uri = Uri.parse("http://hansotuos.modoo.at/");
        intent.setData(uri);
        startActivity(intent);
    }

    public void onButton2Clicked(View v) {
        String phoneNum = "tel:010-2043-9377";
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse(phoneNum));
        startActivity(intent);
    }

    public void onButton3Clicked(View v) {
        final Dialog rankDialog = new Dialog(v.getContext(), R.style.FullHeightDialog);
        rankDialog.setContentView(R.layout.rank_dialog);
        rankDialog.setCancelable(true);
        ratingBar = (RatingBar) rankDialog.findViewById(R.id.dialog_ratingbar);
        TextView text = (TextView) rankDialog.findViewById(R.id.rank_dialog_text1);
        text.setText("평점을 남겨주세요");

        Button updateButton = (Button) rankDialog.findViewById(R.id.rank_dialog_button);
        updateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count++; // 평점 남긴 횟수
                final float userRankValue = ratingBar.getRating();
                totalRank += userRankValue;
                float score = totalRank / count;
                String myRank = String.format("%.1f", score);
               /* String myRank = Float.toString(score);
                String.format("%.2f", Double.valueOf(myRank));*/
                RatingBar rateBar = (RatingBar) findViewById(R.id.rateBar);
                rateBar.setRating(userRankValue);
                TextView rateText = (TextView) findViewById(R.id.rateText);
                rateText.setText(myRank);
                TextView rateCount = (TextView)findViewById(R.id.ratecountText);
                rateCount.setText("(" + count + ")");
                rankDialog.dismiss();

            }
        });
        rankDialog.show();
    }

    public void setImage(ImageView imageView, String address){
        try {
            URL url = new
                    URL(address);
            URLConnection conn = url.openConnection();
            conn.connect();
            BufferedInputStream bis = new
                    BufferedInputStream(conn.getInputStream());
            Bitmap bm = BitmapFactory.decodeStream(bis);
            bis.close();
            imageView.setImageBitmap(bm);
        } catch (IOException e) {

        }
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
