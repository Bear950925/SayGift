package dla.saygift.kindpage.raiders;

import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dla.saygift.MyApp;
import dla.saygift.R;

/**
 * Created by dllo on 16/10/17.
 */
public class AllSectionAdapter extends BaseAdapter{

    private String response;

    ArrayList<String> imgUrls;
    ArrayList<String> authors;
    ArrayList<String> titles;
    private JSONArray jsonArray;
    private String nextUrl;

    public String getNextUrl() {
        return nextUrl;
    }

    public void setResponse(String response) {
//        this.response = response;
        Log.d("AllSectionAdapter", response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            jsonObject = jsonObject.getJSONObject("data");
            JSONObject jsonObject1 = jsonObject.getJSONObject("paging");
            nextUrl = jsonObject1.getString("next_url");
            jsonArray = jsonObject.getJSONArray("columns");
            imgUrls = new ArrayList<>();
            authors = new ArrayList<>();
            titles = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject bean = jsonArray.getJSONObject(i);
                imgUrls.add(bean.getString("banner_image_url"));
                authors.add(jsonArray.getJSONObject(i).getString("author"));
                titles.add(bean.getString("title"));
            }
            Log.d("AllSectionAdapter", "imgUrls.size():" + imgUrls.size());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void Allload(ArrayList<String> imgUrls, ArrayList<String> authors, ArrayList<String> titles) {
        this.imgUrls.addAll(imgUrls);
        this.authors.addAll(authors);
        this.titles.addAll(titles);
        Log.d("AllSectionAdapter", "imgUrls.size():" + this.imgUrls.size());
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return imgUrls.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder myViewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindpage_allsec_channels, parent, false);
            myViewHolder = new MyViewHolder(convertView);

            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        Glide.with(MyApp.getmContext())
                .load(imgUrls.get(position))
                .into(myViewHolder.imageView);

        myViewHolder.author.setText(authors.get(position));
        myViewHolder.title.setText(titles.get(position));

        return convertView;
    }

    private class MyViewHolder {

        private final TextView title;
        private final TextView author;
        private final ImageView imageView;

        public MyViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.kindpage_allsec_img);
            author = (TextView) view.findViewById(R.id.kindpage_allsec_name);
            title = (TextView) view.findViewById(R.id.kindpage_allsec_title);
        }
    }
}
