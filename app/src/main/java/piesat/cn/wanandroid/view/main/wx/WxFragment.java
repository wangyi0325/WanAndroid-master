package piesat.cn.wanandroid.view.main.wx;

import android.support.v4.app.Fragment;

import piesat.cn.wanandroid.R;
import piesat.cn.wanandroid.base.BaseFragment;

/**
 * 作者：wangyi
 * <p>  公众号Fragment
 * 邮箱：wangyi@piesat.cn
 */
public class WxFragment extends BaseFragment {
    public static Fragment getInstance() {
        return new WxFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_wx;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initUI() {

    }
}
