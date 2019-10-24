package com.yana.first.lab.service;


import com.yana.first.lab.beans.*;
import com.yana.first.lab.dao.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppService {

    Map<Class, Dao> dao = new HashMap<>();

    public List getAll(Object o){
        return dao.get(o.getClass()).getAll();
    }
    public Object getById(int id, Class c){
        return dao.get(c).getById(id);
    }
    public void create(Object o){
        dao.get(o.getClass()).create(o);
    }
    public void update(Object o){
         dao.get(o.getClass()).update(o);
    }
    public void deleteById(int id, Class c){
        dao.get(c).deleteById(id);
    }
}
