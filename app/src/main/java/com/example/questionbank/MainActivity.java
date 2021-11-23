package com.example.questionbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import com.example.questionbank.ApiPackage.ApiClient;
import com.example.questionbank.ApiPackage.LoginService;
import com.example.questionbank.ApiPackage.SignInRequest;
import com.example.questionbank.ApiPackage.SignInResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ArrayList<Questions> queInfo;
    RecyclerView recView1,recView2,recView3,recView4;
    RecyclerView.LayoutManager layoutManager1,layoutManager2,layoutManager3,layoutManager4;
    QuestionAdapter adapter1,adapter2,adapter3,adapter4;

    //Api-Part

    SignInRequest signInRequest;
    SignInResponse signInResponse;
    Retrofit retrofit;
    LoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInit();
        login();

        createCard();
        buildRecyclerView();

        createCard1();
        buildRecyclerView1();

        createCard2();
        buildRecyclerView2();

        createCard3();
        buildRecyclerView3();

    }

    public void createCard(){

        queInfo = new ArrayList<>();

        queInfo.add(new Questions("Thermodynamic Terms",R.drawable.ic_question_banks));
        queInfo.add(new Questions("Behaviour of Real Gases: Deviation from Ideal Behaviour Gas Be…",R.drawable.ic_question_banks));


    }

    public void createCard1(){

        queInfo = new ArrayList<>();

        queInfo.add(new Questions("Thermodynamic Terms",R.drawable.ic_question_banks));
        queInfo.add(new Questions("Behaviour of Real Gases: Deviation from Ideal Behaviour Gas Be…",R.drawable.ic_question_banks));

    }

    public void createCard2(){

        queInfo = new ArrayList<>();

        queInfo.add(new Questions("Behaviour of Real Gases: Deviation from Ideal Behaviour Gas Be…",R.drawable.ic_question_banks));
        queInfo.add(new Questions("Behaviour of Real Gases: Deviation from Ideal Behaviour Gas Be…",R.drawable.ic_question_banks));
        queInfo.add(new Questions("Behaviour of Real Gases: Deviation from Ideal Behaviour Gas Be…",R.drawable.ic_question_banks));
        queInfo.add(new Questions("Behaviour of Real Gases: Deviation from Ideal Behaviour Gas Be…",R.drawable.ic_question_banks));

    }

    public void createCard3(){

        queInfo = new ArrayList<>();

        queInfo.add(new Questions("Behaviour of Real Gases: Deviation from Ideal Behaviour Gas Be…",R.drawable.ic_question_banks));
        queInfo.add(new Questions("Behaviour of Real Gases: Deviation from Ideal Behaviour Gas Be…",R.drawable.ic_question_banks));
    }

    public void buildRecyclerView(){

        recView1 = findViewById(R.id.recView1);
        recView1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recView1.setLayoutManager(layoutManager1);
        adapter1 = new QuestionAdapter(queInfo);
        recView1.setAdapter(adapter1);

    }

    public void buildRecyclerView1(){
        recView2 = findViewById(R.id.recView2);
        recView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recView2.setLayoutManager(layoutManager2);
        adapter2 = new QuestionAdapter(queInfo);
        recView2.setAdapter(adapter2);

    }

    public void buildRecyclerView2(){

        recView3 = findViewById(R.id.recView3);
        recView3.setHasFixedSize(true);
        layoutManager3 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recView3.setLayoutManager(layoutManager3);
        adapter3 = new QuestionAdapter(queInfo);
        recView3.setAdapter(adapter3);
    }

    public void buildRecyclerView3(){

        recView4 = findViewById(R.id.recView4);
        recView4.setHasFixedSize(true);
        layoutManager4 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recView4.setLayoutManager(layoutManager4);
        adapter4 = new QuestionAdapter(queInfo);
        recView4.setAdapter(adapter4);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.questions_menu,menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter1.getFilter().filter(newText);
                adapter2.getFilter().filter(newText);
                adapter3.getFilter().filter(newText);
                adapter4.getFilter().filter(newText);
                return false;
            }
        });


        return true;
    }

    public void apiInit(){
        retrofit = ApiClient.getRetrofit();
        loginService = ApiClient.loginService();
    }

    public void login(){

        signInRequest = new SignInRequest("kallol.medhi@brigosha.com","1234",true);
        Call<SignInResponse> call = loginService.signInApiCall(signInRequest);
        call.enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                signInResponse = response.body();
            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {

            }
        });
    }

}