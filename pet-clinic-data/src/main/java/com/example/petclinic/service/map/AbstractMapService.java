package com.example.petclinic.service.map;

import com.example.petclinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService <T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

     Set<T> findAll() {
         return new HashSet<>(map.values());
     }

     T findById(ID id) {
         return map.get(id);
     }

     T save(T object) {
         if (object == null) {
             throw new RuntimeException("Object cannot be null");
         }
         object.setId(getNextId());
         return map.put(object.getId(), object);
     }

     void delete(T object) {
         map.entrySet().removeIf(entry -> entry.getValue().equals(object));
     }

     void deleteById(ID id) {
        map.entrySet().removeIf(entry -> entry.getKey().equals(id));
    }

    private Long getNextId() {
         if (map.keySet().isEmpty()) {
             return 1L;
         }
        return Collections.max(map.keySet()) + 1;
    }
}
