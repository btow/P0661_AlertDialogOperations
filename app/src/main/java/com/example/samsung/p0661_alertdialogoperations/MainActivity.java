package com.example.samsung.p0661_alertdialogoperations;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.DialogInterface.*;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    final int DIALOG = 1;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == DIALOG) {
            Log.d(LOG_TAG, getString(R.string.create_dialog));
            Toast.makeText(this, getString(R.string.create_dialog),
                    Toast.LENGTH_SHORT).show();
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle(R.string.dialog_title);
            adb.setMessage(getString(R.string.create_dialog));
            adb.setPositiveButton(R.string.dialog_btn_ok, null);
            dialog = adb.create();

            //Обработка отображения
            dialog.setOnShowListener(new OnShowListener() {
                @Override
                public void onShow(DialogInterface dialog) {
                    Log.d(LOG_TAG, getString(R.string.dialog_show));
                    Toast.makeText(getBaseContext(), getString(R.string.dialog_show),
                            Toast.LENGTH_SHORT).show();
                }
            });
            //Обработка отмены
            dialog.setOnCancelListener(new OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    Log.d(LOG_TAG, getString(R.string.dialog_cancel));
                    Toast.makeText(getBaseContext(), getString(R.string.dialog_show),
                            Toast.LENGTH_SHORT).show();
                }
            });
            //Обработка закрытия
            dialog.setOnDismissListener(new OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    Log.d(LOG_TAG, getString(R.string.dialog_dismiss));
                    Toast.makeText(getBaseContext(), getString(R.string.dialog_dismiss),
                            Toast.LENGTH_SHORT).show();
                }
            });
            return dialog;
        }
        return super.onCreateDialog(id);
    }

    void method1() {
//        dialog.dismiss();
//        dialog.cancel();
//        dialog.hide();
//        dismissDialog(DIALOG);
        removeDialog(DIALOG);
    }

    void method2() {
        showDialog(DIALOG);
    }

    public void onClickButton(View view) {
        showDialog(DIALOG);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        }, 2000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                method2();
            }
        }, 4000);
    }
}
