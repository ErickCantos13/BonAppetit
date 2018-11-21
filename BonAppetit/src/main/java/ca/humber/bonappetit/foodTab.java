/**
 *  Application: Bon Appetit
 *  Team Name: Team Slavick
 */
package ca.humber.bonappetit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class foodTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.tab_food, container, false);

        // Inner tab layout for "Food" tab.
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout2);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.vegetable));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.dairy));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.grain));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.protein));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Inner Tabs
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager2);
        final innerPagerAdapter adapter = new innerPagerAdapter
                (getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        final Button button = view.findViewById(R.id.button_confirm);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                try {
                    Intent myIntent = new Intent(getActivity(), recipeActivity.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    foodTab.this.startActivity(myIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

}
