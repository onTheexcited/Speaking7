package cn.edu.bistu.cs.se.speaking7;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button) findViewById(R.id.ButtonTest);
        Button button=(Button) findViewById(R.id.ButtonTest2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("你喜欢看《三国演义》吗？");
                builder.setTitle("问题");
                builder.setPositiveButton("喜欢",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which) {
                        Toast.makeText(MainActivity.this, "你选择了喜欢", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("不喜欢",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        Toast.makeText(MainActivity.this,"你选择了不喜欢",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("忽略",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        Toast.makeText(MainActivity.this,"你选择了忽略",Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });//提示对话框
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater=getLayoutInflater();
                inflater.inflate(R.layout.login_dialog,null);
                final View v=inflater.inflate(R.layout.login_dialog,null);
                builder.setView(v );

                builder.setTitle("login");

                builder.setPositiveButton(R.string.login,new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id) {
                         EditText edt1=(EditText) v.findViewById(R.id.userId);
                         EditText edt2=(EditText) v.findViewById(R.id.passwort);
                        String user = edt1.getText().toString();
                        String pass = edt2.getText().toString();
                        if("abc".equals(user) && "123".equals(pass)){
                            Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {


                    }
                });
               builder.show();
            }
        });
    }
}
