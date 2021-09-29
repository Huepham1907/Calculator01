package com.calculator.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private EditText edtNumber;
    private TextView tvResult;

    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnNumber0;

    private Button btnAdd;
    private Button btnMinus;
    private Button btnMultiplication;
    private Button btnDivide;
    private Button btnDot;
    private Button btnClear;
    private Button btnClearAll;
    private Button btnResult;
    private final String Tag = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEvenClickViews();
    }

    public void initWidget() {
        edtNumber = (EditText) findViewById(R.id.edt_input);
        tvResult = (TextView) findViewById(R.id.tv_result);


        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);
        btnNumber0 = (Button) findViewById(R.id.btnNumber0);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClearAll = (Button) findViewById(R.id.btnClearAll);
    }

    public void setEvenClickViews() {
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnNumber0.setOnClickListener(this);

        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

        btnResult.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNumber0:
                edtNumber.append("0");
                break;
            case R.id.btnNumber1:
                edtNumber.append("1");
                break;
            case R.id.btnNumber2:
                edtNumber.append("2");
                break;
            case R.id.btnNumber3:
                edtNumber.append("3");
                break;
            case R.id.btnNumber4:
                edtNumber.append("4");
                break;
            case R.id.btnNumber5:
                edtNumber.append("5");
                break;
            case R.id.btnNumber6:
                edtNumber.append("6");
                break;
            case R.id.btnNumber7:
                edtNumber.append("7");
                break;
            case R.id.btnNumber8:
                edtNumber.append("8");
                break;
            case R.id.btnNumber9:
                edtNumber.append("9");
                break;
            case R.id.btnAdd:
                edtNumber.append("+");

                break;
            case R.id.btnMinus:
                edtNumber.append("-");
                break;
            case R.id.btnMultiplication:
                edtNumber.append("*");
                break;
            case R.id.btnDivide:
                edtNumber.append("/");
                break;
            case R.id.btnDot:
                edtNumber.append(".");
                break;

            case R.id.btnClear:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));

                break;
            case R.id.btnClearAll:
                edtNumber.setText("");
                break;
            case R.id.btnResult:
                // int numberA =Integer.parseInt(String.valueOf(edtNumber.getText()));
                // break;
                //default:
                //  break;
                DecimalFormat df = new DecimalFormat("###.######");
                double result = 0;
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                if (arrayOperation.size() >= arrayNumber.size() || arrayOperation.size() < 1) {
                    tvResult.setText(" Error!");
                } else {
                }


                for (int i = 0; i < (arrayNumber.size() - 1); i++) {
                    switch (arrayOperation.get(i)) {
                        case "+":
                            if (i == 0) {
                                result = arrayNumber.get(i) + arrayNumber.get(i + 1);
                            } else {
                                result = result + arrayNumber.get(i + 1);
                            }
                            break;
                        case "-":
                            if (i == 0) {
                                result = arrayNumber.get(i) - arrayNumber.get(i + 1);
                            } else {
                                result = result - arrayNumber.get(i + 1);
                            }
                            break;
                        case "*":
                            if (i == 0) {
                                result = arrayNumber.get(i) * arrayNumber.get(i + 1);
                            } else {
                                result = result * arrayNumber.get(i + 1);
                            }
                            break;
                        case "/":
                            if (i == 0) {
                                result = arrayNumber.get(i) / arrayNumber.get(i + 1);
                            } else {
                                result = result / arrayNumber.get(i + 1);
                            }
                            break;
                        default:
                            break;
                    }
                }

                tvResult.setText(df.format(result));
        }
    }


    public ArrayList<String> arrayOperation;
    public ArrayList<Double> arrayNumber;

    public int addOperation(String input) {
        arrayOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrayOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrayOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrayOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrayOperation.add(cArray[i] + "");
                    break;
                default:
                    break;

            }
        }
        return 0;
    }
    public void addNumber(String stringInput) {
        arrayNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            arrayNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}



