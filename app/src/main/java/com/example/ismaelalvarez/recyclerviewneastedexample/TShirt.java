package com.example.ismaelalvarez.recyclerviewneastedexample;

import java.util.List;

/**
 * Created by ismaelalvarez on 07-03-18.
 */

public class TShirt {

    String name;
    List<TShirtFeature> tShirtFeatureList;

    TShirt(String name, List<TShirtFeature> tShirtFeatureList){
        this.name = name;
        this.tShirtFeatureList = tShirtFeatureList;
    }

    public String getName() {
        return name;
    }

    public List<TShirtFeature> gettShirtFeatureList() {
        return tShirtFeatureList;
    }
}
