package np.com.devish.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetails extends AppCompatActivity {

    ImageView ivProfile;
    TextView tvName, tvPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        ivProfile = findViewById(R.id.imageProfile);
        tvName = findViewById(R.id.textName);
        tvPhone = findViewById(R.id.textClan);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ivProfile.setImageResource(bundle.getInt("image"));
            tvName.setText(bundle.getString("name"));
            tvPhone.setText(bundle.getString("phone"));
        }

    }
}
