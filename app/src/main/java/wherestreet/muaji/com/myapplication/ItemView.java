package wherestreet.muaji.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemView extends FrameLayout {
    public ItemView(Context context){
        super(context);
        init();
    }

    ImageView iconView;
    TextView titleView, typeView, contentView, menu1View, menu2View;


    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_layout,this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        titleView = (TextView)findViewById(R.id.text_title);
        typeView = (TextView)findViewById(R.id.text_type);
        contentView = (TextView)findViewById(R.id.text_content);
        menu1View = (TextView)findViewById(R.id.text_menu1);
        menu2View = (TextView)findViewById(R.id.text_menu2);
    }
    ItemData mData;
    public void setItemData(ItemData data){
        mData = data;
        iconView.setImageResource(data.imageId);
        titleView.setText(data.title);
        typeView.setText(data.type);
        contentView.setText(data.content);
        menu1View.setText(data.menu1);
        menu2View.setText(data.menu2);

    }

}

