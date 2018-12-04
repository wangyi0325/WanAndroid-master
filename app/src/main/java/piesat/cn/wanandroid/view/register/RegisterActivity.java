package piesat.cn.wanandroid.view.register;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import piesat.cn.wanandroid.R;
import piesat.cn.wanandroid.base.BaseActivity;
import piesat.cn.wanandroid.data.bean.UserInfo;
import piesat.cn.wanandroid.util.JumpUtil;
import piesat.cn.wanandroid.util.toast.ToastUtil;
import piesat.cn.wanandroid.view.login.LoginActivity;

/**
 * 作者：wangyi
 * <p>  注册页面
 * 邮箱：wangyi@piesat.cn
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.RegisterView{
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_ensure_password)
    EditText et_ensure_password;
    @BindView(R.id.btn_register)
    Button btn_register;
    private RegisterPresenter presenter;
    private String userName;
    private String passWord;
    private String ensurePassword;

    /**
    *数据，布局，控件初始化
    */
    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter = new RegisterPresenter(this);
    }

    @OnClick({R.id.btn_register})
    public void click(View v){
        if(checkRegisterMsg()){
            presenter.register(userName,passWord,ensurePassword);
        }
    }

    private boolean checkRegisterMsg() {
        userName = et_username.getText().toString().trim();
        passWord = et_password.getText().toString().trim();
        ensurePassword = et_ensure_password.getText().toString().trim();
        if (userName.length() < 6 || passWord.length() < 6) {
            ToastUtil.show(context, getString(R.string.username_incorrect));
            return false;
        } else if (!passWord.equals(ensurePassword)) {
            ToastUtil.show(context, getString(R.string.password_incorrect));
            return false;
        }
        return true;
    }
    /**
     *Base初始化方法
     */
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

    /**
     *请求响应结果回调方法
     */
    @Override
    public void registerOk(UserInfo userInfo) {
       ToastUtil.show(this,"注册成功");
        JumpUtil.overlay(context, LoginActivity.class);
        finish();
    }

    @Override
    public void registerErr(String ErrData) {
      ToastUtil.show(this,ErrData);
    }
}
