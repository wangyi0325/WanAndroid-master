package piesat.cn.wanandroid.view.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Field;

import piesat.cn.wanandroid.R;
import piesat.cn.wanandroid.base.BaseActivity;


public class MainActivity extends BaseActivity {

    private TextView mTextMessage;
   /**
    *Base基类的回调方法
    */
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void initData() {

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_system:
                    mTextMessage.setText(R.string.title_system);
                    return true;
                case R.id.navigation_wx:
                    mTextMessage.setText(R.string.title_wx);
                    return true;
                case R.id.navigation_demo:
                    mTextMessage.setText(R.string.title_demo);
                    return true;
                case R.id.navigation_mine:
                    mTextMessage.setText(R.string.title_mine);
                    return true;
            }
            return false;
        }
    };



    /**
     *取消BottomNavigationView的点击动画
     */
    public static class BottomNavigationViewHelper {

        @SuppressLint("RestrictedApi")
        public static void disableShiftMode(BottomNavigationView view) {
            //获取子View BottomNavigationMenuView的对象
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
            try {
                //设置私有成员变量mShiftingMode可以修改
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                shiftingMode.setAccessible(true);
                shiftingMode.setBoolean(menuView, false);
                shiftingMode.setAccessible(false);
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                    //去除shift效果
                    item.setShiftingMode(false);
                    item.setChecked(item.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                Log.e("BNVHelper", "没有mShiftingMode这个成员变量", e);
            } catch (IllegalAccessException e) {
                Log.e("BNVHelper", "无法修改mShiftingMode的值", e);
            }
        }
    }
}
