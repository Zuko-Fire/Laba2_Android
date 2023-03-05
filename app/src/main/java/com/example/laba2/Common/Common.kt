
import com.example.laba2.Interface.RetrofitServices
import com.example.laba2.Retrofit.RetrofitClient


object Common {
    private val BASE_URL = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}
