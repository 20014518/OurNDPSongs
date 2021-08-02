package sg.edu.rp.c346.id20014518.ourndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> object) {
        super(context, resource, object);

        parent_context = context;
        layout_id = resource;
        songList = object;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvSong = rowView.findViewById(R.id.textViewSong);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
//        TextView tvStars = rowView.findViewById(R.id.textViewStar);
        TextView tvSinger = rowView.findViewById(R.id.textViewSingers);
        ImageView ivNewSong = rowView.findViewById(R.id.imageViewnewsong);
        RatingBar rb = rowView.findViewById(R.id.ratingBar2);

        Song currentSong = songList.get(position);

        tvSong.setText(currentSong.getTitle());
        tvYear.setText((Integer.toString(currentSong.getYearReleased())));
//        tvStars.setText(currentSong.toString());
        tvSinger.setText(currentSong.getSingers());
        rb.setRating(currentSong.getStars());

        if (currentSong.getYearReleased() >= 2019) {
            ivNewSong.setVisibility(View.VISIBLE);
        }
        else {
            ivNewSong.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }

}

