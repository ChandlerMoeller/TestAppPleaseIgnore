package com.drmidnight.materialtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Menu {
    static final String CM = "20";
    static final String CS = "05";
    static final String PK = "25";
    static final String EO = "30";
    static final String NT = "40";

    private ArrayList<MenuItem> breakfast;
    private ArrayList<MenuItem> lunch;
    private ArrayList<MenuItem> dinner;

    public Menu(int day, int month, int year, String loc) throws IOException {
        breakfast = new ArrayList<MenuItem>(0);
        lunch     = new ArrayList<MenuItem>(0);
        dinner    = new ArrayList<MenuItem>(0);
        Document doc = Jsoup.connect("http://nutrition.sa.ucsc.edu/menuSamp.asp?myaction=read&sName=&dtdate="+month+"%2F"+day+"%2F"+year+"&locationNum="+loc+"&naFlag=1").get();
        Elements span = doc.getElementsByTag("span");
        Iterator<Element> itor = span.iterator();
        ArrayList<Element> elems = new ArrayList<Element>(0);
        while (itor.hasNext()) {
            Element next = itor.next();
            if (!next.html().startsWith("&")) {
                elems.add(next);
            }
        }
        for (int i = 0; i < elems.size(); i++) {
            Element crawler = elems.get(i);
            if (crawler.html().equals("French Toast"));
            outer: while (!crawler.tag().equals("tbody")) {
                crawler = crawler.parent();
                Iterator<Element> divsitor = crawler.getElementsByTag("div").iterator();
                while (divsitor.hasNext()) {
                    Element next = divsitor.next();
                    if (next.html().equals("Breakfast")) {
                        MenuItem item = new MenuItem(elems.get(i));
                        Element td = elems.get(i).parent().parent().parent();
                        Iterator<Element> attrs = td.getElementsByTag("img").iterator();
                        while (attrs.hasNext()) {
                            Element nextElem = attrs.next();
                            item.addAttribute(nextElem.attr("src"));
                        }
                        breakfast.add(item);
                        break outer;
                    }
                    else if (next.html().equals("Lunch")) {
                        MenuItem item = new MenuItem(elems.get(i));
                        Element td = elems.get(i).parent().parent().parent();
                        Iterator<Element> attrs = td.getElementsByTag("img").iterator();
                        while (attrs.hasNext()) {
                            Element nextElem = attrs.next();
                            item.addAttribute(nextElem.attr("src"));
                        }
                        lunch.add(item);
                        break outer;
                    }
                    else if (next.html().equals("Dinner")) {
                        MenuItem item = new MenuItem(elems.get(i));
                        Element td = elems.get(i).parent().parent().parent();
                        Iterator<Element> attrs = td.getElementsByTag("img").iterator();
                        while (attrs.hasNext()) {
                            Element nextElem = attrs.next();
                            item.addAttribute(nextElem.attr("src"));
                        }
                        dinner.add(item);
                        break outer;
                    }
                }
            }
        }
    }

    public ArrayList<MenuItem> getBreakfast() {
        return breakfast;
    }

    public ArrayList<MenuItem> getLunch() {
        return lunch;
    }

    public ArrayList<MenuItem> getDinner() {
        return dinner;
    }

    /*
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu(31, 1, 2015, NT);
        if (menu.breakfast.size() > 0) {
            System.out.println("\nBreakfast:\n");
            for (int i = 0; i < menu.breakfast.size(); i++) {
                System.out.print(menu.breakfast.get(i).getElement().html()+":   ");
                Iterator<MenuItem.Attribute> itorr = menu.breakfast.get(i).getAttributeIterator();
                while (itorr.hasNext()) {
                    System.out.print(itorr.next()+(" "));
                }
                System.out.println();
            }
        }
        if (menu.lunch.size() > 0) {
            System.out.println("\nLunch:\n");
            for (int i = 0; i < menu.lunch.size(); i++) {
                System.out.print(menu.lunch.get(i).getElement().html()+":   ");
                Iterator<MenuItem.Attribute> itorr = menu.lunch.get(i).getAttributeIterator();
                while (itorr.hasNext()) {
                    System.out.print(itorr.next()+(" "));
                }
                System.out.println();
            }
        }
        if (menu.dinner.size() > 0) {
            System.out.println("\nDinner:\n");
            for (int i = 0; i < menu.dinner.size(); i++) {
                System.out.print(menu.dinner.get(i).getElement().html()+":   ");
                Iterator<MenuItem.Attribute> itorr = menu.dinner.get(i).getAttributeIterator();
                while (itorr.hasNext()) {
                    System.out.print(itorr.next()+(" "));
                }
                System.out.println();
            }
        }
    } */
}