package mytrain.bluestars.me.payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import mytrain.bluestars.me.R

class BuyTicket : AppCompatActivity() {
    val traveller = arrayOf("اختر عدد المسافرين",1,2,3,4)
    val travel_time = arrayOf("اختر توقيت السفر ","صباحاً","مساءاً")
    private lateinit var b_next: Button
    lateinit var dateEdt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_ticket)

        b_next = findViewById(R.id.b_next)


        val s_travel_place =findViewById<Spinner>(R.id.s_travel_place)
        val s_arrive_place =findViewById<Spinner>(R.id.s_arrive_place)
        val et_travel_date =findViewById<DatePicker>(R.id.et_travel_date)



        val arrayAdapter = ArrayAdapter.createFromResource(this,R.array.city,android.R.layout.simple_spinner_item)
        s_travel_place.adapter=arrayAdapter
        s_arrive_place.adapter=arrayAdapter
        object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }.also { s_travel_place.onItemSelectedListener = it }


        //traveller
        val s_traveller_number =findViewById<Spinner>(R.id.s_traveller_number)
        val arrayAdapter_traveller = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,traveller)
        s_traveller_number.adapter=arrayAdapter_traveller
        object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }.also { s_travel_place.onItemSelectedListener = it }


        //degree

        val s_ticket_degree =findViewById<Spinner>(R.id.s_ticket_degree)
        val arrayAdapter_degree = ArrayAdapter.createFromResource(
            this,
            R.array.ticket_degree,
            android.R.layout.simple_spinner_item
        )
        s_ticket_degree.adapter=arrayAdapter_degree
        object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }.also { s_travel_place.onItemSelectedListener = it }


        //time

        val s_travel_time =findViewById<Spinner>(R.id.s_travel_time)
        val arrayAdapter_time = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,travel_time)
        s_travel_time.adapter=arrayAdapter_time
        object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }.also { s_travel_place.onItemSelectedListener = it }



        b_next.setOnClickListener {
            val intent = Intent(this@BuyTicket, TicketInfo::class.java)
            intent.putExtra("from", s_travel_place.selectedItem.toString())
            intent.putExtra("to",s_arrive_place.selectedItem.toString())
            //intent.putExtra("date",et_travel_date.)
            intent.putExtra("traveler_number",s_traveller_number.selectedItem.toString())
            intent.putExtra("ticket_degree",s_ticket_degree.selectedItem.toString())
            intent.putExtra("travel_time",s_travel_time.selectedItem.toString())
            startActivity(intent)
        }







    }
}