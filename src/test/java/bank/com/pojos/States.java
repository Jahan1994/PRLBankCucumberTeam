package bank.com.pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class States {

    private int id;
    private String name;
    private Country country;


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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

        private Country tpcountry;

        public States() {
        }

        @Override
        public String toString() {
            return "States{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", tpcountry=" + tpcountry +
                    ", state='" + state + '\'' +
                    '}';
        }

        public States(int id, String name, Country tpcountry, String state) {
            this.id = id;
            this.name = name;
            this.tpcountry = tpcountry;
            this.state = state;
        }

        private String state;

        public Country getTpcountry() {
            return tpcountry;
        }

        public void setTpcountry(Country tpcountry) {
            this.tpcountry = tpcountry;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }


    }



