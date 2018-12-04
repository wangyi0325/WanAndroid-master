package piesat.cn.wanandroid.view.main;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import piesat.cn.wanandroid.R;
import piesat.cn.wanandroid.base.BaseActivity;
import piesat.cn.wanandroid.view.main.home.HomeFragment;
import piesat.cn.wanandroid.view.main.mine.MineFragment;
import piesat.cn.wanandroid.view.main.project.ProjectFragment;
import piesat.cn.wanandroid.view.main.system.SystemFragment;
import piesat.cn.wanandroid.view.main.wx.WxFragment;

/**
 * 作者：wangyi
 * <p>  主页面的Activity
 * 邮箱：wangyi@piesat.cn
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.fl_layout)
    FrameLayout frameLayout;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private TextView mTextMessage;
    private List<Fragment> fragmentList;
    private int lastIndex;

    /**
    *Base基类的回调方法
    */
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragment();
        selectFragment(0);
    }

    @Override
    protected void initData() {

    }

  /**
   *初始化Fragment
   */
    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.getInstance());
        fragmentList.add(SystemFragment.getInstance());
        fragmentList.add(WxFragment.getInstance());
        fragmentList.add(ProjectFragment.getInstance());
        fragmentList.add(MineFragment.getInstance());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectFragment(0);
                    return true;
                case R.id.navigation_system:
                    selectFragment(1);
                    return true;
                case R.id.navigation_wx:
                    selectFragment(2);
                    return true;
                case R.id.navigation_demo:
                    selectFragment(3);
                    return true;
                case R.id.navigation_mine:
                    selectFragment(4);
                    return true;
            }
            return false;
        }
    };

    private void selectFragment(int i) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = fragmentList.get(i);
        Fragment lastFragment = fragmentList.get(lastIndex);
        lastIndex = i;
        transaction.hide(lastFragment);
        if(!fragment.isAdded()){
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            transaction.add(R.id.fl_layout, fragment);
        }
         transaction.show(fragment);
         transaction.commitAllowingStateLoss();
    }



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
