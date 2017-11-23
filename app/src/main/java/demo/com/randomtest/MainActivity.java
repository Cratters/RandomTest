package demo.com.randomtest;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    String TAG = "RandomTest";
    int rand,sum = 0;
    int[] mobsRarity = {0,1,1,200};
    int cId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i<mobsRarity.length; i++) {
            sum += mobsRarity[i];
        }
        Log.d(TAG,"SUM : " + sum);

        rand = (int)(Math.random()*sum)+1;

        Log.d(TAG,"RAND : " + rand);

        for (int i = 0; i<mobsRarity.length; i++) {

            rand -= mobsRarity[i];
            Log.d(TAG,"-= mobsRarity[" + i + "] :" + rand);
            if ( rand <= 0) {
                cId = i;
                break;
            }
        }

        Log.d(TAG,"cId : " + cId);
    }

    @Override
    public void onBackPressed() {  //返回鍵事件
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("確認視窗");
        builder.setMessage("確定要結束應用程式嗎?");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("確定",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                });
        builder.show();
    }
}
