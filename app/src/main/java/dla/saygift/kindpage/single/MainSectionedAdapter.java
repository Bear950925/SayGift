package dla.saygift.kindpage.single;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import dla.saygift.MyApp;
import dla.saygift.R;

/**
 * 基本功能：右侧Adapter
 * 创建：王杰
 * 创建时间：16/4/14
 * 邮箱：w489657152@gmail.com
 */
public class MainSectionedAdapter extends SectionedBaseAdapter {

    private Context mContext;

    ArrayList<String> leftItems;
    ArrayList<singleItemsbean> rightCate;

    public MainSectionedAdapter(Context context, ArrayList<String>  leftStr, ArrayList<singleItemsbean> rightStr) {
        this.mContext = context;
        this.leftItems = leftStr;
        this.rightCate = rightStr;
    }

    @Override
    public Object getItem(int section, int position) {
        return rightCate.get(section).getCategoryName();
    }

    @Override
    public long getItemId(int section, int position) {
        return position;
    }

    @Override
    public int getSectionCount() {
        return leftItems.size();
    }

    @Override
    public int getCountForSection(int section) {
        return rightCate.get(section).getCategoryName().size();
    }

    @Override
    public View getItemView(final int section, final int position, View convertView, ViewGroup parent) {
        RelativeLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (RelativeLayout) inflator.inflate(R.layout.kindpage_s_right_list_item, null);
        } else {
            layout = (RelativeLayout) convertView;
        }
        ((TextView) layout.findViewById(R.id.textItem)).setText(rightCate.get(section).getCategoryName().get(position));
        Glide.with(MyApp.getmContext())
                .load(rightCate.get(section).getCategoryUrl().get(position))
                .into((ImageView) layout.findViewById(R.id.kindpage_s_img));
        layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(mContext, rightCate.get(section).getCategoryName().get(position), Toast.LENGTH_SHORT).show();
            }
        });
        return layout;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator.inflate(R.layout.kindpage_s_header_item, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        layout.setClickable(false);
        ((TextView) layout.findViewById(R.id.textItem)).setText(leftItems.get(section));
        return layout;
    }

}
