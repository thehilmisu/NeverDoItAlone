package hilmisu.neverdoitalone;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.Intent;
import java.net.MalformedURLException;
import java.net.URL;


public class LoginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Button startAnimation =(Button) findViewById(R.id.button1);
        final LinearLayout LoginBox = (LinearLayout) findViewById(R.id.LoginBox);
        LoginBox.setVisibility(View.GONE);
        Animation animTranslate  = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.translate);
        animTranslate.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                LoginBox.setVisibility(View.VISIBLE);
                Animation animFade = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fade);
                LoginBox.startAnimation(animFade);
            }

        });
        ImageView imgLogo = (ImageView) findViewById(R.id.imageView1);
        imgLogo.startAnimation(animTranslate);

        final EditText txtEmail = (EditText)findViewById(R.id.txtEmail);
        final EditText txtPassword = (EditText)findViewById(R.id.txtPassword);

        final Intent i = new Intent(this.getApplicationContext(),MainActivity.class);

        Button btnLogin =(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if((txtEmail.getText().toString().length()>0)&&
                        (txtPassword.getText().toString().length()>0)) {

                    String email=txtEmail.getText().toString();
                    String pass = txtPassword.getText().toString();
                    GetHttpResponse getResponse = new GetHttpResponse();
                    URL u = null;
                    String strUrl = "http://hakanozcan.eu/login.php?email="+email+"&pass="+pass;
                    //Log.d("Login",strUrl);
                    try {
                        u = new URL(strUrl);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    try {
                        //Log.d("Login", getResponse.execute(u).get());
                        if(getResponse.execute(u).get().contains("success")){
                            Log.d("Login","Başarılı login");

                            //intent.putExtra(EXTRA_MESSAGE, message);
                            startActivity(i);

                        }else{
                            Log.d("Login","Kullanıcı adı veya şifre yanlış");
                        }
                    }catch(Exception exc){

                    }

                    //if(getResponse.execute(u).toString()=="success"){
                        //Log.d("Login","Başarılı login");
                    //}else{
                        //Log.d("Login","Kullanıcı adı veya şifre yanlış");
                    //}
                }else{
                    Log.d("Login","Kullanıcı adı veya şifre boş");
                }
            }
        });



    }



}
