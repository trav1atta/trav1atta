package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    float coat = 70; // пальто
    byte coatDiscount = 77; // скидка (в процентах)
    float hat = 25; // шляпа
    byte hatDiscount = 37;
    float costume = 53; // деловой костюм
    byte costumeDiscount = 44;
    float shirt = 19; // сорочка
    byte shirtDiscount = 0;
    float shoes = 41; // туфли
    byte shoesDiscount = 32;
    float account = 312; // счёт пользователя


    private float calculation() {

        float count = (coat * (100 - coatDiscount) + hat * (100 - hatDiscount)
                + costume * (100 - costumeDiscount) + shirt * (100 - shirtDiscount)
                + shoes * (100 - shoesDiscount)) / 100;
        return count;
    }

    // метод определения возможностей бюджета покупки серверного комплекта
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    private float balance() {
        if (possibility()) { // если имеется возможность купить серверный комплект
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }


    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки


    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить серверный комплект
            possibilityOut.setText("Имеется достаточно средств для покупки делового гардероба ");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки делового гардероба ");
            balanceOut.setText(" - ");
        }
    }

}

