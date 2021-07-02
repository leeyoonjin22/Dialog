package com.example.day2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4;
    int selectedMenu=0;
    boolean checked[] = {true,true,false};
    String menu[] = {"치킨", "피자", "스파게티"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
private void init(){
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
    b3 = findViewById(R.id.button3);
    b4 = findViewById(R.id.button4);

    b1.setOnClickListener(this);//리스너를 세팅해주는! 온클릭 리스너 사용하기전에 선언,생성 비슷한것
    b2.setOnClickListener(this);
    b3.setOnClickListener(this);
    b4.setOnClickListener(this);

}
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button1){
            displayDialog();
        }
    }

    private void displayDialog2(){
       // String menu[] = {"치킨", "피자", "스파게티"};
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자 2");
     dlg.setSingleChoiceItems(menu, selectedMenu, new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialogInterface, int which) {

         }
     });
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                displayToast(menu[selectedMenu]+"가 선택되었습니다! ");
            }
        });
        dlg.show();
    }

    private void displayDialog(){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자 1");
        dlg.setMessage("대화상자 메시지 입니다");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                displayToast(null);
            }
        });
        dlg.show();
    }

    private void displayDialog3(){

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본대화상자 3");
        dlg.setMultiChoiceItems(menu, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                checked[which] = isChecked;
            }
        });
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String list = ""; //반복문을 이용해 체크박스 체크된 것 출력하는 문장 추가 **
                for(int i=0; i<checked.length; i++) if(checked[i])  list = list+" "+ menu[i];
                displayToast(list+" 선택되었습니다! ");
            }
        });
        dlg.show();
    }
    private void displayDialog4(){
        View view = View.inflate(this,R.layout.dialog,null);
        final EditText editText = view.findViewById(R.id.etMsg);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("사용자 정의 대화상자");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setView(view);
        dlg.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dlg.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dlg.show();
    }

    private void displayToast(String msg){
        if(msg==null) msg = "OK! Clicked! ";
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}