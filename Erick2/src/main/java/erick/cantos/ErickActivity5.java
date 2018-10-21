/**
 *  Name: Erick Cantos
 *  Student ID: N01068423
 *  Assignment: 2
 *  Due Date: 10/14/18
 */
package erick.cantos;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import java.util.regex.Pattern;

public class ErickActivity5 extends AppCompatActivity {

    private static final Pattern NAME =
            Pattern.compile("^" +
            "(?=.*[A-Zaz])" +// alpha only w/ at least 3 char
            ".{3,}" +
            "$");
    private static final Pattern CREDIT =
            Pattern.compile("^" +
            ".{16}" +
            "(?=.*[0-9])" +  // numbers only
            "$");
    private static final Pattern CVC =
            Pattern.compile("^" +
            ".{3}" +
            "(?=.*[0-9])" +  // numbers only
            "$");

    // editText Inputs
    private TextInputLayout textInputFirstName;
    private TextInputLayout textInputLastName;
    private TextInputLayout textInputAddress;
    private TextInputLayout textInputCreditCard;
    private TextInputLayout textInputCVC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erick5);

        // Setting editTextInputs
        textInputFirstName = findViewById(R.id.textInputLayout);
        textInputLastName = findViewById(R.id.textInputLayout4);
        textInputAddress = findViewById(R.id.textInputLayout2);
        textInputCreditCard = findViewById(R.id.textInputLayout3);
        textInputCVC = findViewById(R.id.textInputLayout5);
    }
// VALIDATION METHODS
    private boolean validateFirstName(){
        String firstNameInput = textInputFirstName.getEditText().getText().toString().trim();
        if(firstNameInput.isEmpty()){
            textInputFirstName.setError("Field cannot be empty");
            return false;
        }
        else if(!NAME.matcher(firstNameInput).matches()){
            textInputFirstName.setError("Characters only");
            return false;
        }
        else{
            textInputFirstName.setError(null);
            return true;
        }
    }
    private boolean validateLastName(){
        String lastNameInput = textInputLastName.getEditText().getText().toString().trim();
        if(lastNameInput.isEmpty()){
            textInputLastName.setError("Field cannot be empty");
            return false;
        }
        else if(!NAME.matcher(lastNameInput).matches()){
            textInputLastName.setError("Characters only");
            return false;
        }
        else{
            textInputLastName.setError(null);
            return true;
        }
    }
    private boolean validateCredit(){
        String creditInput = textInputCreditCard.getEditText().getText().toString().trim();
        if(creditInput.isEmpty()){
            textInputCreditCard.setError("Field cannot be empty");
            return false;
        }
        else if(!CREDIT.matcher(creditInput).matches()){
            textInputCreditCard.setError("Must 16 digits, numbers only");
            return false;
        }
        else{
            textInputCreditCard.setError(null);
            return true;
        }
    }
    private boolean validateCVC(){
        String CVCInput = textInputCVC.getEditText().getText().toString().trim();
        if(CVCInput.isEmpty()){
            textInputCVC.setError("Field cannot be empty");
            return false;
        }
        else if(!CVC.matcher(CVCInput).matches()){
            textInputCVC.setError("Must be 3 digits, numbers only");
            return false;
        }
        else{
            textInputCVC.setError(null);
            return true;
        }
    }
    public void placeOrder(View v){
        if(!validateFirstName() | !validateLastName() | !validateCredit() |!validateCVC()){
            return;
        }
        String input = "Name:" + textInputFirstName.getEditText().getText().toString();
        input += " ";
        input += textInputLastName.getEditText().getText().toString();
        input += "/n";
        input +="Credit Card:" + textInputCreditCard.getEditText().getText().toString();

        // input to get passed through intent
        // Go to check-out screen
        Intent myIntent = new Intent(ErickActivity5.this, ErickActivity6.class);
        myIntent.putExtra("Input", input);
        ErickActivity5.this.startActivity(myIntent);
    }
}
