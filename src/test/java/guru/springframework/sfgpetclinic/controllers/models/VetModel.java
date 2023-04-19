package guru.springframework.sfgpetclinic.controllers.models;

import guru.springframework.sfgpetclinic.fauxspring.Model;

import java.util.HashMap;

public class VetModel implements Model {

    private HashMap<String, Object> modelHashMap =new HashMap();
    @Override
    public void addAttribute(String key, Object o) {
        modelHashMap.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        modelHashMap.put("", o);
    }

    public HashMap<String, Object> getModelHashMap() {
        return modelHashMap;
    }
}
