package piesat.cn.wanandroid.view.login;

import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import piesat.cn.wanandroid.R;
import piesat.cn.wanandroid.base.BaseActivity;
import piesat.cn.wanandroid.data.bean.UserInfo;
import piesat.cn.wanandroid.util.toast.ToastUtil;

/**
 * 作者：wangyi
 * <p>  登陆页面
 * 邮箱：wangyi@piesat.cn
 */
public class LoginActivity extends BaseActivity implements LoginContract.LoginView {
    @BindView(R.id.et_ensure_username)
    EditText et_username;
    @BindView(R.id.et_ensure_password)
    EditText et_password;
    private LoginContract.LPresenter loginPresenter;
    private String username;
    private String password;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        loginPresenter = new LoginPresenter(this);

    }

    @Override
    protected void initData() {
    }

    @OnClick({R.id.btn_login,R.id.tv_register})
     void click(View view){
        switch(view.getId()){
            case R.id.btn_login:
                if(check()){
                    loginPresenter.login(username,password);
                 }
                break;
            case R.id.tv_register:
                //跳转注册页面
                break;
        }
    }

    private boolean check() {
        username = et_username.getText().toString().trim();
        password = et_password.getText().toString().trim();
        if (username.length() < 6 || password.length() < 6) {
            ToastUtil.show(context, getString(R.string.username_incorrect));
            return false;
        }
        return true;
    }
    @Override
    public void showNormal() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void loginOk(UserInfo userInfo) {
        ToastUtil.show(context, "成功");
    }

    @Override
    public void loginErr(String errData) {
        ToastUtil.show(context,errData);

    }
}
