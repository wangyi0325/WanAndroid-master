package piesat.cn.wanandroid.view.login;


import io.reactivex.Observer;
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
 * <p>  登陆功能的Persenter
 * 邮箱：wangyi@piesat.cn
 */
public class LoginPresenter extends BasePresenter<LoginContract.LoginView> implements LoginContract.LPresenter {
    LoginContract.LoginView view;

    public LoginPresenter(LoginContract.LoginView loginView){
        this.view = loginView;
    }

    @Override
    public void login(String userName, String userPassworld) {
        ApiStore.createApi(ApiService.class)
                .login(userName,userPassworld)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<UserInfo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResp<UserInfo> userInfoBaseResp) {
               if(userInfoBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                   view.loginOk(userInfoBaseResp.getData());
               }else if(userInfoBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                   view.loginErr(userInfoBaseResp.getErrorMsg());
                }
            }

            @Override
            public void onError(Throwable e) {
             if(e.getMessage() != null){
                 view.loginErr(e.getMessage());
             }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
