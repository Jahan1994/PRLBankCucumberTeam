package bank.com.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//=>aşağıda bulamadığı veriler için programı durdurmayıp devam ettiriyor
public class Country {

    //country için ayrı bir sınıf oluştrurp contrinin içerdiği bilgiler için burada private adımlar açıyoruz
    //Costemerdan cpontry yerine bu class ın adını yazmalıyım

    /*
    "country": {
            "id": 3,
            "name": "USA",
            "states": null
        },
     */
    private int id;
    private String name;
    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }





}
