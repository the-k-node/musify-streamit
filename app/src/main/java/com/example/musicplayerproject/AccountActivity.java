package com.example.musicplayerproject;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialButton mAccScreenKnowusBtn;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    String uName;
    private static final String keyEmail = "mail";
    private static final String keyName = "name";
    private static final String keyMobile = "mobile";
    private static final String keyPassword = "password";
    private static final String keyPPLink = "PPLink1";
    private CircleImageView imageView;
    private TextView usersName, uphone, umail, upass;
    private StorageReference mStorageRef;
    private Uri imageUri;
    String usnx;
    String imageurl;
    private UploadTask uploadTask;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        uName = getIntent().getStringExtra("mail");

        imageView = (CircleImageView) findViewById(R.id.account_page_display_pic);
        usersName = (TextView) findViewById(R.id.name);
        uphone = (TextView) findViewById(R.id.contact);
        umail = (TextView) findViewById(R.id.mail);
        upass = (TextView) findViewById(R.id.password);




        mStorageRef = FirebaseStorage.getInstance().getReference("Images");

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.darkBlue));
        initView();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

    }

    public void backIconClickedAccount(View v) {
        onBackPressed();
    }

    private void initView() {
        mAccScreenKnowusBtn = (MaterialButton) findViewById(R.id.acc_screen_knowus_btn);
        mAccScreenKnowusBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.acc_screen_knowus_btn:
                startActivity(new Intent(this, CreditsActivity.class));
                break;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        String mailget=getIntent().getStringExtra("mail");
        DocumentReference noteref=db.collection(mailget).document("UserData");
        noteref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists())
                {
                    String emailx=documentSnapshot.getString(keyEmail);
                    String namex=documentSnapshot.getString(keyName);
                    String mobilex=documentSnapshot.getString(keyMobile);
                    String passwordx=documentSnapshot.getString(keyPassword);
                    String plinkx=documentSnapshot.getString(keyPPLink);


                    usersName.setText(namex);
                    umail.setText(emailx);
                    upass.setText(passwordx);
                    uphone.setText(mobilex);


                    if (plinkx.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(),"Upload a profile pic.",Toast.LENGTH_SHORT).show();
                    }else {

                        //String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
                        // ImageView ivBasicImage = (ImageView) findViewById(R.id.ivBasicImage);
                        Glide.with(getApplicationContext()).load(plinkx).into(imageView);
                    }


                }
                else {
                    Toast.makeText(getApplicationContext(),"Document does not exist!",Toast.LENGTH_SHORT).show();

                }

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Document does not exist!",Toast.LENGTH_SHORT).show();
                        // Log.d(TAG,e.toString());
                    }
                });


    }



    private void selectImage() {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
        AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, 1);
                }
                else if (options[item].equals("Choose from Gallery"))
                {
                    Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                }
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
                    imageView.setImageBitmap(bitmap);
                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                imageView.setImageURI(selectedImage);
                final StorageReference riversRef = mStorageRef.child(uName);

                try {
                    uploadTask =  riversRef.putFile(selectedImage);
                }
                catch (Exception e)
                { }

                progressDialog=new ProgressDialog(this);
                progressDialog.setMax(100);
                progressDialog.setMessage("Uploading...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
                progressDialog.setCancelable(false);

                uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                        double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                        progressDialog.incrementProgressBy((int) progress);
                    }
                });
                uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                    }
                });
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                    }
                });

                Task<Uri> uriTask=uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful())
                        {

                            throw task.getException();
                        }
                        return riversRef.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful())
                        {
                            Uri durl=task.getResult();
                            String link1=durl.toString();

                            String mailget=getIntent().getStringExtra("mail");
                            DocumentReference noteref=db.collection(mailget).document("UserData");
                            noteref.update(keyPPLink,link1);
                            Toast.makeText(getApplicationContext(), "Uploaded sucessfully",Toast.LENGTH_SHORT).show();

                        }

                    }
                });


            }
        }
    }

}
