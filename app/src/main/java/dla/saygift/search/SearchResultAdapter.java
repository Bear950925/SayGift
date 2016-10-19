package dla.saygift.search;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import dla.saygift.R;
import dla.saygift.volleysingle.MyApp;

/**
 * Created by dllo on 16/10/19.
 */
public class SearchResultAdapter extends BaseAdapter{

    private ArrayList<String> description = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> selections = new ArrayList<>();
    private ArrayList<String> prices;

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public void setSelections(ArrayList<String> selections) {
        this.selections = selections;
    }

    public void setImgUrls(ArrayList<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    private ArrayList<String> imgUrls = new ArrayList<>();

    private FragmentManager manager;

    @Override
    public int getCount() {
        int count;
        count = (imgUrls.size() + 1) / 2;
        return count;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder myViewHolder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_resultitem, parent, false);
            myViewHolder = new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);

        } else {

            myViewHolder = (MyViewHolder) convertView.getTag();

        }

        try {
            myViewHolder.textViews[0].setText(names.get(position * 2));
            myViewHolder.pricesTv[0].setText(prices.get(position * 2));
            myViewHolder.desTv[0].setText(description.get(position * 2));
            Glide.with(MyApp.getmContext())
                    .load(imgUrls.get(position * 2))
                    .into(myViewHolder.imageViews[0]);


            myViewHolder.desTv[1].setText(description.get(position * 2 + 1));
            myViewHolder.textViews[1].setText(names.get(position * 2 + 1));
            myViewHolder.pricesTv[1].setText(prices.get(position * 2 + 1));
            Glide.with(MyApp.getmContext())
                    .load(imgUrls.get(position * 2 + 1))
                    .into(myViewHolder.imageViews[1]);

        } catch (NullPointerException e) {

        } catch (IndexOutOfBoundsException e) {
            myViewHolder.desTv[1].setVisibility(View.INVISIBLE);
            myViewHolder.textViews[1].setVisibility(View.INVISIBLE);
            myViewHolder.pricesTv[1].setVisibility(View.INVISIBLE);
            myViewHolder.imageViews[1].setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    public void setPrices(ArrayList<String> pricess) {
        this.prices = pricess;
    }

    public void Allload(ArrayList<String> descriptions, ArrayList<String> namess, ArrayList<String> selectionss, ArrayList<String> imgUrlss, ArrayList<String> pricess) {
        this.description.addAll(descriptions);
        this.names.addAll(namess);
        this.selections.addAll(selectionss);
        this.imgUrls.addAll(imgUrlss);
        this.prices.addAll(pricess);
        notifyDataSetChanged();
    }

    private class MyViewHolder {

        private final TextView[] textViews;
        private final TextView[] desTv;
        private final ImageView[] imageViews;
        private final TextView[] pricesTv;

        public MyViewHolder(View convertView) {
            textViews = new TextView[2];
            desTv = new TextView[2];
            imageViews = new ImageView[2];
            pricesTv = new TextView[2];

            pricesTv[0] = (TextView) convertView.findViewById(R.id.search_result_price1);
            pricesTv[1] = (TextView) convertView.findViewById(R.id.search_result_price2);

            imageViews[0] = (ImageView) convertView.findViewById(R.id.search_result_img1);
            imageViews[1] = (ImageView) convertView.findViewById(R.id.search_result_img2);

            desTv[0] = (TextView) convertView.findViewById(R.id.search_result_des1);
            desTv[1] = (TextView) convertView.findViewById(R.id.search_result_des2);

            textViews[0] = (TextView) convertView.findViewById(R.id.search_result_tv1);
            textViews[1] = (TextView) convertView.findViewById(R.id.search_result_tv2);
        }
    }

    public void rePlaceFragment(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.search_frame, fragment);
        transaction.commit();
    }

}
