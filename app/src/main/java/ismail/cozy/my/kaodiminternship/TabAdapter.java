package ismail.cozy.my.kaodiminternship;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private final List<Integer> mFragmentIconList = new ArrayList<>();
    private Context context;

    TabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
    public void addFragment(Fragment fragment, String title, int tabIcon) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
        mFragmentIconList.add(tabIcon);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public View getTabView(int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        ImageView tabImageView = view.findViewById(R.id.tabImageView);
        tabImageView.setImageResource(mFragmentIconList.get(position));

        TextView tabTextView = view.findViewById(R.id.tabTextView);
        tabTextView.setText(mFragmentTitleList.get(position));

        tabImageView.setAlpha(0.7f);
        tabTextView.setAlpha(0.7f);

        return view;
    }

    public View getSelectedTabView(int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);

        ImageView tabImageView = view.findViewById(R.id.tabImageView);
        tabImageView.setImageResource(mFragmentIconList.get(position));
        tabImageView.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_ATOP);

        TextView tabTextView = view.findViewById(R.id.tabTextView);
        tabTextView.setText(mFragmentTitleList.get(position));
        tabTextView.setTextColor(ContextCompat.getColor(context, R.color.white));

        return view;
    }
}