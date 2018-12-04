package piesat.cn.wanandroid.view.main.system;

import android.support.v4.app.Fragment;

import piesat.cn.wanandroid.R;
import piesat.cn.wanandroid.base.BaseFragment;

/**
 * 作者：wangyi
 * <p>  体系的Fragment
 * 邮箱：wangyi@piesat.cn
 */
public class SystemFragment extends BaseFragment {
    public static Fragment getInstance() {
        return new SystemFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_system;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initUI() {

    }
}
