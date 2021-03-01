package oose.dea.dao;

import oose.dea.domain.Jedi;

import javax.enterprise.inject.Alternative;

@Alternative
public class JediDAOMongoDB implements IJediDAO{
    @Override
    public Jedi getJedi(int id) {
        //go to db, but not now

        Jedi jedi = new Jedi(id);
        jedi.setName("Robert");
        jedi.setDark(false);
        jedi.setBsn("235896");

        return jedi;
    }
}
