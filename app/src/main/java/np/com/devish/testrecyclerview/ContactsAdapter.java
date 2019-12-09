package np.com.devish.testrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import de.hdodenhof.circleimageview.CircleImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>{
    Context mContext;
    List<Contacts> contactsList;

    public ContactsAdapter(Context mContext, List<Contacts> contactsList){
        this.mContext = mContext;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactview, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        final Contacts contacts = contactsList.get(position);
        holder.imgProfile.setImageResource(contacts.getImageId());
        holder.tvName.setText(contacts.getName());
        holder.tvClan.setText(contacts.getPhoneNo());

        // Adding Click Listner in an image view
        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ContactDetails.class);
                intent.putExtra("image", contacts.getImageId());
                intent.putExtra("name", contacts.getName());
                intent.putExtra("phone", contacts.getPhoneNo());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
       return contactsList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;
        TextView tvName, tvClan;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imageProfile);
            tvName= itemView.findViewById(R.id.textName);
            tvClan= itemView.findViewById(R.id.textClan);
        }
    }
}
