package com.example.toplearners;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toplearners.api.formRetrofitApi;
import com.example.toplearners.api.formRetrofitApiInterface;
import com.example.toplearners.model.post;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.TextUtils.isEmpty;


public class SubmitActivity extends AppCompatActivity {

    private formRetrofitApiInterface mFApi;
    private TextView mTresult;
    private String mFirstName;
    private String mLastName;
    private String mEmailAdress;
    private String mGitLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        Toolbar toolbar = findViewById(R.id.toolbar_submit);
        EditText FirstName = findViewById(R.id.ET_First_Name);
        EditText LastName = findViewById(R.id.ET_Last_Name);
        EditText EmailAdress = findViewById(R.id.ET_Email_Address);
        EditText GitLink = findViewById(R.id.ET_Git_Link);
        Button Submit = findViewById(R.id.BT_Submit);
        mTresult = findViewById(R.id.T_result);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirstName = FirstName.getText().toString();
                mLastName = LastName.getText().toString();
                mEmailAdress = EmailAdress.getText().toString();
                mGitLink = GitLink.getText().toString();
                if(!isEmpty(mFirstName) &&
                        !isEmpty(mLastName) &&
                        !isEmpty(mEmailAdress)&&
                        !isEmpty(mGitLink))
                {
                   // Toast.makeText(SubmitActivity.this, "close", Toast.LENGTH_LONG).show();
                    dialogCaller();



                }



            }
        });
    }

    private void dialogCaller() {
        final Dialog dialog = new Dialog(SubmitActivity.this);   // Create custom dialog object
                    dialog.setContentView(R.layout.dialog_sure_layout);       // Include dialog.xml file
                    dialog.show();                                         // Set dialog title dialog.setTitle("Custom Dialog");
                    TextView yes = dialog.findViewById(R.id.textView);
                    Button sure = dialog.findViewById(R.id.button);
                    ImageButton close = dialog.findViewById(R.id.imageClose);

                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(SubmitActivity.this, "close", Toast.LENGTH_LONG).show();
                        }
                    });
                    sure.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Toast.makeText(SubmitActivity.this, "yes sure", Toast.LENGTH_LONG).show();
                            sendPost();
                            dialog.dismiss();
                        }
                    });
    }

    public void sendPost()
    {
        Call<post> call = formRetrofitApi.getformApi().savePost(mFirstName, mLastName,mEmailAdress, mGitLink);
        call.enqueue(new Callback<post>() {
            @Override
            public void onResponse(Call<post> call, Response<post> response ) {
                if(response.isSuccessful())
                {
                    Toast.makeText(SubmitActivity.this, "Send successfully", Toast.LENGTH_LONG).show();
                    dialogSucces();
                }
                {
                    //Toast.makeText(SubmitActivity.this, "Request failed", Toast.LENGTH_LONG).show();
                    try {
                        Log.e("failure", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // dialogSucces();


                }

            }

            @Override
            public void onFailure(Call<post> call, Throwable t ) {
                Toast.makeText(SubmitActivity.this, "Send s failed", Toast.LENGTH_LONG).show();
                Log.e("failure", t.getLocalizedMessage());
                dialogFaill();

            }
        });
    }

    private void dialogFaill() {
        final Dialog dialog = new Dialog(SubmitActivity.this);   // Create custom dialog object
        dialog.setContentView(R.layout.unsuccessfull_layout);       // Include dialog.xml file
        dialog.show();                                         // Set dialog title dialog.setTitle("Custom Dialog");
        TextView sucess = dialog.findViewById(R.id.txt_fail);
        ImageView Img = dialog.findViewById(R.id.Img_fail);
    }

    private void dialogSucces() {
        final Dialog dialog = new Dialog(SubmitActivity.this);   // Create custom dialog object
        dialog.setContentView(R.layout.sucessfull_layout);       // Include dialog.xml file
        dialog.show();                                         // Set dialog title dialog.setTitle("Custom Dialog");
        TextView sucess = dialog.findViewById(R.id.txt_success);
        ImageView Img = dialog.findViewById(R.id.Img_success);
    }
}