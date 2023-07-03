package com.example.collegebusmanagement;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;



public class FeesActivity extends AppCompatActivity implements PaymentResultListener{
    TextView fprice,pstatus;
    Button paybtn;
    int famount=0;
    private String selectedDistrict, selectedState;                 //vars to hold the values of selected State and District
    private TextView tvStateSpinner, tvDistrictSpinner;             //declaring TextView to show the errors
    private Spinner stateSpinner, districtSpinner;                  //Spinners
    private ArrayAdapter<CharSequence> districtAdapter;   //declare adapters for the spinners
    public TextView feebox ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);

        pstatus=findViewById(R.id.pstatus);
        paybtn=findViewById(R.id.button_submit);

        //State Spinner Initialisation
        stateSpinner = findViewById(R.id.spinner_indian_states);    //Finds a view that was identified by the android:id attribute in xml

        //Populate ArrayAdapter using string array and a spinner layout that we will define
        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_indian_states, R.layout.spinner_layout);

        // Specify the layout to use when the list of choices appear
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        stateSpinner.setAdapter(stateAdapter);            //Set the adapter to the spinner to populate the State Spinner

        //When any item of the stateSpinner uis selected
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Define City Spinner but we will populate the options through the selected state
                districtSpinner = findViewById(R.id.spinner_indian_districts);

                selectedState = stateSpinner.getSelectedItem().toString();      //Obtain the selected State

                int parentID = parent.getId();
                if (parentID == R.id.spinner_indian_states){
                    switch (selectedState){
                        case "Select Your Bus no": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_default_districts, R.layout.spinner_layout);
                            break;
                        case "Bus no1": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
                            break;
                        case "Bus no2": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_arunachal_pradesh_districts, R.layout.spinner_layout);
                            break;
                        case "Bus no3": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_assam_districts, R.layout.spinner_layout);
                            break;
                        case "Bus no4": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_bihar_districts, R.layout.spinner_layout);
                            break;
                        case "Bus no5": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_chhattisgarh_districts, R.layout.spinner_layout);
                            break;
                        case "Bus no6": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_goa_districts, R.layout.spinner_layout);
                            break;
                        case "Bus no7": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_gujarat_districts, R.layout.spinner_layout);
                            break;
                        case "Bus no8": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_haryana_districts, R.layout.spinner_layout);
                            break;
                        case "Bus no9": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_himachal_pradesh_districts, R.layout.spinner_layout);
                            break;

                        default:  break;
                    }
                    districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     // Specify the layout to use when the list of choices appears
                    districtSpinner.setAdapter(districtAdapter);        //Populate the list of Districts in respect of the State selected

                    //To obtain the selected District from the spinner
                    districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedDistrict = districtSpinner.getSelectedItem().toString();
                            switch (selectedDistrict){
                                case "Muvattupuzha": feebox =findViewById(R.id.feebox);
                                    feebox.setText("25000");
                                    famount=25000;
                                    break;

                                case "Thrikalathoor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("22000");
                                    famount=22000;
                                    break;
                                case "Mannoor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("20000");
                                    famount=20000;
                                    break;
                                case "Keezhillam": feebox =findViewById(R.id.feebox);
                                    feebox.setText("18000");
                                    famount=18000;
                                    break;
                                case "Pulluvazhy": feebox =findViewById(R.id.feebox);
                                    feebox.setText("16000");
                                    famount=16000;
                                    break;
                                case "Kuruppampady": feebox =findViewById(R.id.feebox);
                                    feebox.setText("14000");
                                    famount=14000;
                                    break;
                                case "Iringole": feebox =findViewById(R.id.feebox);
                                    feebox.setText("12000");
                                    famount=12000;
                                    break;
                                case "Onnam Mile": feebox =findViewById(R.id.feebox);
                                    feebox.setText("10000");
                                    famount=10000;
                                    break;
                                case "Okkal": feebox =findViewById(R.id.feebox);
                                    feebox.setText("8000");
                                    famount=8000;
                                    break;



                                case "Kothamangalam": feebox =findViewById(R.id.feebox);
                                    feebox.setText("35000");
                                    famount=35000;
                                    break;
                                case "Nellikuzhi": feebox =findViewById(R.id.feebox);
                                    feebox.setText("28000");
                                    famount=28000;
                                    break;
                                case "Erumalapady": feebox =findViewById(R.id.feebox);
                                    feebox.setText("25000");
                                    famount=25000;
                                    break;
                                case "Odakkaly": feebox =findViewById(R.id.feebox);
                                    feebox.setText("22000");
                                    famount=22000;
                                    break;
                                case "Cherukunnam": feebox =findViewById(R.id.feebox);
                                    feebox.setText("20000");
                                    famount=20000;
                                    break;
                                case "Kurupumpady": feebox =findViewById(R.id.feebox);
                                    feebox.setText("19000");
                                    famount=19000;
                                    break;
                                case "Akanad": feebox =findViewById(R.id.feebox);
                                    feebox.setText("16000");
                                    famount=16000;
                                    break;
                                case "Kuruchilakode": feebox =findViewById(R.id.feebox);
                                    feebox.setText("15000");
                                    famount=15000;
                                    break;
                                case "Malayatoor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("12000");
                                    famount=12000;
                                    break;
                                case "Kalady": feebox =findViewById(R.id.feebox);
                                    feebox.setText("10000");
                                    famount=10000;
                                    break;



                                case "Vazhikulangara": feebox =findViewById(R.id.feebox);
                                    feebox.setText("29000");
                                    famount=29000;
                                    break;
                                case "Cheriapally": feebox =findViewById(R.id.feebox);
                                    feebox.setText("27000");
                                    famount=27000;
                                    break;
                                case "Kochal": feebox =findViewById(R.id.feebox);
                                    feebox.setText("25000");
                                    famount=25000;
                                    break;
                                case "Koonammavu": feebox =findViewById(R.id.feebox);
                                    feebox.setText("23000");
                                    famount=23000;
                                    break;
                                case "Kongorpilly": feebox =findViewById(R.id.feebox);
                                    feebox.setText("20000");
                                    famount=20000;
                                    break;
                                case "Nerricode": feebox =findViewById(R.id.feebox);
                                    feebox.setText("18000");
                                    famount=18000;
                                    break;
                                case "Alangad": feebox =findViewById(R.id.feebox);
                                    feebox.setText("16000");
                                    famount=16000;
                                    break;
                                case "Kottapuram": feebox =findViewById(R.id.feebox);
                                    feebox.setText("14000");
                                    famount=14000;
                                    break;
                                case "Desom": feebox =findViewById(R.id.feebox);
                                    feebox.setText("11000");
                                    famount=11000;
                                    break;
                                case "Airport": feebox =findViewById(R.id.feebox);
                                    feebox.setText("7000");
                                    famount=7000;
                                    break;


                                case "Aroor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("34000");
                                    famount=34000;
                                    break;
                                case "Kumbalam": feebox =findViewById(R.id.feebox);
                                    feebox.setText("28000");
                                    famount=28000;
                                    break;
                                case "Kundanoor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("26000");
                                    famount=26000;
                                    break;
                                case "Vytilla": feebox =findViewById(R.id.feebox);
                                    feebox.setText("22000");
                                    famount=22000;
                                    break;
                                case "Vysali": feebox =findViewById(R.id.feebox);
                                    feebox.setText("20000");
                                    famount=20000;
                                    break;
                                case "Chakkaraparambu": feebox =findViewById(R.id.feebox);
                                    feebox.setText("18000");
                                    famount=18000;
                                    break;
                                case "Vennala": feebox =findViewById(R.id.feebox);
                                    feebox.setText("17000");
                                    famount=17000;
                                    break;
                                case "Palarivattom": feebox =findViewById(R.id.feebox);
                                    feebox.setText("16000");
                                    famount=16000;
                                    break;
                                case "Appolo": feebox =findViewById(R.id.feebox);
                                    feebox.setText("15000");
                                    famount=15000;
                                    break;



                                case "Fort Kochi": feebox =findViewById(R.id.feebox);
                                    feebox.setText("28000");
                                    famount=28000;
                                    break;
                                case "Koovapadam": feebox =findViewById(R.id.feebox);
                                    feebox.setText("26700");
                                    famount=26700;
                                    break;
                                case "Kappalandimukku": feebox =findViewById(R.id.feebox);
                                    feebox.setText("25070");
                                    famount=25070;
                                    break;
                                case "Chullikkal": feebox =findViewById(R.id.feebox);
                                    feebox.setText("22000");
                                    famount=22000;
                                    break;
                                case "Thopumpady": feebox =findViewById(R.id.feebox);
                                    feebox.setText("21300");
                                    famount=21300;
                                    break;
                                case "Thevara": feebox =findViewById(R.id.feebox);
                                    feebox.setText("20900");
                                    famount=20900;
                                    break;
                                case "Panambilly Nagar": feebox =findViewById(R.id.feebox);
                                    feebox.setText("19000");
                                    famount=19000;
                                    break;
                                case "Ellamkulam": feebox =findViewById(R.id.feebox);
                                    feebox.setText("18000");
                                    famount=18000;
                                    break;
                                case "Janatha": feebox =findViewById(R.id.feebox);
                                    feebox.setText("13000");
                                    famount=13000;
                                    break;




                                case "Moothakunnam": feebox =findViewById(R.id.feebox);
                                    feebox.setText("28400");
                                    famount=28400;
                                    break;
                                case "Andipillikkavu": feebox =findViewById(R.id.feebox);
                                    feebox.setText("26050");
                                    famount=26050;
                                    break;
                                case "Chittatukara": feebox =findViewById(R.id.feebox);
                                    feebox.setText("25070");
                                    famount=25070;
                                    break;
                                case "Paravoor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("23090");
                                    famount=23090;
                                    break;
                                case "Vedimara": feebox =findViewById(R.id.feebox);
                                    feebox.setText("22010");
                                    famount=22010;
                                    break;
                                case "Manjaly": feebox =findViewById(R.id.feebox);
                                    feebox.setText("21001");
                                    famount=21001;
                                    break;
                                case "Aduvassery": feebox =findViewById(R.id.feebox);
                                    feebox.setText("20000");
                                    famount=20000;
                                    break;
                                case "Companipady": feebox =findViewById(R.id.feebox);
                                    feebox.setText("19000");
                                    famount=19000;
                                    break;




                                case "Irinjalakuda": feebox =findViewById(R.id.feebox);
                                    feebox.setText("28888");
                                    famount=28888;
                                    break;
                                case "Kalletumkara": feebox =findViewById(R.id.feebox);
                                    feebox.setText("27777");
                                    famount=27777;
                                    break;
                                case "Aloor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("26666");
                                    famount=26666;
                                    break;
                                case "Potta": feebox =findViewById(R.id.feebox);
                                    feebox.setText("24444");
                                    famount=24444;
                                    break;
                                case "Koratty": feebox =findViewById(R.id.feebox);
                                    feebox.setText("22222");
                                    famount=22222;
                                    break;
                                case "Chirangara": feebox =findViewById(R.id.feebox);
                                    feebox.setText("20000");
                                    famount=20000;
                                    break;
                                case "Pongam": feebox =findViewById(R.id.feebox);
                                    feebox.setText("18000");
                                    famount=18000;
                                    break;
                                case "Karukutty": feebox =findViewById(R.id.feebox);
                                    feebox.setText("17000");
                                    famount=17000;
                                    break;
                                case "Angamaly": feebox =findViewById(R.id.feebox);
                                    feebox.setText("16000");
                                    famount=16000;
                                    break;



                                case "Thripunithara": feebox =findViewById(R.id.feebox);
                                    feebox.setText("38080");
                                    famount=38080;
                                    break;
                                case "Kaingachira": feebox =findViewById(R.id.feebox);
                                    feebox.setText("28000");
                                    famount=28000;
                                    break;
                                case "Mamala": feebox =findViewById(R.id.feebox);
                                    feebox.setText("27000");
                                    famount=27000;
                                    break;
                                case "Choondi": feebox =findViewById(R.id.feebox);
                                    feebox.setText("26000");
                                    famount=26000;
                                    break;
                                case "Kolencherry": feebox =findViewById(R.id.feebox);
                                    feebox.setText("25000");
                                    famount=25000;
                                    break;
                                case "Pattimattom": feebox =findViewById(R.id.feebox);
                                    feebox.setText("24000");
                                    famount=24000;
                                    break;
                                case "Arackapady": feebox =findViewById(R.id.feebox);
                                    feebox.setText("19000");
                                    famount=19000;
                                    break;


                                case "Kunnumpuram": feebox =findViewById(R.id.feebox);
                                    feebox.setText("40000");
                                    famount=40000;
                                    break;
                                case "Manjummal Palli": feebox =findViewById(R.id.feebox);
                                    feebox.setText("35000");
                                    famount=35000;
                                    break;
                                case "Eloor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("30000");
                                    famount=30000;
                                    break;
                                case "Pathalam": feebox =findViewById(R.id.feebox);
                                    feebox.setText("25000");
                                    famount=25000;
                                    break;
                                case "Edayar": feebox =findViewById(R.id.feebox);
                                    feebox.setText("20000");
                                    famount=20000;
                                    break;
                                case "West Kadungallor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("18000");
                                    famount=18000;
                                    break;
                                case "East Kadungallor": feebox =findViewById(R.id.feebox);
                                    feebox.setText("15000");
                                    famount=15000;
                                    break;
                                case "UC College": feebox =findViewById(R.id.feebox);
                                    feebox.setText("14000");
                                    famount=14000;
                                    break;
                                case "Kottai ": feebox =findViewById(R.id.feebox);
                                    feebox.setText("12000");
                                    famount=12000;
                                    break;



                                default: break;
                            }
                            //String fee = feebox.getText().toString();
                            //famount= feebox.getText().length();


                        }




                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });

                    paybtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String samount = String.valueOf(famount);
                            int amount = Math.round(Float.parseFloat(samount) * 100);

                            Checkout checkout = new Checkout();
                            checkout.setKeyID("rzp_test_9F0aG7gfumMxOL");
                            checkout.setImage(R.drawable.adis);

                            JSONObject object = new JSONObject();
                            try {
                                object.put("name", "Adi Shankara Institute");
                                object.put("description", "Bus Fee Payment");
                                object.put("theme.color", "");
                                object.put("amount", amount);
                                object.put("prefill.contact", "8129513982");
                                object.put("prefill.email", "adishankara@gmail.com");
                                checkout.open(FeesActivity.this, object);
                            } catch (JSONException e)
                            {
                                e.printStackTrace();
                            }

                        }
                    });


                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }


    @Override
    public void onPaymentSuccess(String s) {
        pstatus.setText("Hooray !! Payment Successfully.Transaction No :"+s);
        fprice.setText("0.00");
    }

    @Override
    public void onPaymentError(int i, String s) {
        pstatus.setText("Something went wrong"+s);
        fprice.setText("0.00");





        tvStateSpinner = findViewById(R.id.textView_indian_states);
        tvDistrictSpinner = findViewById(R.id.textView_indian_districts);

        paybtn.setOnClickListener(v -> {
            if (selectedState.equals("Select Your Bus no")) {
                Toast.makeText(FeesActivity.this, "Please select your Bus no from the list", Toast.LENGTH_LONG).show();
                tvStateSpinner.setError("Bus no is required!");      //To set error on TextView
                tvStateSpinner.requestFocus();
            } else if (selectedDistrict.equals("Select Your bus stop")) {
                Toast.makeText(FeesActivity.this, "Please select your bus stop from the list", Toast.LENGTH_LONG).show();
                tvDistrictSpinner.setError("Bus stop is required!");
                tvDistrictSpinner.requestFocus();
                tvStateSpinner.setError(null);                      //To reove error from stateSpinner
            } else {
                tvStateSpinner.setError(null);
                tvDistrictSpinner.setError(null);
                Toast.makeText(FeesActivity.this, selectedState+"\n "+selectedDistrict, Toast.LENGTH_LONG).show();
            }
        });
    }
}