package piesat.cn.wanandroid.view.register;


import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import piesat.cn.wanandroid.base.baseMvp.BasePresenter;
import piesat.cn.wanandroid.data.BaseResp;
import piesat.cn.wanandroid.data.bean.UserInfo;
import piesat.cn.wanandroid.model.ApiService;
import piesat.cn.wanandroid.model.ApiStore;
import piesat.cn.wanandroid.util.ConstantUtil;

/**
 * 作者：wangyi
 * <p>  注册功能的Persenter
 * 邮箱：wangyi@piesat.cn
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.RegisterView> implements RegisterContract.RPresenter {
    private RegisterContract.RegisterView registerView;

    public RegisterPresenter( RegisterContract.RegisterView registerView) {
        super();
        this.registerView = registerView;
    }

    @Override
    public void register(String username, String password, String repassword) {
        ApiStore.createApi(ApiService.class)
                .register(username,password,repassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<UserInfo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResp<UserInfo> userInfoBaseResp) {
                         if(userInfoBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                             registerView.registerOk(userInfoBaseResp.getData());
                         }else if(userInfoBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                             registerView.registerErr(userInfoBaseResp.getErrorMsg());
                         }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(e.getMessage() != null){
                            registerView.registerErr(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
