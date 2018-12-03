package piesat.cn.wanandroid.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import piesat.cn.wanandroid.network.NetUtil;
import piesat.cn.wanandroid.network.NetWorkBroadcastReceiver;

/**
 * 作者：wangyi
 * <p>
 * 邮箱：wangyi@piesat.cn
 */
public abstract class BaseFragment extends Fragment implements NetWorkBroadcastReceiver.NetEvent{
    private int netMobile;
    private Unbinder bind;
    protected Activity activity;
    protected MyApplication context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResID(), container,false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        activity = getActivity();
        context = MyApplication.getInstance();
        initUI();
        initData();
    }

    /**
     * 网络改变的监听
     */
    @Override
    public void onNetChange(int netMobile) {
      this.netMobile = netMobile;

        isNetConnect();
    }

    /**
     * 判断有无网络
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if(netMobile == NetUtil.NETWORK_WIFI){
            return true;
        }else if (netMobile == NetUtil.NETWORK_MOBILE) {
            return true;
        }else if (netMobile == NetUtil.NETWORK_NONE) {
            return false;
        }
            return false;
        }

    @Override
    public void onDestroy() {
        bind.unbind();
        super.onDestroy();
    }
    /**
     * 获取 布局信息
     */
    public  abstract int getLayoutResID();
    /**
     * 数据初始化
     */
    protected abstract void initData();
    /**
     * 初始化 ui 布局
     */
    protected abstract void initUI();

}
