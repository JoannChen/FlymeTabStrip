package com.joann.chen.flymetabstrip;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.joann.chen.flymetabstrip.tab.ExploreViewPagerFragment;
import com.joann.chen.flymetabstrip.tab.TestFragmentFour;
import com.joann.chen.flymetabstrip.tab.TestFragmentOne;
import com.joann.chen.flymetabstrip.tab.TestFragmentThree;
import com.joann.chen.flymetabstrip.tab.TestFragmentTwo;

import java.util.ArrayList;

/**
 * Function：
 *
 * Created by JoannChen on 2017/4/10 16:26
 * E-mail:q8622268@163.com
 */
public class TestActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.test_main_activity);
        setExploreShow(this.getSupportFragmentManager());

    }

    /**
     * FragmentLayout界面赋值
     */
    private void setExploreShow(FragmentManager mFragmentManager) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ArrayList<Class<?>> clazzList = new ArrayList<>();
        clazzList.add(TestFragmentOne.class);
        clazzList.add(TestFragmentTwo.class);
        clazzList.add(TestFragmentThree.class);
        clazzList.add(TestFragmentFour.class);
        clazzList.add(TestFragmentOne.class);
        clazzList.add(TestFragmentOne.class);
        clazzList.add(TestFragmentOne.class);
        clazzList.add(TestFragmentOne.class);
        clazzList.add(TestFragmentOne.class);
        clazzList.add(TestFragmentOne.class);

        String[] array = new String[]{"金额优惠", "时长优惠", "折扣优惠", "全免优惠","余额优惠","aa","bb","ccccccccccc","ddd","eeeeeeeeeeeeeeeeeeeeeee"};
        ft.replace(R.id.main_framen, ExploreViewPagerFragment
                        .newInstance()
                        .setFragmentObjList(this, array,clazzList)
                        .setViewpagerIndxe(0)
                        .setViewpagerCacheLimit(clazzList.size())
                        .setSlidingTabStripImage(
                                R.mipmap.store_title_image_mr,
                                R.mipmap.store_title_image_xz)
                        .setTextColorSelect(R.drawable.store_selector_slide_title))
                .commit();

    }
}

