package dla.saygift.kindpage.raiders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import dla.saygift.MyApp;
import dla.saygift.R;

/**
 * Created by dllo on 16/10/17.
 */
public class AllChannelsAdapter extends RecyclerView.Adapter<AllChannelsAdapter.MyViewHolder>{

    ArrayList<String> imgUrls;

    public void setImgUrls(ArrayList<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    @Override
    public AllChannelsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindpage_allcha_channels, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(AllChannelsAdapter.MyViewHolder holder, int position) {
        Glide.with(MyApp.getmContext())
                .load(imgUrls.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imgUrls.size() - 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.kindpage_allcha_img);
        }
    }
}
