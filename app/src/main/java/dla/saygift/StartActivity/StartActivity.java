package dla.saygift.StartActivity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import dla.saygift.BaseClass.BaseFragmentActivity;
import dla.saygift.R;

public class StartActivity extends BaseFragmentActivity {

    private ImageView startImg;

    @Override
    protected int setLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
        startImg = bindView(R.id.startImg);
    }

    @Override
    public void initData() {
        MyStartAsyncTask myStartAsyncTask = new MyStartAsyncTask();
    }

    private class MyStartAsyncTask extends AsyncTask<String, Integer, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            return null;
        }
    }
}
