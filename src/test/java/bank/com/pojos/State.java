package bank.com.pojos;

public class State {

    private int id;
    private String name;
    private Country tpcountry;

    public State() {
    }

    public State(int id, String name, Country tpcountry) {
        this.id = id;
        this.name = name;
        this.tpcountry =tpcountry;

    }

    public State(String name, Country tpcountry) {
        this.name = name;
        this.tpcountry =tpcountry;

    }


    @Override
    public String toString() {
        return "State{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tpcountry=" + tpcountry +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getTpcountry() {
        return tpcountry;
    }

    public void setTpcountry(Country tpcountry) {

        this.tpcountry = tpcountry;
    }
}