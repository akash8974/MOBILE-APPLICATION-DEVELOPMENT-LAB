package com.example.akashdata;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
public class ResultsDialogFragment extends DialogFragment {
 private String studentDetails;
 public ResultsDialogFragment(String studentDetails) {
 this.studentDetails = studentDetails;
 }
 @Override
 public Dialog onCreateDialog(Bundle savedInstanceState) {
 LayoutInflater inflater = requireActivity().getLayoutInflater();
 View view = inflater.inflate(R.layout.dialog_view_students, null);
 TextView textViewStudents = view.findViewById(R.id.textViewStudents);
 Button buttonClose = view.findViewById(R.id.buttonClose);
 textViewStudents.setText(studentDetails);
 AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
 builder.setView(view)
 .setPositiveButton("Close", new DialogInterface.OnClickListener() {
 @Override
 public void onClick(DialogInterface dialog, int which) {
 dialog.dismiss();
 }
 });
 return builder.create();
 }
}
