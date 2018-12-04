package piesat.cn.wanandroid.view.register;

import piesat.cn.wanandroid.base.baseMvp.BasePre;
import piesat.cn.wanandroid.base.baseMvp.BaseView;
import piesat.cn.wanandroid.data.bean.UserInfo;

/**
 * 作者：wangyi
 * <p>  注册功能接口
 * 邮箱：wangyi@piesat.cn
 */
public class RegisterContract {

    public interface RegisterView extends BaseView{
        void registerOk(UserInfo userInfo);
        void registerErr(String ErrData);
    }

    public interface RPresenter extends BasePre<RegisterView>{
        void register(String username,String password,String repassword);
    }
}
