package com.example.baitaptuan8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    DataUser dataUser;
    Button add_btn,remove_btn;
    EditText name_edt;
    ListView lvUser;
    ArrayList nameList;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataUser=new DataUser(this,"userdb.sqlite",
                                            null,1);

        dataUser.addUser(new User("Do Anh Bon"));
        dataUser.addUser(new User("Pham Quoc Cuong"));
        dataUser.addUser(new User("Nguyen Anh Dung"));
        dataUser.addUser(new User("Chau Hoang Duy"));
        dataUser.addUser(new User("Tran Nhat Duy"));
        dataUser.addUser(new User("Nguyen Dinh Hao"));
        dataUser.addUser(new User("Do Anh Bon"));
        dataUser.addUser(new User("Pham Quoc Cuong"));
        dataUser.addUser(new User("Nguyen Anh Dung"));
        dataUser.addUser(new User("Chau Hoang Duy"));
        dataUser.addUser(new User("Tran Nhat Duy"));
        dataUser.addUser(new User("Nguyen Dinh Hao"));
        dataUser.addUser(new User("Chau Hoang Duy"));

        name_edt=findViewById(R.id.name_edt);
        add_btn=findViewById(R.id.add_btn);
        remove_btn=findViewById(R.id.remove_btn);
        lvUser=findViewById(R.id.user_lv);


        nameList=new ArrayList();

        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                                                nameList);
        nameList=getNameList();
        lvUser.setAdapter(arrayAdapter);
    }
    private ArrayList getNameList(){
        ArrayList<String> namStrings=new ArrayList<>();
        for (Iterator iterator = dataUser.getAllUsers().iterator(); iterator.hasNext(); ) {
            User user = (User) iterator.next();
            nameList.add(user.getName());
        }
        return nameList;
    }
}