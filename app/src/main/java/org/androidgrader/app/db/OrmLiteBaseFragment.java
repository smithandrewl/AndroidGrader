package org.androidgrader.app.db;


import android.app.Fragment;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;


public class OrmLiteBaseFragment extends Fragment {

    private DatabaseHelper databaseHelper = null;

    public DatabaseHelper getHelper() {
        if(databaseHelper == null) {
            return (DatabaseHelper) OpenHelperManager.getHelper(getActivity());
        }

        return databaseHelper;
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
        OpenHelperManager.releaseHelper();
    }
}
