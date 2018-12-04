package piesat.cn.wanandroid.view.main.home;

import android.support.v4.app.Fragment;

import piesat.cn.wanandroid.R;
import piesat.cn.wanandroid.base.BaseFragment;

/**
 * 作者：wangyi
 * <p>  主页面Fragment
 * 邮箱：wangyi@piesat.cn
 */
public class HomeFragment extends BaseFragment {
    public static Fragment getInstance() {
        return new HomeFragment();
    }

    /**
     * Base基类的回调方法
     */
    @Override
    public int getLayoutResID() {
        return R.layout.fragment_hone;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initUI() {

    }
}
