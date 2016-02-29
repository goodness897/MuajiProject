package wherestreet.muaji.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MenuView extends FrameLayout {
    public MenuView(Context context) {
        super(context);
        init();
    }

    TextView representMenu;
    TextView Price;


    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.menu_list, this);
        representMenu = (TextView) findViewById(R.id.text_represent);
        Price = (TextView) findViewById(R.id.text_price);

    }

    ItemData mData;

    public void setItemData(ItemData data) {
        mData = data;
        representMenu.setText(data.repremenu);
        Price.setText(data.price);
    }

}

