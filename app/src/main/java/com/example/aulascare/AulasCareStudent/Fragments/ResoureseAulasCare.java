package com.example.aulascare.AulasCareStudent.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aulascare.AulasCareStudent.Adapter.CardAdapter;
import com.example.aulascare.AulasCareStudent.Adapter.CardAdapterDrive;
import com.example.aulascare.AulasCareStudent.Adapter.OrganizationAdapterCard;
import com.example.aulascare.AulasCareStudent.Adapter.OrganizationCard;
import com.example.aulascare.AulasCareStudent.Adapter.QuestionCardAdapter;
import com.example.aulascare.AulasCareStudent.ModelClass.QuestionCards;
import com.example.aulascare.AulasCareStudent.ModelClass.VaccineCard;
import com.example.aulascare.AulasCareStudent.ModelClass.VaccineDrive;
import com.example.aulascare.R;

import java.util.ArrayList;

public class ResoureseAulasCare extends Fragment {

    View view;
    Button seeAllButton;
    ArrayList<VaccineCard> card = new ArrayList<>();
    RecyclerView recyclerView;

    RecyclerView.Adapter cardAdapter;
    RecyclerView.LayoutManager cardLayoutManager;

    ArrayList<VaccineDrive> vaccineDrive = new ArrayList<>();
    RecyclerView recyclerView_drive;

    RecyclerView.Adapter cardAdapterDrive;
    RecyclerView.LayoutManager cardLayoutManagerDrive;

    ArrayList<QuestionCards> questionCards = new ArrayList<>();
    RecyclerView recyclerViewQuestion;

    RecyclerView.Adapter cardAdapterQuestion;
    RecyclerView.LayoutManager cardLayoutManagerQuestion;

    ArrayList<OrganizationCard> organizationCards = new ArrayList<>();
    RecyclerView recyclerViewOrganization;

    RecyclerView.Adapter cardAdapterOrganization;
    RecyclerView.LayoutManager cardLayoutManagerOrganization;

    public ResoureseAulasCare() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getContext() fragment
        view= inflater.inflate(R.layout.fragment_resourese_aulas_care, container, false);

        setupviews();
        createCard();
        buildRecyclerView();

        //card2 _for vaccination drive
        createCardDrive();
        buidRecylerViewDrive();

        //cards 3 for question cards

        registerVaccine();
        buildRecyclerViewRegister();

        //cards 4 for health organization

        createCardOrganization();
        buildRecyclerViewOrganization();
        NavController navController = NavHostFragment.findNavController(this);
        seeAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections=ResoureseAulasCareDirections.actionResoureseAulasCareToKnowYpursVaccine();
                navController.navigate(navDirections);
            }
        });
        return view;
    }

    private void setupviews() {
        seeAllButton=view.findViewById(R.id.see_all);

    }

    public void createCard() {
        card = new ArrayList<>();
        card.add(new VaccineCard("Covishield", "Serum Institute of India", R.drawable.covidshield_1));
        card.add(new VaccineCard("Covaxin", "Bharat Biotech", R.drawable.covidshield_1));
        card.add(new VaccineCard("Sputnik V", "Gamaleya", R.drawable.sputnik));
        card.add(new VaccineCard("mRNA-1273", "Moderna", R.drawable.moderna));
        card.add(new VaccineCard("ZyCoV-D", "Zydus Cadila", R.drawable.zycob));
        card.add(new VaccineCard("Ad26.COV2.S", "Jhonson & Jonson's Janssen", R.drawable.janssen));
        card.add(new VaccineCard("AZD1222", "Oxford/AstraZeneca", R.drawable.astrazeneca));

    }

    public void buildRecyclerView() {
        recyclerView = view.findViewById(R.id.cardRecyclerView);
        recyclerView.setHasFixedSize(true);
        cardLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(cardLayoutManager);
        cardAdapter = new CardAdapter(card);
        recyclerView.setAdapter(cardAdapter);


    }


    //card 2
    public void createCardDrive() {
        vaccineDrive.add(new VaccineDrive("CoWin Registrations", "53.47Crores", " +61.43Laks yesterday"));
        vaccineDrive.add(new VaccineDrive("Vaccinations Delivered", "60.29Crores", "+80.1Laksh yesterday"));
        vaccineDrive.add(new VaccineDrive("Fully Vaccinated", "13.57Crores", "   +21.91Lakhs yesterday"));

    }

    public void buidRecylerViewDrive() {
        recyclerView_drive = view.findViewById(R.id.recycleView_registration_drive);
        recyclerView_drive.setHasFixedSize(true);
        cardLayoutManagerDrive = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_drive.setLayoutManager(cardLayoutManagerDrive);

        cardAdapterDrive = new CardAdapterDrive(vaccineDrive);

        recyclerView_drive.setAdapter(cardAdapterDrive);
    }

    //card3

    public void registerVaccine() {

        questionCards.add(new QuestionCards(R.drawable.vaccine, "Vaccine Registration"));
        questionCards.add(new QuestionCards(R.drawable.about, "About the Vaccine"));
        questionCards.add(new QuestionCards(R.drawable.who, " Who will get the Vaccine?"));
        questionCards.add(new QuestionCards(R.drawable.how, "How will we be vaccinated?"));
        questionCards.add(new QuestionCards(R.drawable.what, "What is expect before vaccination?"));
        questionCards.add(new QuestionCards(R.drawable.whatafter, "What to expect after Vaccination"));

    }

    public void buildRecyclerViewRegister() {


        recyclerViewQuestion = view.findViewById(R.id.cardRecyclerView_for_quesrtion);
        recyclerViewQuestion.setHasFixedSize(true);
        cardLayoutManagerQuestion = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewQuestion.setLayoutManager(cardLayoutManagerQuestion);

        cardAdapterQuestion = new QuestionCardAdapter(questionCards);

        recyclerViewQuestion.setAdapter(cardAdapterQuestion);
    }

    //card4

    public void createCardOrganization() {

        organizationCards = new ArrayList<>();
        organizationCards.add(new OrganizationCard("WHO India", R.drawable.who_india));
        organizationCards.add(new OrganizationCard("National Health portal of India", R.drawable.national_health));
        organizationCards.add(new OrganizationCard("Public Health Foundation of India", R.drawable.public_health));
        organizationCards.add(new OrganizationCard("Ministry of Health and Family Welfare", R.drawable.ministry_of_health_and_family_welfare));
        organizationCards.add(new OrganizationCard("Indian Council of Medical Research", R.drawable.indian_council_of_medical_research));
        organizationCards.add(new OrganizationCard("MSF India", R.drawable.msf));
        organizationCards.add(new OrganizationCard("UNICEF India", R.drawable.unicef));

    }

    public void buildRecyclerViewOrganization() {


        recyclerViewOrganization = view.findViewById(R.id.organization_recyclerView);
        recyclerViewOrganization.setHasFixedSize(true);
        cardLayoutManagerOrganization = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewOrganization.setLayoutManager(cardLayoutManagerOrganization);

        cardAdapterOrganization = new OrganizationAdapterCard(organizationCards);

        recyclerViewOrganization.setAdapter(cardAdapterOrganization);

    }

   
}