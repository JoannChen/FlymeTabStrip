package com.joann.chen.flymetabstrip.tab;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.joann.chen.flymetabstrip.R;
import com.joann.chen.flymetabstrip.TestActivity;


public class TestFragmentFour extends BaseFragment {
	private TextView fragment_text;
	private TestActivity activity;
	@Override
	public int setLayout() {
		return R.layout.test_fragment_one;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fragment_text = (TextView) sparseArray.get(R.id.fragment_text);
		fragment_text.setText("页面004");
		activity=(TestActivity) getActivity();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fragment_text:
			Toast.makeText(activity, fragment_text.getText().toString(), Toast.LENGTH_SHORT).show();
			break;
		}
	}

	@Override
	public void onDestroyNew() {

	}
}
