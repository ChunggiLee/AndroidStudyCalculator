package chung.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Button 을 호출하는 데는 2가지 방법이 있습니다. 아래의 setOnClickListener, onClick 함수를 모든 버튼에 써주는 방법입니다.
    // 이 방법은 모든 버튼에 써주기 때문에 어떤 버튼을 호출해야할지 구분이 쉽습니다.
    // 지금 여기에 사용한 한개의 onClick 함수를 사용하는 방법이 있습니다.
    // case 구문에서 R.id. 값을 통해 버튼을 구분하는 방법입니다.
    ArrayList arrayList = new ArrayList();

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레이아웃에 입력한 버튼들의 아이디를 가져오는 코드입니다. 즉, 레이아웃의 버튼과 java file의 변수를 mapping 합니다.
        Button btn_c = (Button) findViewById(R.id.btn_c);
        Button btn_dell = (Button) findViewById(R.id.btn_dell);
        Button btn_point = (Button) findViewById(R.id.btn_point);

        Button btn_0 = (Button) findViewById(R.id.btn_0);
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        Button btn_5 = (Button) findViewById(R.id.btn_5);
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        Button btn_7 = (Button) findViewById(R.id.btn_7);
        Button btn_8 = (Button) findViewById(R.id.btn_8);
        Button btn_9 = (Button) findViewById(R.id.btn_9);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        Button btn_minus = (Button) findViewById(R.id.btn_minus);
        Button btn_multiple = (Button) findViewById(R.id.btn_multiple);
        Button btn_divide = (Button) findViewById(R.id.btn_divide);

        Button btn_equal = (Button) findViewById(R.id.btn_equal);

        // 버튼이 클릭 되는 이벤트가 발생하면 리스너에서 이벤트를 처리합니다.
        btn_c.setOnClickListener(this);
        btn_dell.setOnClickListener(this);
        btn_point.setOnClickListener(this);

        btn_add.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiple.setOnClickListener(this);
        btn_divide.setOnClickListener(this);

        btn_equal.setOnClickListener(this);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        // 버튼을 id로 구분하는 코드입니다
        EditText inputedt = (EditText) findViewById(R.id.input);
        switch (v.getId()) {


            case R.id.btn_point:
                // setText는 레이아웃에서 말고 java파일에서 레이아웃의 TextView, EditView의 text를 변경합니다
                inputedt.setText(inputedt.getText().toString() + ".");
                // getText는 EditText inputedt를 Text형식으로 가져오고 toString 함수를 통해 string 으로 타입을 변경합니다.
                break;
            case R.id.btn_c:

                arrayList.clear();
                inputedt.setText("");


                break;


            case R.id.btn_dell:


                if (inputedt.getText().toString() != "") {
                    inputedt.setText("");
                }
                break;

            case R.id.btn_0:
                inputedt.setText(inputedt.getText().toString() + "0");
                break;
            case R.id.btn_1:
                inputedt.setText(inputedt.getText().toString() + "1");
                break;
            case R.id.btn_2:
                inputedt.setText(inputedt.getText().toString() + "2");
                break;
            case R.id.btn_3:
                inputedt.setText(inputedt.getText().toString() + "3");
                break;
            case R.id.btn_4:
                inputedt.setText(inputedt.getText().toString() + "4");
                break;
            case R.id.btn_5:
                inputedt.setText(inputedt.getText().toString() + "5");
                break;
            case R.id.btn_6:
                inputedt.setText(inputedt.getText().toString() + "6");
                break;
            case R.id.btn_7:
                inputedt.setText(inputedt.getText().toString() + "7");
                break;
            case R.id.btn_8:
                inputedt.setText(inputedt.getText().toString() + "8");
                break;
            case R.id.btn_9:
                inputedt.setText(inputedt.getText().toString() + "9");
                break;


            case R.id.btn_add:
                arrayList.add(inputedt.getText().toString());
                inputedt.setText("");
                count = 1;
                break;

            case R.id.btn_minus:
                arrayList.add(inputedt.getText().toString());
                inputedt.setText("");
                count = 2;
                break;

            case R.id.btn_multiple:
                arrayList.add(inputedt.getText().toString());
                inputedt.setText("");
                count = 3;
                break;

            case R.id.btn_divide:
                arrayList.add(inputedt.getText().toString());
                inputedt.setText("");
                count = 4;
                break;


            case R.id.btn_equal:

                int sum1 = 0, sum2 = 0, sum3, count2 = 0;

                float fsum1 = 0, fsum2 = 0, fsum3 = 0;


                if (arrayList.isEmpty()) {


                    inputedt.setText("");
                } else {

                    Object obj = arrayList.get(0);
                    String num1 = (String) obj;
                    String num2 = inputedt.getText().toString();

                    if (num1.contains(".") || num2.contains(".")) {

                        count2 = 1;
                        fsum1 = Float.parseFloat(num1); // 실수로 가져옵니다.
                        fsum2 = Float.parseFloat(num2);

                    } else {
                        sum1 = Integer.parseInt(num1); // 정수로 가져옵니다.
                        sum2 = Integer.parseInt(num2);
                        sum3 = 0;
                    }
                    String val = "";
                    String result;
                    switch (count) {
                        case 0:

                            inputedt.setText("");


                        case 1:

                            if (count2 == 1) {

                                fsum3 = fsum1 + fsum2;

                                val = String.valueOf(fsum3);
                            } else {
                                sum3 = sum1 + sum2;
                                val = String.valueOf(sum3);

                            }
                            result = String.format("%.2f", Float.parseFloat(val)); // 소수점 2자리에서 반올립니다.
                            inputedt.setText(result);
                            arrayList.clear();
                            break;

                        case 2:

                            if (count2 == 1) {

                                fsum3 = fsum1 - fsum2;
                                val = String.valueOf(fsum3);
                            } else {
                                sum3 = sum1 - sum2;
                                val = String.valueOf(sum3);

                            }
                            result = String.format("%.2f", Float.parseFloat(val));
                            inputedt.setText(result);
                            arrayList.clear();
                            break;

                        case 3:

                            if (count2 == 1) {

                                fsum3 = fsum1 * fsum2;
                                val = String.valueOf(fsum3);
                            } else {
                                sum3 = sum1 * sum2;
                                val = String.valueOf(sum3);

                            }
                            result = String.format("%.2f", Float.parseFloat(val));
                            inputedt.setText(result);
                            arrayList.clear();
                            break;

                        case 4:

                            if (count2 == 1) {

                                fsum3 = fsum1 / fsum2;
                                val = String.valueOf(fsum3);
                            } else {
                                sum3 = sum1 / sum2;
                                val = String.valueOf(sum3);

                            }
                            result = String.format("%.2f", Float.parseFloat(val));
                            inputedt.setText(result);
                            arrayList.clear();
                            break;
                    }


                }


                break;

        }


    }
}
