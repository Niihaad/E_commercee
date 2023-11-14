package ma.ensaf.e_commercee;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private String[] titre = {"tous", "Gauche", "Droit"};
    private String[] descr = {"tous1", "Gauche2", "Droit3"};
    private Integer[] images = {R.drawable.caftan3, R.drawable.caftan10, R.drawable.caftan11};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custem_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.textView.setText(titre[position]);
        holder.textView2.setText(descr[position]);
    }

    public void setData(Integer[] images, String[] titles, String[] descriptions) {
        this.images = images;
        this.titre = titles;
        this.descr = descriptions;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ImageView);
            textView = itemView.findViewById(R.id.titre);
            textView2 = itemView.findViewById(R.id.description);
        }
    }
}
