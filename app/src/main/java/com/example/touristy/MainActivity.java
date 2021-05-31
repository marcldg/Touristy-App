package com.example.touristy;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements VerticalAdapter.OnColClickListener
{
    // Declaring variables and arrays.
    Integer location = 0;

    RecyclerView recyclerView;
    RecyclerView recyclerViewHorizontal;

    String[] destinations;
    String[] description;
    String[] placesToGoAus;
    String[] placesToGoDub;
    String[] placesToGoGreece;
    String[] placesToGoItaly;
    String[] placesToGoLondon;
    String[] placesToGoMauritius;
    String[] placesToGoNewyork;
    String[] placesToGoParis;
    String[] placesToGoSeychelles;
    String[] placesToGoAusDescription;
    String[] placesToGoDubDescription;
    String[] placesToGoGreeceDescription;
    String[] placesToGoItalyDescription;
    String[] placesToGoLondonDescription;
    String[] placesToGoMauritiusDescription;
    String[] placesToGoNewyorkDescription;
    String[] placesToGoParisDescription;
    String[] placesToGoSeychellesDescription;

    // Populating arrays with their corresponding images.
    int[] images = {R.drawable.australia, R.drawable.dubai, R.drawable.greece, R.drawable.italy, R.drawable.london, R.drawable.mauritius, R.drawable.newyork, R.drawable.paris, R.drawable.seychelles};
    int[] ausImages = {R.drawable.sydneyoperahouse, R.drawable.greatbarrierreef, R.drawable.sydneyharbourbridge, R.drawable.seaworld, R.drawable.queenvictoriamarket, R.drawable.bondibeach, R.drawable.greatoceanroad, R.drawable.kangarooisland, R.drawable.crownmelbourne};
    int[] dubaiImages = {R.drawable.burjkhalifa, R.drawable.burjalarab, R.drawable.dubaimall, R.drawable.dubaicreek, R.drawable.dubaifountain, R.drawable.skidubai, R.drawable.emiratesmall, R.drawable.jumeirahbeach, R.drawable.goldsouk};
    int[] greeceImages = {R.drawable.santorini, R.drawable.athens, R.drawable.mykonos, R.drawable.rhodes, R.drawable.napflion, R.drawable.corfu, R.drawable.metorea, R.drawable.delphi, R.drawable.olympia};
    int[] italyImages = {R.drawable.rome, R.drawable.venice, R.drawable.florence, R.drawable.naples, R.drawable.milan, R.drawable.cinqueterre, R.drawable.pisa, R.drawable.amalfi, R.drawable.capri};
    int[] londonImages = {R.drawable.britishmuseum, R.drawable.toweroflondon, R.drawable.bigben, R.drawable.buckinghampalace, R.drawable.towerbridge, R.drawable.londoneye, R.drawable.warnerbrosstudio, R.drawable.theshard, R.drawable.kewgardens};
    int[] mauritiusImages = {R.drawable.sevencoloredearth, R.drawable.lemornebrabant, R.drawable.ileauxcerfs, R.drawable.chateaulabourdonnais, R.drawable.casela, R.drawable.champdemars, R.drawable.portlouismarket, R.drawable.bagatellemall, R.drawable.trouauxbiches};
    int[] newyorkImages = {R.drawable.centralpark, R.drawable.statueofliberty, R.drawable.empirestatebuilding, R.drawable.timesquare, R.drawable.brooklynbridge, R.drawable.broadway, R.drawable.bronxzoo, R.drawable.rockefellercentre, R.drawable.newyorkmuseum};
    int[] parisImages = {R.drawable.eiffeltower, R.drawable.louvremuseum, R.drawable.arcdetriomphe, R.drawable.versaillespalace, R.drawable.champselysees, R.drawable.sacrecoeur, R.drawable.museedorsay, R.drawable.montmarte, R.drawable.moulinrouge};
    int[] seychellesImages = {R.drawable.ladigue, R.drawable.praslin, R.drawable.curieuse, R.drawable.anselazio, R.drawable.iledunord, R.drawable.beauvallonbeach, R.drawable.fregate, R.drawable.bird, R.drawable.desroches};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialising variables.
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewHorizontal = findViewById(R.id.recyclerViewHorizontal);

        destinations = getResources().getStringArray(R.array.destinations);
        description = getResources().getStringArray(R.array.description);
        placesToGoAus = getResources().getStringArray(R.array.placesToGoAus);
        placesToGoDub = getResources().getStringArray(R.array.placesToGoDub);
        placesToGoGreece = getResources().getStringArray(R.array.placesToGoGreece);
        placesToGoItaly = getResources().getStringArray(R.array.placesToGoItaly);
        placesToGoLondon = getResources().getStringArray(R.array.placesToGoLondon);
        placesToGoMauritius = getResources().getStringArray(R.array.placesToGoMauritius);
        placesToGoNewyork = getResources().getStringArray(R.array.placesToGoNewYork);
        placesToGoParis = getResources().getStringArray(R.array.placesToGoParis);
        placesToGoSeychelles = getResources().getStringArray(R.array.placesToGoSeychelles);
        placesToGoAusDescription = getResources().getStringArray(R.array.placesToGoAusDescription);
        placesToGoDubDescription = getResources().getStringArray(R.array.placesToGoDubDescription);
        placesToGoGreeceDescription = getResources().getStringArray(R.array.placesToGoGreeceDescription);
        placesToGoItalyDescription = getResources().getStringArray(R.array.placesToGoItalyDescription);
        placesToGoLondonDescription = getResources().getStringArray(R.array.placesToGoLondonDescription);
        placesToGoMauritiusDescription = getResources().getStringArray(R.array.placesToGoMauritiusDescription);
        placesToGoNewyorkDescription = getResources().getStringArray(R.array.placesToGoNewYorkDescription);
        placesToGoParisDescription = getResources().getStringArray(R.array.placesToGoParisDescription);
        placesToGoSeychellesDescription = getResources().getStringArray(R.array.placesToGoSeychellesDescription);

        // Creating an adapter to handle the horizontal recycler view.
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(this, destinations, description, images, this::onDestinationClick);

        recyclerViewHorizontal.setAdapter(horizontalAdapter);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        displayObjects(this, placesToGoAus, placesToGoAusDescription, ausImages,this);
    }

    // Function to display the recycler view on the screen.
    public void displayObjects(Context context, String[] places, String[] placeDescription, int[] pics, VerticalAdapter.OnColClickListener onColClickListener)
    {
        // Creating an adapter to handle the vertical recycler view.
        VerticalAdapter verticalAdapter = new VerticalAdapter(this, places, pics, onColClickListener);

        recyclerView.setAdapter(verticalAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Function to handle the click on each desitnation.
    public void onDestinationClick(int position)
    {
        switch (position)
        {
            case 0:
                displayObjects(this, placesToGoAus, placesToGoAusDescription, ausImages,this);
                location = 0;
                break;
            case 1:
                displayObjects(this, placesToGoDub, placesToGoDubDescription, dubaiImages, this);
                location = 1;
                break;
            case 2:
                displayObjects(this, placesToGoGreece, placesToGoGreeceDescription, greeceImages, this);
                location = 2;
                break;
            case 3:
                displayObjects(this, placesToGoItaly, placesToGoItalyDescription, italyImages, this);
                location = 3;
                break;
            case 4:
                displayObjects(this, placesToGoLondon, placesToGoLondonDescription, londonImages, this);
                location = 4;
                break;
            case 5:
                displayObjects(this, placesToGoMauritius, placesToGoMauritiusDescription, mauritiusImages, this);
                location = 5;
                break;
            case 6:
                displayObjects(this, placesToGoNewyork, placesToGoNewyorkDescription, newyorkImages, this);
                location = 6;
                break;
            case 7:
                displayObjects(this, placesToGoParis, placesToGoParisDescription, parisImages, this);
                location = 7;
                break;
            case 8:
                displayObjects(this, placesToGoSeychelles, placesToGoSeychellesDescription, seychellesImages, this);
                location = 8;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }

    // Function to handle displaying the place clicked in a new fragment containing the picture of the place and the corresponding description.
    @Override
    public void onItemClick(int position)
    {
        String[] placesToGoDescription = new String[0];
        int[] placesPicture = new int[0];
        Fragment fragment;
        Bundle bundle = new Bundle();
        
        if (location == 0)
        {
            placesToGoDescription = placesToGoAusDescription;
            placesPicture = ausImages;
        }
        else if (location == 1)
        {
            placesToGoDescription = placesToGoDubDescription;
            placesPicture = dubaiImages;
        }
        else if (location == 2)
        {
            placesToGoDescription = placesToGoGreeceDescription;
            placesPicture = greeceImages;
        }
        else if (location == 3)
        {
            placesToGoDescription = placesToGoItalyDescription;
            placesPicture = italyImages;
        }
        else if (location == 4)
        {
            placesToGoDescription = placesToGoLondonDescription;
            placesPicture = londonImages;
        }
        else if (location == 5)
        {
            placesToGoDescription = placesToGoMauritiusDescription;
            placesPicture = mauritiusImages;

        }
        else if (location == 6)
        {
            placesToGoDescription = placesToGoNewyorkDescription;
            placesPicture = newyorkImages;
        }
        else if (location == 7)
        {
            placesToGoDescription = placesToGoParisDescription;
            placesPicture = parisImages;
        }
        else if (location == 8)
        {
            placesToGoDescription = placesToGoSeychellesDescription;
            placesPicture = seychellesImages;
        }

        switch (position)
        {
            case 0:
                bundle.putString("description", placesToGoDescription[position]);
                bundle.putInt("image", placesPicture[position]);
                fragment = new MoreDetails();
                break;
            case 1:
                bundle.putString("description", placesToGoDescription[position]);
                bundle.putInt("image", placesPicture[position]);
                fragment = new MoreDetails();
                break;
            case 2:
                bundle.putString("description", placesToGoDescription[position]);
                bundle.putInt("image", placesPicture[position]);
                fragment = new MoreDetails();
                break;
            case 3:
                bundle.putString("description", placesToGoDescription[position]);
                bundle.putInt("image", placesPicture[position]);
                fragment = new MoreDetails();
                break;
            case 4:
                bundle.putString("description", placesToGoDescription[position]);
                bundle.putInt("image", placesPicture[position]);
                fragment = new MoreDetails();
                break;
            case 5:
                bundle.putString("description", placesToGoDescription[position]);
                bundle.putInt("image", placesPicture[position]);
                fragment = new MoreDetails();
                break;
            case 6:
                bundle.putString("description", placesToGoDescription[position]);
                bundle.putInt("image", placesPicture[position]);
                fragment = new MoreDetails();
                break;
            case 7:
                bundle.putString("description", placesToGoDescription[position]);
                bundle.putInt("image", placesPicture[position]);
                fragment = new MoreDetails();
                break;
            case 8:
                bundle.putString("description", placesToGoDescription[position]);
                bundle.putInt("image", placesPicture[position]);
                fragment = new MoreDetails();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment4, fragment);
        fragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}