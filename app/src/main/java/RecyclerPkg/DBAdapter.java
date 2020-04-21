package RecyclerPkg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagesqlite.R;

import java.util.ArrayList;

public class DBAdapter extends RecyclerView.Adapter<DBAdapter.DBViewHolder> {
ArrayList<DBModelClass> objDbModelclasArrayList;

    public DBAdapter(ArrayList<DBModelClass> objDbModelclasArrayList) {
        this.objDbModelclasArrayList = objDbModelclasArrayList;
    }

    @NonNull
    @Override
    public DBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View siglerow= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row,parent,false);

return new DBViewHolder(siglerow);
    }

    @Override
    public void onBindViewHolder(@NonNull DBViewHolder holder, int position) {
DBModelClass objDBModelClass=objDbModelclasArrayList.get(position);
holder.imageDesTV.setText(objDBModelClass.getImageDes());
holder.ourimageTv.setImageBitmap((objDBModelClass.getOurImage()));
    }

    @Override
    public int getItemCount() {
        return objDbModelclasArrayList.size();
    }

    public static class DBViewHolder extends RecyclerView.ViewHolder
    {
        TextView imageDesTV;
        ImageView ourimageTv;
        public DBViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDesTV=itemView.findViewById(R.id.sr_imageDes);
            ourimageTv=itemView.findViewById(R.id.item_Image_id);
        }
    }
}
