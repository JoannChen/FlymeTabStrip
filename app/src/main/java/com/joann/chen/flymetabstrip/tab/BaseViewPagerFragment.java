package com.joann.chen.flymetabstrip.tab;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.joann.chen.flymetabstrip.R;


/**
 * 带导航条的基类
 */
public abstract class BaseViewPagerFragment extends BaseFragment {

    protected PagerSlidingTabStrip mTabStrip;
    protected ViewPager mViewPager;
    protected ViewPageFragmentAdapter mTabsAdapter;
    protected ViewGroup tabsLayout;
    // 要展示的索引
    protected int index = -1,
    // 设置viewpager缓存多少个
    cacheLimit = 0;
    // 默认滑块背景图
    protected int backgroundId = R.mipmap.bg_tab_unchecked,
            slidingBlock = R.mipmap.bg_tab_checked;

    // 设置title颜色选择器ID
    protected int textColorSelect = R.color.black_font;
    //PagerSlidingTabStrip对象是否可以滑动,默认可以滑动
    protected boolean slidingTag = true;
    //PagerSlidingTabStrip对象title文本内容字体选择效果是否需要放大,默认是不放大
    protected boolean textSizeTag = false;

    @Override
    public void onDestroyNew() {
    }

    @Override
    public int setLayout() {
        return R.layout.base_viewpage_fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mViewPager = view.findViewById(R.id.pager);
        mTabStrip = view.findViewById(R.id.tabstrip);
        mTabStrip.setBackgroundResource(backgroundId);
        mTabStrip.setSlidingBlockDrawable(getResources().getDrawable(
                slidingBlock));
        mTabStrip.slidingTag = this.slidingTag;
        mTabStrip.textSizeTag = this.textSizeTag;
        mTabsAdapter = new ViewPageFragmentAdapter(getChildFragmentManager(),
                mTabStrip, mViewPager);
        mTabsAdapter.textColroSelect = textColorSelect;
        mViewPager.setOffscreenPageLimit(cacheLimit);// 设置ViewPare一次性加载几个页面。
        // 回调方法给子类调用
        onSetupTabAdapter(mTabsAdapter);
        mTabsAdapter.notifyDataSetChanged();
        if (index != -1)
        // 设置要展示的页面索引值
        {
            mViewPager.setCurrentItem(index == -1 ? 0 : index, true);
        }
        tabsLayout = mTabStrip.getTabsLayoutTest();
        // 监听事件(点击之后隐藏红点)
		/*
		 * mTabStrip.setOnClickTabListener(new OnClickTabListener() {
		 *
		 * @Override public void onClickTab(View tab, int index) { View
		 * view=data.getChildAt(3); TextView viewText =(TextView) view;
		 * viewText.setText("哈哈"); } });
		 */
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", mViewPager.getCurrentItem());
    }

    protected abstract void onSetupTabAdapter(ViewPageFragmentAdapter adapter);
}