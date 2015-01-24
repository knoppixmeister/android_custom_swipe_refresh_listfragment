package lv.bizapps.customswiperefreshlistfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;

class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
	public CustomSwipeRefreshLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomSwipeRefreshLayout(Context context) {
		super(context);
	}

	@Override
	public boolean canChildScrollUp() {
		return super.canChildScrollUp();
	}
}

public class CustomSwipeRefreshListFragment extends ListFragment {
	protected Button _tryLoadButton;
	protected SwipeRefreshLayout srl;

	public CustomSwipeRefreshListFragment() {
	}

	@SuppressLint("InflateParams")
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View newView = inflater.inflate(R.layout.custom_swipe_refresh_listfragment, null);

		_tryLoadButton = (Button)newView.findViewById(R.id.tryLoadButton);
		srl = (SwipeRefreshLayout)newView.findViewById(R.id.swipeRefresh);
	
		return newView;
	}

	public void setOnTryLoadClickListener(OnClickListener l) {
		_tryLoadButton.setOnClickListener(l);
	}

	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		//setListShownNoAnimation(false);
		setListShown(false);
	}

	public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
		srl.setOnRefreshListener(listener);
	}

	public boolean isRefreshing() {
        return srl.isRefreshing();
	}

	public void setRefreshing(boolean refreshing) {
		srl.setRefreshing(refreshing);
	}

	@SuppressWarnings("deprecation")
	public void setColorScheme(int colorRes1, int colorRes2, int colorRes3, int colorRes4) {
		srl.setColorScheme(colorRes1, colorRes2, colorRes3, colorRes4);
	}

	public SwipeRefreshLayout getSwipeRefreshLayout() {
        return srl;
	}

	public void setListAdapter(ListAdapter adapter) {
		if(adapter == null)	setListShownNoAnimation(false);
		else {
			setListShownNoAnimation(true);
			super.setListAdapter(adapter);
		}
	}

	public void setListShown(boolean shown) {
		if(!shown) {
			this.getView().findViewById(android.R.id.empty).setVisibility(View.GONE);
			this.getView().findViewById(android.R.id.list).setVisibility(View.GONE);
			this.getView().findViewById(R.id.progressBar1).setVisibility(View.VISIBLE);
		}
		else {
			this.getView().findViewById(android.R.id.empty).setVisibility(View.GONE);
			this.getView().findViewById(R.id.progressBar1).setVisibility(View.GONE);
			this.getView().findViewById(android.R.id.list).setVisibility(View.VISIBLE);
		}
	}

	public void setListShownNoAnimation(boolean shown) {
		if(!shown) {
			this.getView().findViewById(android.R.id.empty).setVisibility(View.GONE);
			this.getView().findViewById(android.R.id.list).setVisibility(View.GONE);
			this.getView().findViewById(R.id.progressBar1).setVisibility(View.VISIBLE);
		}
		else {
			this.getView().findViewById(android.R.id.empty).setVisibility(View.GONE);
			this.getView().findViewById(R.id.progressBar1).setVisibility(View.GONE);
			this.getView().findViewById(android.R.id.list).setVisibility(View.VISIBLE);
		}
	}
}