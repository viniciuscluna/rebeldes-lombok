package luna.vinicius.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ICRebelde {

    public ICRebelde() {
        rebeldes = new ArrayList<>();
    }

    private ArrayList<Rebelde> rebeldes;

    public void addRebelde(Rebelde rebelde){
        rebeldes.add(rebelde);
    }
}
