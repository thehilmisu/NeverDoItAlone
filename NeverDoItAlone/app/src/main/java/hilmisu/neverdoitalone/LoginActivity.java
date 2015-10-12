package hilmisu.neverdoitalone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LoginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button startAnimation =(Button) findViewById(R.id.button1);
        final LinearLayout LoginBox = (LinearLayout) findViewById(R.id.LoginBox);
        LoginBox.setVisibility(View.GONE);
        startAnimation.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Animation animTranslate  = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.translate);
                animTranslate.setAnimationListener(new AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation arg0) { }

                    @Override
                    public void onAnimationRepeat(Animation arg0) { }

                    @Override
                    public void onAnimationEnd(Animation arg0) {
                        LoginBox.setVisibility(View.VISIBLE);
                        Animation animFade  = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fade);
                        LoginBox.startAnimation(animFade);
                    }
                });
                ImageView imgLogo = (ImageView) findViewById(R.id.imageView1);
                imgLogo.startAnimation(animTranslate);

            }
        });


    }



}

