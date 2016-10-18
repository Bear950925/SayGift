package dla.saygift.kindpage.raiders;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dla.saygift.R;
import dla.saygift.hompage.channels.ChannelsAdapter;

/**
 * Created by dllo on 16/10/13.
 */
public class KPRaidersAdapter extends RecyclerView.Adapter{

    private SectionBean sectionBean;
    private ChannelsBea channelsBea;
    private String title;

    public void setChannelsBea(ChannelsBea channelsBea) {
        this.channelsBea = channelsBea;
    }

    private Context context;

    public void setSectionBean(SectionBean sectionBean) {
        this.sectionBean = sectionBean;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;
        context = parent.getContext();

        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindpage_r_section, parent, false);
                holder = new SectionViewHolder(view);
                break;
            default:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindpage_r_channels, parent, false);
                holder = new ChannelsViewHolder(view1);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        switch (position) {
            case 0:

                SectionViewHolder viewHolder = (SectionViewHolder) holder;
                SectionAdapter sectionAdapter = new SectionAdapter();
                sectionAdapter.setSectionBean(sectionBean);

                GridLayoutManager manager = new GridLayoutManager(context, 3);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);

                viewHolder.recyclerView.setLayoutManager(manager);
                viewHolder.recyclerView.setAdapter(sectionAdapter);

                viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, AllSectionActivity.class);
                        context.startActivity(intent);
                    }
                });


                break;
            default:

                final ChannelsViewHolder channelsViewHolder = (ChannelsViewHolder) holder;
                KpChannelsAdapter kpChannelsAdapter = new KpChannelsAdapter();
                kpChannelsAdapter.setChannelsBea(channelsBea);
                kpChannelsAdapter.setPositions(position - 1);

                GridLayoutManager manager1 = new GridLayoutManager(context, 2);

                channelsViewHolder.recyclerView.setLayoutManager(manager1);
                channelsViewHolder.recyclerView.setAdapter(kpChannelsAdapter);
                if (1 == position) {
                    title = new String("品类");
                    channelsViewHolder.title.setText(title);
                } else if (2 == position) {
                    title = new String("风格");
                    channelsViewHolder.title.setText(title);
                } else if (3 == position) {
                    title = new String("对象");
                    channelsViewHolder.title.setText(title);
                }

                channelsViewHolder.all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, AllChannelsActivity.class);
                        List<ChannelsBea.DataBean.ChannelGroupsBean.ChannelsBean> beans = channelsBea.getData().getChannel_groups().get(position - 1).getChannels();
                        ArrayList<String> imgUrls = new ArrayList<>();
                        Log.d("KPRaidersAdapter", "beans.size():" + beans.size());
                        for (int i = 0; i < beans.size(); i++) {
                            imgUrls.add(beans.get(i).getCover_image_url());
                        }
                        imgUrls.add(title);
                        intent.putStringArrayListExtra("channelsBea", imgUrls);
                        context.startActivity(intent);
                        Log.d("KPRaidersAdapter", "position:" + position);
                    }
                });

                break;
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    private class SectionViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;
        private final TextView textView;

        public SectionViewHolder(View view) {
            super(view);
            recyclerView = (RecyclerView) view.findViewById(R.id.kindpage_r_section_rv);
            textView = (TextView) view.findViewById(R.id.kindpage_r_section_tv);
        }
    }

    private class ChannelsViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;
        private final TextView all;
        private final TextView title;

        public ChannelsViewHolder(View itemView) {
            super(itemView);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.kindpage_r_channels_rv);
            title = (TextView) itemView.findViewById(R.id.kindpage_r_channels_title);
            all = (TextView) itemView.findViewById(R.id.kindpage_r_channels_all);

        }
    }
}
