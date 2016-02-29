package wherestreet.muaji.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Tab2 extends Fragment {
    Context mContext;
    ListView listView;
    MyAdapter mAdapter;
    private int type;

    public Tab2() {

    }

    /*public Tab2(Context context){
        super();
        mContext = context;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tabs1, null);
        listView = (ListView) view.findViewById(R.id.listView);
        mAdapter = new MyAdapter(getContext());
        listView.setAdapter(mAdapter);

        Intent intent = getActivity().getIntent(); // type 값 받아오기
        type = intent.getExtras().getInt("type");
        initData();

        return view;
    }

    public void initData() {
        String s;

        switch (type) { //image, title, type, content, menu1, menu2
            case 0: // 먹거리
                s = "술집";
                mAdapter.add(new ItemData(R.drawable.food_tab2_image1, "실크로드", s, "시립대 정문의 칵테일 바", "#압생트 밤 13,000원", "#아브라카타브라 8,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab2_image2, "맥주창고", s, "다양한 세계 맥주를 직접 골라!", "#후라이드치킨 14,800원", "#양념치킨 15,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab2_image3, "BOSS호프", s, "최상의 서비스, 맛있는 음식!", "#대구포구이 10,000원", "#모듬감자튀김 10,000원"));

                break;
            case 1: // 볼거리
                s = "전시";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 뿌치 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
            case 2: // 할거리
                s = "노래방";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 뿌치 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
            case 3: // 편의시설
                s = "네일";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 뿌치 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
        }


    }
}


