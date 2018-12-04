package piesat.cn.wanandroid.view;

import android.widget.ImageView;

import com.bumptech.glide.Glide;


import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import piesat.cn.wanandroid.R;
import piesat.cn.wanandroid.base.BaseActivity;
import piesat.cn.wanandroid.util.JumpUtil;
import piesat.cn.wanandroid.view.login.LoginActivity;

public class WelcomeActivity extends BaseActivity {
    @BindView(R.id.iv_splash)
    ImageView imageView;

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        Glide.with(context).load(R.mipmap.splash).into(imageView);
    }

    @Override
    protected void initData() {
        io.reactivex.Observable.timer(1500, java.util.concurrent.TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        JumpUtil.overlay(WelcomeActivity.this, LoginActivity.class);
                        finish();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
           }

   }
