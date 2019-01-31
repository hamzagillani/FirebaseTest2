package myfifebaseprojects.t.firebasetest2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText1,editText2,editText3,editText4;

    private DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button=findViewById(R.id.submit_id);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);


        mdatabase= FirebaseDatabase.getInstance().getReference();

     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String ed1 = editText1.getText().toString();
             String ed2 = editText2.getText().toString();
             String ed3 = editText3.getText().toString();
             String ed4 = editText4.getText().toString();

             mdatabase.child("Name").setValue(ed1);
             mdatabase.child("Roll Number").setValue(ed2);
             mdatabase.child("Class").setValue(ed3);
             mdatabase.child("Age").setValue(ed4);




             Toast.makeText(getApplicationContext(), "Submitted!", Toast.LENGTH_SHORT).show();
         }
     });

    }
}
