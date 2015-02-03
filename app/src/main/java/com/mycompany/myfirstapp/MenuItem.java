package com.mycompany.myfirstapp;

import java.util.Iterator;

import org.jsoup.nodes.Element;


public class MenuItem {

    enum Attribute {
        EGG, FISH, GLUTEN_FREE, DAIRY,
        NUTS, SOY, VEGAN, VEGETARIAN,
        PORK, BEEF;
    }

    private Element elem;
    private Attribute[] attrs;

    public MenuItem(Element elem) {
        this.elem  = elem;
    }

    public Element getElement() {
        return elem;
    }

    public void setElement(Element elem) {
        this.elem = elem;
    }

    public void addAttribute(String attrstr) {
        Attribute attr = null;
        if (attrstr.contains("eggs")) {
            attr = Attribute.EGG;
        }
        else if (attrstr.contains("fish")) {
            attr = Attribute.FISH;
        }
        else if (attrstr.contains("gluten")) {
            attr = Attribute.GLUTEN_FREE;
        }
        else if (attrstr.contains("milk")) {
            attr = Attribute.DAIRY;
        }
        else if (attrstr.contains("fish")) {
            attr = Attribute.FISH;
        }
        else if (attrstr.contains("nuts")) {
            attr = Attribute.NUTS;
        }
        else if (attrstr.contains("soy")) {
            attr = Attribute.SOY;
        }
        else if (attrstr.contains("vegan")) {
            attr = Attribute.VEGAN;
        }
        else if (attrstr.contains("veggie")) {
            attr = Attribute.VEGETARIAN;
        }
        else if (attrstr.contains("pork")) {
            attr = Attribute.PORK;
        }
        else if (attrstr.contains("beef")) {
            attr = Attribute.BEEF;
        }
        if (attrs == null) {
            attrs = new Attribute[1];
            attrs[0] = attr;
            return;
        }
        Attribute[] temp = new Attribute[attrs.length+1];
        for (int i = 0; i < attrs.length; i++) {
            temp[i] = attrs[i];
        }
        temp[temp.length-1] = attr;
        attrs = temp;
    }

    public Attribute[] getAttributes() {
        return attrs;
    }

    public Iterator<Attribute> getAttributeIterator() {
        return new attributeIterator(attrs);
    }

    private class attributeIterator implements Iterator<Attribute> {

        private Attribute[] attrs;
        private int index;

        public attributeIterator(Attribute[] attrs) {
            this.attrs = attrs;
        }

        @Override
        public boolean hasNext() {
            return attrs != null && index < attrs.length;
        }

        @Override
        public Attribute next() {
            return attrs[index++];
        }

        @Override
        public void remove() {
            index++;
        }

    }
}
