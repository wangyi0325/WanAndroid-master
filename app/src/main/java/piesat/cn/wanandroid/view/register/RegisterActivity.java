package piesat.cn.wanandroid.view.register;

import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import piesat.cn.wanandroid.R;
import piesat.cn.wanandroid.base.BaseActivity;

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
    public void registerOk(String Data) {

    }

    @Override
    public void registerErr(String ErrData) {

    }
}
