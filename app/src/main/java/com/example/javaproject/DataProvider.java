package com.example.javaproject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class DataProvider {
    private static final String TAG = "secondaryActivity";
//    Category Hatchback = new Category("Hatchback","text1","text2");
//    Category Sedan = new Category("Sedan","text1","text2");
//    Category Convertible = new Category("Convertible","text1","text2");
//    Category MPV = new Category("MPV","text1","text2");
//    Category StationWagon = new Category("Station Wagon","text1","text2");
//
//    ArrayList<Category> categoryList = new ArrayList<>();
//

    public static Map<Integer, String> generateMaoriDigits() {
        Map<Integer, String> words =
                new LinkedHashMap<Integer, String>();
        words.put(1, "Hatchback");
        words.put(2, "Sedan");
        words.put(3, "Convertible");
        words.put(4, "MPV");
        words.put(5, "Station Wagon");
        return words;}

    public static Map<Integer, String> generateText1() {
        Map<Integer, String> words =
                new LinkedHashMap<Integer, String>();
        words.put(1, "Text1");
        words.put(2, "Text1");
        words.put(3, "Text1");
        words.put(4, "Text1");
        words.put(5, "Text1");
        return words;}

    public static Map<Integer, String> generateText2() {
        Map<Integer, String> words =
                new LinkedHashMap<Integer, String>();
        words.put(1, "Text2");
        words.put(2, "Text2");
        words.put(3, "Text2");
        words.put(4, "Text2");
        words.put(5, "Text2");
        return words;}


    public static List<Number> getNumbers() {
        List<Number> numbersList = new ArrayList<Number>();
        Map<Integer, String> words = generateMaoriDigits();
//        Map<Integer, String> text1 = generateText1();
//        Map<Integer, String> text2 = generateText2();
        for (Integer key : words.keySet() )
        {
            int digit =key;
            String maoriTranslation = words.get(key);
            String category = "category_"+String.valueOf(key);
            String audio="audio_"+ String.valueOf(key);;
            Number n=new Number(digit,maoriTranslation,category,audio);
            numbersList.add(n);
        }
//        for (Integer key : text1.keySet() )
//        {
//            int digit =key;
//            String text = words.get(key);
//            Number n=new Number(digit,text);
//            numbersList.add(n);
//        }
//        for (Integer key : text2.keySet() )
//        {
//            int digit =key;
//            String maoriTranslation = words.get(key);
//            String category = "category_"+String.valueOf(key);
//            String audio="audio_"+ String.valueOf(key);;
//            Number n=new Number(digit,maoriTranslation,category,audio);
//            numbersList.add(n);
//        }
        return numbersList;
    }

}
