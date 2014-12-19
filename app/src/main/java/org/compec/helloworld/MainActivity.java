package org.compec.helloworld;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

//    private TextView textView;
//    private Button button;
//    private EditText editText;
//    private ImageView imageView;
    //^^^^^^^^^^^^^^^
    //|  |   |   |  |
    //L---------------------------------------------------------------------------------------\
                                                                                        //    |
    @Override                                                                           //    |
    protected void onCreate(Bundle savedInstanceState) {                                //    |
        super.onCreate(savedInstanceState); //onCreate içerisinde çağrılması zorunlu          |
        //                                                                                    |
        //Resource'lara ulaşmak için şu formül var:                                           |
        // R.<klasör>.<dosyaadı>                                                              |
        //                                                                                    |
        setContentView(R.layout.activity_main); //Activity içeriğini oluşturan View'i         |
        // |       |                                                                          |
        // L-------+------->Layout klasöründeki                                               |
        //         L------->activity_main dosyası yap.                                        |
        //                  diyoruz                                         //   /------------/
        //                                                                       |
        //Normalde içerikteki View'leri burada tanımlamak hoş değil bunları  [şuraya]  alabiliriz

        //Önceden setContentView çağırdığımız için şu an Activity üzerinden findViewById
        //çağırarak istediğimiz View'lere ulaşabiliriz.
        final TextView textView = (TextView) findViewById(R.id.textView1);
        //                          |                      L--->Resource formatı aynı. Sadece id
        //                          |                     diye bi klasör yok. id'ler tüm layout
        //                          |                     klasöründeki xml'lerden toparlanıyor.
        //                          |
        //                          L--> Buradaki casting gerekli, çünkü findViewById bize
        //                               View dönüyor ama ne tarz bir View olduğunuz söylemiyor.
        //                               Bunu cast yaparak biz söylüyoruz.
        //
        //Casting kullanmadan Sadece View olarak isteyebiliriz bunu:
        //View view = findViewById(R.id.textView1);
        //
        // Ancak bu şekilde TextView class'ına ait özellikleri (mesela TextView.setText(String)) kullanamayız.

        Button button = (Button) findViewById(R.id.btn_banatikla);
        final EditText edtText = (EditText) findViewById(R.id.editText);
        ImageView image = (ImageView) findViewById(R.id.imageView);

        //ImageView de gösterilen image'i Resourcelardan belirleyebiliriz.
        image.setImageResource(R.drawable.ic_launcher);

        //Resmi resource'lardan değil dışarıdan seçmek istersek önce istediğimiz resmi
        //Bitmap nesnesi şeklinde yükleyip şu metodu kullanabiliriz:
        //
        //      image.setImageBitmap(bitmap);
        //
        //(Bitmap yükleme olayı sonra :D)


        //OnClickListener View class'ına ait bir interface'dir.
        //
        //Burada hemen bir OnClickListener nesnesi oluşturulup
        //View.setOnClickListener methoduna verilmiş.
        //
        //OnClickListener'ı ayrı bir nesne olarak tanımlayıp method'a verebiliriz.
        //
        //[KOD]
        //      View.OnClickListener ocl = new View.OnClickListener(){
        //          @Override
        //          public void onClick(View v) {
        //              //statements;
        //          }
        //      }
        //      button.setOnClickListener(ocl);
        //[/KOD]

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextinTexti = edtText.getText().toString();
                textView.setText(editTextinTexti);
                textView.setBackgroundColor(Color.BLUE);
            }
        });

    }
}
