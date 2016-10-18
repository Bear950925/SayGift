package dla.saygift.start;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import dla.saygift.baseclass.BaseFragmentActivity;
import dla.saygift.R;
import dla.saygift.buildactivity.BuildActivity;

public class StartActivity extends BaseFragmentActivity {

    private ImageView startImg;
    private TextView startTv;

    @Override
    protected int setLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
        startImg = bindView(R.id.startImg);
        startTv = bindView(R.id.start_tv);
    }

    @Override
    public void initData() {
        final MyStartAsyncTask myStartAsyncTask = new MyStartAsyncTask();
        myStartAsyncTask.execute("start");

        startTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), BuildActivity.class);
                startActivity(intent);
                myStartAsyncTask.cancel(true);
            }
        });

    }

    private class MyStartAsyncTask extends AsyncTask<String, Integer, Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            startImg.setBackgroundResource(R.mipmap.start);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {

            for (int i = 5; i > 0; i--) {
                try {
                    publishProgress(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            startTv.setText(values[0] + "s启动");
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            Intent intent = new Intent(getBaseContext(), BuildActivity.class);
            startActivity(intent);
            cancel(true);
        }
    }
}
