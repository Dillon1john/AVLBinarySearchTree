package edu.citytech.cst.s23778215.ds.querytemplate;

public class Asset implements  Comparable<Asset>{

    private String name;
    private float value;

    public Asset(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Asset o) {

        return Float.compare(this.value, o.value);
    }
}
