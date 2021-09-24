package com.example.sampleproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.OnClicktener {

    private Adapter adapter;
    private LinkedList<String> list;
    private RecyclerView recyclerView;

    int[] sum = new int[]{1, 2, 1, 1, 3, 4, 5, 7, 8, 1, 2, 2};
    int occ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new LinkedList<>();
        recyclerView = findViewById(R.id.recyclerView);

        list.add("monika");
        adapter = new Adapter(getApplicationContext(), list, this);
        recyclerView.setAdapter(adapter);

        countNumberOccurence();
        OccurrenceInString();
        duplicateCharacters();



        duplicateWords();


    }

    public void countNumberOccurence() {
        int[] a = {1, 9, 9};
        HashMap<Integer, Integer> elementCountMap = new HashMap<>();
        for (int i : a) {
            if (elementCountMap.containsKey(i)) {
                elementCountMap.put(i, elementCountMap.get(i) + 1);
            } else {
                elementCountMap.put(i, 1);
            }
        }
        Log.d("occurence", "onCreate: " + elementCountMap);
    }

    public void OccurrenceInString() {
        String strArray = "monika monika ";
        char[] chararray = strArray.toCharArray();
        int count = 0;

        for (int i = 0; i < strArray.length(); i++) {
            chararray[i] = strArray.charAt(i);
            for (char c : chararray) {
                if (chararray[i] == c) {
                    count++;
                    Log.d("TAG", "OccurrenceInString: " + c);
                }
            }
        }
    }

    public void duplicateCharacters() {
        String input = "aaaabbccAAdd";
        char search = 'b';
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == search)
                count++;
        }
        Log.d("TAG", "recursion" + "The Character '" + search + "' appears " + count + " times. ");
    }

    public void duplicateWords() {
        List<String> list = new ArrayList<>();
        list.add("monika");
        list.add("monika");
        list.add("duplicate");
        HashSet<String> duplicate = new HashSet<>(list);
        for (String s : duplicate) {
            Log.d("s", s + Collections.frequency(list, s));
        }
    }

    @Override
    public void onClick(int n) {
        if (n == 1) {
            adapter.notifyDataSetChanged();
        }
    }
}