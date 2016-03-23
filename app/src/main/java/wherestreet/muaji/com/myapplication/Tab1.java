package wherestreet.muaji.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Tab1 extends Fragment {
    private ListView listView;
    private MyListAdapter mAdapter;
    private int type;

    public Tab1() {
    }

    /*public Tab1(Context context) {
        super();
        mContext = context;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tabs1, null);
        listView = (ListView) view.findViewById(R.id.listView);
        mAdapter = new MyListAdapter(getContext());
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(mItemClickListener);

        Intent intent = getActivity().getIntent(); // type 값 받아오기
        type = intent.getExtras().getInt("type");
        initData();

        return view;
    }

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(getActivity(), ItemActivity.class);
            bundle.putSerializable("position", position);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    };

    private void initData() {
        String s;
        switch (type) { //image, title, type, content, menu1, menu2
            case 0: // 먹거리
                s = "음식점";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
            case 1: // 볼거리
                s = "공연";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
            case 2: // 할거리
                s = "쇼핑";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
            case 3: // 편의시설
                s = "헤어";
                mAdapter.add(new ItemData(R.drawable.food_tab1_image1, "19뜯고맛보고", s, "맛있는 숯불고기!", "#통오겹살 7,000원", "#통삼겹살 6,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image2, "그린하우스", s, "부대찌개 맛집!", "#부대찌개 #된장찌개", "#육개장 #콩비지"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image3, "한솥도시락", s, "좋은 재료, 좋은 가격!", "#참치마요 2,700원", "#돈치마요 3,300원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image4, "맘스터치", s, "엄마의 정성과 사랑으로!", "#순살강정 13,000원", "#어니언치즈 10,000원"));
                mAdapter.add(new ItemData(R.drawable.food_tab1_image5, "둘둘치킨", s, "맛이 즐거워 함께하는 둘둘치킨!", "#순살파닭 13,000원", "#테리야끼 치킨 14,000원"));
                break;
        }
    }
}


