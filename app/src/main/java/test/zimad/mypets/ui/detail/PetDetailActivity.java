package test.zimad.mypets.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.zimad.mypets.R;
import test.zimad.mypets.data.PetInfo;
import test.zimad.mypets.ui.list.PetsListFragment;

public class PetDetailActivity extends AppCompatActivity {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_name)
    TextView tvName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_detail);
        ButterKnife.bind(this);

        PetInfo petInfo = getIntent().getParcelableExtra(PetsListFragment.PET);
        int position  = getIntent().getIntExtra(PetsListFragment.POSITION, 0);
        tvId.setText(String.valueOf(position + 1));
        tvName.setText(petInfo.getTitle());
        Picasso.get()
                .load(petInfo.getUrl())
                .into(img);

    }
}
