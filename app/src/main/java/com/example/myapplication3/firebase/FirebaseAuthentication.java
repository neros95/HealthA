package com.example.myapplication3.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication3.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;

import java.util.concurrent.Executor;

import static android.content.ContentValues.TAG;

public class FirebaseAuthentication extends MainActivity {

    public static FirebaseAuthentication firebaseAuth = new FirebaseAuthentication();

    public static FirebaseAuth mAuth;
    public static FirebaseUser user;

    private boolean success = false;

    public boolean signInNewUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            user = mAuth.getCurrentUser();
                            success = true;
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            success = false;
                        }
                    }
                });
        return success;
    }

    public boolean signInExistingUser(String email, String password) {
        Log.d("EmailAuth", email);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            user = mAuth.getCurrentUser();
                            success = true;
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            success = false;
                        }
                    }
                });
        return success;
    }

    public boolean authState() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}
