package myfifebaseprojects.t.firebasetest2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Button button;
   private TextView textView1,textView2,textView3,textView4;
    private EditText editText1,editText2,editText3,editText4;

    private DatabaseReference mdatabase,mdatabase1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button=findViewById(R.id.submit_id);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);

        textView1=findViewById(R.id.name_text);
        /*textView2=findViewById(R.id.roll_no_id);
        textView3=findViewById(R.id.class_id);
        textView4=findViewById(R.id.ade_id);
*/


        mdatabase= FirebaseDatabase.getInstance().getReference();//.chlid
        //mdatabase1= FirebaseDatabase.getInstance().getReference();
/*

        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                String name=dataSnapshot.getValue().toString();
                textView1.setText("Name: "+name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

*/


     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String ed1 = editText1.getText().toString();
             String ed2 = editText2.getText().toString();
             String ed3 = editText3.getText().toString();
             String ed4 = editText4.getText().toString();
             //mdatabase.setValue(ed1);

             HashMap<String,String> dataMap=new HashMap<String,String>();
             dataMap.put("Name",ed1);
             dataMap.put("Roll on",ed2);
             dataMap.put("Class",ed3);
             dataMap.put("Age",ed4);

             mdatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                 @Override
                 public void onComplete( Task<Void> task) {

                     if (task.isSuccessful()){

                         Toast.makeText(getApplicationContext(), "Submitted!", Toast.LENGTH_SHORT).show();
                     }else {
                         Toast.makeText(getApplicationContext(), "Not Submitted!", Toast.LENGTH_SHORT).show();

                     }

                 }
             });

/*
             mdatabase.child("Name").setValue(ed1);
             mdatabase.child("Roll Number").setValue(ed2);
             mdatabase.child("Class").setValue(ed3);
             mdatabase.child("Age").setValue(ed4);*//*

*/

         }
     });




    }
}
