package oose.dea.dao;

import oose.dea.domain.Jedi;

import javax.enterprise.inject.Default;

@Default
public class JediDAO implements IJediDAO {

    @Override
    public Jedi getJedi(int id) {
        //go to db, but not now

        Jedi jedi = new Jedi(id);
        jedi.setName("Thijmen");
        jedi.setDark(false);
        jedi.setBsn("12345");

        return jedi;
    }
}
