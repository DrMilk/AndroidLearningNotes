package com.namewu.androidlearningnotes.onetofivenote;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.namewu.androidlearningnotes.R;
import com.namewu.androidlearningnotes.wuutils.L;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/8/1.
 */

public class TwoNoteAsyncTaskActivity extends Activity{
    private static final String TAG = "TwoNoteAsyncTaskActivit";
    private EditText edit_write;
    private TextView text_show;
    private Button button_ok;
    private MyTask myTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        edit_write= (EditText) findViewById(R.id.activity_two_write);
        text_show = (TextView) findViewById(R.id.activity_two_show);
        button_ok = (Button) findViewById(R.id.activity_two_ok);
        myTask=new MyTask();
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask.execute(edit_write.getText().toString().trim());
            }
        });
    }
    //三种泛型类型分别代表
    // “启动任务执行的输入参数”、
    // “后台任务执行的进度”、
    // “后台计算结果的类型”
    private class MyTask extends AsyncTask<String,Integer,String>{
        /**
         * 该方法在子线程中运行，因此不能有任何修改 UI 操作
         */
        @Override
        protected String doInBackground(String... params) {
            String result = "";
            try {
                L.i(TAG,params[0]);
                URL url =new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(1000*10);
                int code = connection.getResponseCode();
                if(code==200){
                    InputStream is = connection.getInputStream();
                    byte[] buffer= new byte[1024];
                    int len =0;
                    ByteArrayOutputStream bos= new ByteArrayOutputStream();
                    while ((len=is.read(buffer))!=-1){
                        bos.write(buffer,0,len);
                        bos.flush();
                    }
                    result = bos.toString();
                    bos.close();
                    return result;
                }
            } catch (Exception e) {
                e.printStackTrace();
                L.i(TAG,e.toString());
            }
            return "发生错误";
        }

        /**
         * 任务执行前在 UI 线程中调用
         */
        @Override
        protected void onPreExecute() {
            button_ok.setText("开始加载");
            super.onPreExecute();
        }
        /**
         * 任务执行后在 UI 线程中调用<
         * @param result 正是 doInBackground 的返回值
         */
        @Override
        protected void onPostExecute(String result) {
            text_show.setText(result);
            super.onPostExecute(result);
            this.cancel(true);
        }
        /**
         * 在 UI 线程中执行
         * 当 doInBackground 执行 publishProgress 时调用该方法
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            button_ok.setText("当前进度："+values[0]+" %");
        }

    }
}
