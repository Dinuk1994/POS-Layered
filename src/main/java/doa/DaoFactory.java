package doa;

import doa.custom.impl.CustomerDaoImpl;
import doa.custom.impl.ItemDaoImpl;
import doa.util.DaoType;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){

    }

    public static DaoFactory getInstance(){
        return daoFactory!=null ? daoFactory : (daoFactory=new DaoFactory());
    }

    public <T extends Superdao>T getdao(DaoType type){
        switch (type){
            case CUSTOMER : return (T) new CustomerDaoImpl();
            case ITEM:  return (T) new ItemDaoImpl();
        }
        return null;
    }
}
