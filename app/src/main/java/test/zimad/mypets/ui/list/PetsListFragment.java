package test.zimad.mypets.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.zimad.mypets.R;
import test.zimad.mypets.data.PetInfo;
import test.zimad.mypets.ui.adapter.PetsAdapter;
import test.zimad.mypets.ui.detail.PetDetailActivity;

public class PetsListFragment extends Fragment implements PetsContract.IPetsView {
    public static final String PET = "pet";
    public static final String POSITION = "position";
    @BindView(R.id.rv)
    RecyclerView rv;
    private PetsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list, container, false);
        ButterKnife.bind(this, view);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PetsAdapter((item, pos) -> {
            Intent intent = new Intent(getActivity(), PetDetailActivity.class);
            intent.putExtra(PET, item);
            intent.putExtra(POSITION, pos);
            PetsListFragment.this.startActivity(intent);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PetsPresenter presenter = new PetsPresenter(this);
        presenter.readPets(getArguments().getString(PET));
    }


    @Override
    public void showPets(ArrayList<PetInfo> pets) {
        adapter.setPetInfos(pets);
        rv.setAdapter(adapter);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }
}
