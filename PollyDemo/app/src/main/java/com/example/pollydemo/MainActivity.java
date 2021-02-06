package com.example.pollydemo;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cognito pool ID. Pool needs to be unauthenticated pool with
        // Amazon Polly permissions.
        String COGNITO_POOL_ID = "YourCognitoIdentityPoolId";

        // Region of Amazon Polly.
        Regions MY_REGION = Regions.US_EAST_1;
        // Initialize the Amazon Cognito credentials provider.
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                COGNITO_POOL_ID,
                MY_REGION
        );
        // Create a client that supports generation of presigned URLs.
        AmazonPollyPresigningClient client = new AmazonPollyPresigningClient(credentialsProvider);
    }
}