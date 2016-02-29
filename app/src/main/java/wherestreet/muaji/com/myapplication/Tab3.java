package wherestreet.muaji.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Tab3 extends Fragment {
    Context mContext;
    ListView listView;
    MyAdapter mAdapter;
    private int type;

    public Tab3() {

    }

    /*public Tab3(Context context){
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
                s = "카페";
                mAdapter.add(new ItemData(R.drawable.food_tab3_image1, "버블유", s, "맛있는 버블티 전문점!", "#타로 2,500원", "#얼그레이 2,500원"));
                mAdapter.add(new ItemData(R.drawable.food_tab3_image2, "LaSiesta", s, "It’s real! 신선한 재료!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab3_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab3_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 뿌치 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab3_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
            case 1: // 볼거리
                s = "공원";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 뿌치 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
            case 2: // 할거리
                s = "당구장";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 뿌치 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
            case 3: // 편의시설
                s = "세탁/수선";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 뿌치 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
        }
    }
}

