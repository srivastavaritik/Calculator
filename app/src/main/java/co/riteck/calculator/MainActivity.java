package co.riteck.calculator;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btndot;
    Button btnorien;
    Button btnclearall,btnbackspace,btnpercent,btndivide,btnplus,btnmultiply,btnminus,btnequal;
    TextView tvcalc;
    String tmp;
    String result;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        initControlListener();
    }

    private void initControlListener() {
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("9");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked(".");
            }
        });
        btnorien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOrienButtonClicked();
            }
        });

        btnclearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearButtonClicked();
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onOperatorButtonClicked("-");
            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("+");
            }
        });
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("*");
            }
        });
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("/");
            }

        });
        btnpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("%");
            }

        });
        btnbackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackspaceButtonClicked();
            }

        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqualButtonClicked();
            }
        });

    }

    private void onEqualButtonClicked() {
        double res = 0;
        try {
            double number = Double.valueOf(tmp);
            double number2 = Double.valueOf(tvcalc.getText().toString());
            switch (operator) {
                case "+":
                    res = number + number2;
                    break;
                case "/":
                    res = number / number2;
                    break;
                case "-":
                    res = number - number2;
                    break;
                case "*":
                    res = number * number2;
                    break;
                case "%":
                    res =number % number2 ;
                    break;


            }
            result = String.valueOf(res);
            tvcalc.setText(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onOperatorButtonClicked(String operator) {
        tmp = tvcalc.getText().toString();
        onClearButtonClicked();
        this.operator = operator;
    }

    private void onClearButtonClicked() {
        result = "";
        tvcalc.setText("");
    }

    private void onNumberButtonClicked(String pos) {
        result = tvcalc.getText().toString();
        result = result + pos;
        tvcalc.setText(result);
    }

    private void onOrienButtonClicked() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }


    private void initControl() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnbackspace= findViewById(R.id.btnbackspace);
        btnpercent= findViewById(R.id.btnpercent);
        btndot= findViewById(R.id.btndot);
        btnplus = findViewById(R.id.btnplus);
        btnclearall = findViewById(R.id.btnclearall);
        btnminus = findViewById(R.id.btnminus);
        btnmultiply = findViewById(R.id.btnmultiply);
        btndivide = findViewById(R.id.btndivide);
        btnequal = findViewById(R.id.btnequal);
        tvcalc = findViewById(R.id.tvcalc);
        btnorien= findViewById(R.id.btnorien);
    }

    private void onBackspaceButtonClicked() {
            String str=tvcalc.getText().toString();
            if (str.length() >=1 ) {
                str = str.substring(0, str.length() - 1);
                tvcalc.setText(str);
            } else if (str.length() <=1 ) {
                tvcalc.setText("0");
            }
        }
}
