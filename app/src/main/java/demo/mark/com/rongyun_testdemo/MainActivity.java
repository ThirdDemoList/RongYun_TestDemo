package demo.mark.com.rongyun_testdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo.mark.com.rongyun_testdemo.db.Friend;
import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //悟空  18673668974
    private static final String token1 = "PTN756h7DshRJ05jNZIZfaQdqRjXPxjRvvfA3+ePanzAzBIxT7Kg9+AnH7+IRqfXhgkSwIjSEssSdXtexbBaqqwUB6ghFEYt";
    //贝吉塔 18673668975
    private static final String token2 = "5XkgJVCwx26gxXzd4iobIf+M+CgaVL90/jYefz1rGXLBBSUuiWGdDGMW4dot1d8fXe8YAHUdNi+P+/yW52wcZ75RIvnbe2FK";
    //希特 18673668976
    private static final String token3 = "cvNCXeddIrPDzXzefQStIaQdqRjXPxjRvvfA3+ePanzAzBIxT7Kg93AUODUYrZbbWX68OpMOv3kSdXtexbBaqk26osytl8E1";
    //希特 18673668977
    private static final String token4 = "IZEXNgMvIxk2kvcCxml0N8LT+pQFu7N+egPdN9Va1Qft3FjGI6N1vO7JphEPspdvATIg7OXnV0SJZh1oZ+yBX6RLwRniBQeF";

    private List<Friend> userIdList;
    private static final String TAG = "MainActivity";

    //悟空、贝吉塔、希特、比克
    private Button mUser1, mUser2,mUser3,mUser4;
    //会话列表、聊天室
    private Button rc_conversation_list,rc_conversation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser1 = (Button) findViewById(R.id.connect_wk);
        mUser2 = (Button) findViewById(R.id.connect_btt);
        mUser3 = (Button) findViewById(R.id.connect_xt);
        mUser4 = (Button) findViewById(R.id.connect_bk);

        /*****************列表和聊天室**********************/
        rc_conversation_list = (Button) findViewById(R.id.rc_conversation_list);
        rc_conversation = (Button) findViewById(R.id.rc_conversation);

        mUser1.setOnClickListener(this);
        mUser2.setOnClickListener(this);
        mUser3.setOnClickListener(this);
        mUser4.setOnClickListener(this);
        rc_conversation.setOnClickListener(this);
        rc_conversation_list.setOnClickListener(this);

        //初始化用户信息
        initUserInfo();

    }

    //链接融云服务器
    private void connectRongServer(String token) {
        if (getApplicationInfo().packageName
                .equals(App.getCurProcessName(getApplicationContext()))) {
            RongIM.connect(token, new RongIMClient.ConnectCallback() {
                @Override
                public void onSuccess(String userId) {

                    if (userId.equals("18673668974")) {
                        Toast.makeText(MainActivity.this, "connect server success 悟空", Toast.LENGTH_SHORT).show();
                    } else if (userId.equals("18673668975")){
                        Toast.makeText(MainActivity.this, "connect server success 贝吉塔", Toast.LENGTH_SHORT).show();
                    }else if(userId.equals("18673668976")) {
                        Toast.makeText(MainActivity.this, "connect server success 希特", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "connect server success 比克", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    // Log.e("onError", "onError userid:" + errorCode.getValue());//获取错误的错误码
                    Log.e(TAG, "connect failure errorCode is : " + errorCode.getValue());
                }

                @Override
                public void onTokenIncorrect() {
                    Log.e(TAG, "token is error ,please check token and appkey");
                }
            });
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.connect_wk:
                connectRongServer(token1);
                break;
            case R.id.connect_btt:
                connectRongServer(token2);
                break;
            case R.id.connect_xt:
                connectRongServer(token3);
                break;
            case R.id.connect_bk:
                connectRongServer(token4);
                break;
            case R.id.rc_conversation://我要和悟空聊天
                /**
                 * 启动单聊
                 * context - 应用上下文。
                 * targetUserId - 要与之聊天的用户 Id。
                 * title - 聊天的标题，如果传入空值，则默认显示与之聊天的用户名称。
                 */
                if (RongIM.getInstance() != null) {
                    RongIM.getInstance().startPrivateChat(this, "18673668974", "悟空");
                }
                break;
            case R.id.rc_conversation_list:
                startActivity(new Intent(this,HomeActivity.class));
              /*  if (RongIM.getInstance() != null) {
                    RongIM.getInstance().startConversationList(this);
                }*/
                break;
        }
    }

    //初始化用户信息
    private void initUserInfo() {
        userIdList = new ArrayList<Friend>();
        userIdList.add(new Friend("18673668974", "悟空", "http://pic1.win4000.com/pic/c/87/866c1411319.jpg"));//悟空图标
        userIdList.add(new Friend("18673668975", "贝吉塔", "http://pic1.win4000.com/pic/e/f1/4fb01408746.jpg"));//贝吉塔图标
        userIdList.add(new Friend("18673668976", "希特", "http://imgsrc.baidu.com/forum/w%3D580/sign=eefd92535082b2b7a79f39cc01accb0a/994fbd4bd11373f0cdbb65c8ad0f4bfbfaed04e8.jpg"));//希特图标
        userIdList.add(new Friend("18673668977", "比克", "http://pic1.win4000.com/pic/f/63/088a1410587.jpg"));//比克图标
        userIdList.add(new Friend("KEFU144542424649464","海马客服","http://img02.tooopen.com/Download/2010/5/22/20100522103223994012.jpg"));
//        RongIM.setUserInfoProvider(this, true);
         /**
          * 设置用户信息的提供者，供 RongIM 调用获取用户名称和头像信息。
          * */
         RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {

             /**
              * 用户信息的提供者
              *
              * 融云会话界面 和 会话列表的 头像 昵称展示
              * */
             @Override
             public UserInfo getUserInfo(String userId) {
                 for (Friend i : userIdList) {
                     if (i.getUserId().equals(userId)) {
                         Log.e(TAG, i.getPortraitUri());
                         //根据 userId 去你的用户系统里查询对应的用户信息返回给融云 SDK。
                         return new UserInfo(i.getUserId(), i.getName(),Uri.parse(i.getPortraitUri()));
                     }
                 }
                 Log.e("MainActivity", "UserId is : " + userId);
                 return null;
             }

         },true);
    }

}
