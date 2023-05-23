package com.company;

import java.util.Comparator;

public class TrofeoDescripcionComparator implements Comparator<Trofeo> {
    @Override
    public int compare(Trofeo o1, Trofeo o2) {
        return o1.getDescripcion().compareTo(o2.getDescripcion());
    }
}
