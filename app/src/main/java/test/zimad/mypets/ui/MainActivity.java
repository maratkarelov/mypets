package test.zimad.mypets.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.zimad.mypets.R;
import test.zimad.mypets.ui.list.PetsListFragment;

public class MainActivity extends AppCompatActivity {
    private static final String CURRENT_TAB_POS = "current_tab_pos";
    private FragmentManager fragmentManager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String tag = (String) tab.getText();
                showFragment(tag);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                String tag = (String) tab.getText();
                Fragment fragment = fragmentManager.findFragmentByTag(tag);
                if(fragment != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.hide(fragment);
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        showFragment("cat");
    }

    private void showFragment(String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PetsListFragment existFragment = (PetsListFragment) fragmentManager.findFragmentByTag(tag);
        if(existFragment == null) {
            PetsListFragment fragment = new PetsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PetsListFragment.PET, tag);
            fragment.setArguments(bundle);
            fragmentTransaction.add(R.id.fragment_container, fragment, tag);
        } else {
            fragmentTransaction.show(existFragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_TAB_POS, tabLayout.getSelectedTabPosition());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        tabLayout.getTabAt(savedState.getInt(CURRENT_TAB_POS, 0)).select();
    }
}
