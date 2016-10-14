package dla.saygift.kindpage.raiders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import dla.saygift.MyApp;
import dla.saygift.R;
import dla.saygift.listpage.ContentFragmentAdapter;

/**
 * Created by dllo on 16/10/13.
 */
public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.MyViewHolder> {

    private SectionBean sectionBean;

    public void setSectionBean(SectionBean sectionBean) {
        this.sectionBean = sectionBean;
    }

    @Override
    public SectionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindpage_r_sec_channels, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(SectionAdapter.MyViewHolder holder, int position) {

        String img_url = sectionBean.getData().getColumns().get(position).getBanner_image_url();
        Glide.with(MyApp.getmContext())
                .load(img_url)
                .into(holder.imageView);

        String title = sectionBean.getData().getColumns().get(position).getTitle();
        holder.title.setText(title);

        String author = sectionBean.getData().getColumns().get(position).getAuthor();
        holder.author.setText(author);

    }

    @Override
    public int getItemCount() {
        return sectionBean.getData().getColumns().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView title;
        private final TextView author;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.kindpage_r_sec_cha_img);
            title = (TextView) itemView.findViewById(R.id.kindpage_r_sec_cha_title);
            author = (TextView) itemView.findViewById(R.id.kindpage_r_sec_cha_authro);

        }
    }
}
