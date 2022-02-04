package luna.vinicius.model;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Queue;

@Data
public class ICRebelde {

    public ICRebelde() {
        rebeldes = new ArrayDeque<>();
    }

    private Queue<Rebelde> rebeldes;

    public void addRebelde(Rebelde rebelde){
        rebeldes.add(rebelde);
    }
}
