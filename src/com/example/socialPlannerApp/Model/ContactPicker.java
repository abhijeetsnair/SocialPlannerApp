package com.example.socialPlannerApp.Model;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;

public class ContactPicker extends Activity implements OnClickListener {
	protected static final int PICK_CONTACTS = 100;
	@SuppressWarnings("unused")
	private static final String LOG_TAG = ContactDataManager.class.getName();

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		// Opens the contact list from the users contact to choose attendees
		Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
				Contacts.CONTENT_URI);
		startActivityForResult(contactPickerIntent, PICK_CONTACTS);

	}

}
