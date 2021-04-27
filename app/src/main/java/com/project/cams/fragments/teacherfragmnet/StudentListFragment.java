package com.project.cams.fragments.teacherfragmnet;
        import android.content.Context;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.project.cams.DBhelperclasses.AllStudents;
        import com.project.cams.DBhelperclasses.AllTeacher;
        import com.project.cams.DBhelperclasses.DataBaseCAMS;
        import com.project.cams.MainActivity;
        import com.project.cams.Utility.Global;
        import com.project.cams.adapter.adminadapter.StudentAdapter;
        import com.project.cams.adapter.adminadapter.TeacherAdapter;
        import com.project.cams.databinding.StudentFragmentBinding;
        import com.project.cams.databinding.StudentlistFragmentBinding;
        import com.project.cams.fragments.adminfrag.AddStudentFragment;

        import java.util.ArrayList;
        import java.util.List;
public class StudentListFragment extends Fragment {
    StudentlistFragmentBinding binding;
    StudentAdapter studentAdapter;
    RecyclerView mRecyclerView;
    DataBaseCAMS dataBase;
    Context mContext;
    List< AllStudents > mList;

    // required***************//
    public StudentListFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dataBase = DataBaseCAMS.getInstance(mContext);
        binding = StudentlistFragmentBinding.inflate(getLayoutInflater());
        initView();
        SetStudents();
        return binding.getRoot();
    }

    private void initView() {
        mRecyclerView = binding.studentListRecycler;
        MainActivity.floatingActionButton.bringToFront();
        MainActivity.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.changeFragment(getActivity(), new AddStudentFragment());
            }
        });
    }

    private void SetStudents() {
        mList = new ArrayList<>();
        mList = dataBase.daoData().getAllStudents();

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        studentAdapter = new StudentAdapter(mList, mContext);
        mRecyclerView.setAdapter(studentAdapter);
    }

}
