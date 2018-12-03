package piesat.cn.wanandroid.view.login;

import piesat.cn.wanandroid.base.baseMvp.BasePre;
import piesat.cn.wanandroid.base.baseMvp.BaseView;
import piesat.cn.wanandroid.data.bean.UserInfo;

/**
 * 作者：wangyi
 * <p>  登陆的接口页面
 * 邮箱：wangyi@piesat.cn
 */
public class LoginContract {

    public interface LoginView extends BaseView{
        void loginOk(UserInfo userInfo);
        void loginErr(String errData);
    }

    public interface LPresenter extends BasePre<LoginView>{
        void login(String userName,String userPassworld);
    }
}
