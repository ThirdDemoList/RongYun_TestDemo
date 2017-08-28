package demo.mark.com.rongyun_testdemo.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;

import demo.mark.com.rongyun_testdemo.R;
import io.rong.imkit.RongIM;

/**
 *  @author mark
 *  @time 2017/8/20  20:38
 *  @describe
 */
public class ConversationActivity extends FragmentActivity {

    private TextView mName;
    private ImageView iv_back_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        StatusBarCompat.setStatusBarColor(this,getResources().getColor(R.color.actionbar_bg));
        intView();
    }

    private void intView() {
        mName = (TextView) findViewById(R.id.name);
        iv_back_left = (ImageView) findViewById(R.id.iv_back_left);

        iv_back_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String sId = getIntent().getData().getQueryParameter("targetId");//targetId:单聊即对方ID，群聊即群组ID
        String sName = getIntent().getData().getQueryParameter("title");//获取昵称

        if (!TextUtils.isEmpty(sName)){
            mName.setText(sName);
        }else {
//            sId
            //TODO 拿到id 去请求自己服务端
        }
    }
}
