package com.ncr.fragment.dialog_example;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ncr.fragment.R;

public class DialogActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_activity);
	}

	public void showSimpleDialog(View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setMessage("Dialog Message")
				.setTitle(getString(R.string.app_name));

		AlertDialog dialog = builder.create();

		dialog.show();
	}

	public void showAlertDialogWithButtons(View view) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setMessage("Dialog Title")
				.setTitle("Dialog Message");

		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				Toast.makeText(getApplicationContext(), "Ok Button Clicked", Toast.LENGTH_LONG).show();
			}
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				Toast.makeText(getApplicationContext(), "Cancel Button Clicked", Toast.LENGTH_LONG).show();
			}
		});

		builder.setNeutralButton("Neut", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {

				Toast.makeText(getApplicationContext(), "NEUT Button Clicked", Toast.LENGTH_LONG).show();
			}
		});

		AlertDialog dialog = builder.create();
		dialog.show();
	}

	public void showAlertDialogWithList(View view) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick Color")
				.setItems(R.array.color_names, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getApplicationContext(), which + " is selected", Toast.LENGTH_LONG).show();
					}
				});

		builder.show();
	}

	public void showAlertDialogWithMultiChoice(View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick your toppings")

				.setMultiChoiceItems(R.array.toppings, null,
						new DialogInterface.OnMultiChoiceClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which,
							                    boolean isChecked) {
							}
						})
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {

					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
					}
				});

		builder.show();
	}

	public void showCustomDialog(View view) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// Get the layout inflater
		LayoutInflater inflater = this.getLayoutInflater();

		// Inflate and set the layout for the dialog
		// Pass null as the parent view because its going in the dialog layout
		builder.setView(inflater.inflate(R.layout.dialog_custom, null))
				// Add action buttons
				.setTitle("Title")
				.setPositiveButton("Login", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						// sign in the user ...
					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				});
		builder.show();
	}

	public void showTimePickerDialog(View view) {

		TimePickerDialog mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

			}
		}, 11, 55, true);
		mTimePicker.setTitle("Select Time");
		mTimePicker.show();
	}

	public void showDatePickerDialog(View view) {

		DatePickerDialog mDatePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

			}
		},2018, 11, 3);
		mDatePicker.setTitle("Select Date");
		mDatePicker.show();
	}
}
