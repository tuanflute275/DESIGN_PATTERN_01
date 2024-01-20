package factory;

import dao.GeneralDAO;
import dao.impl.CategoryDAOImpl;
import dao.impl.ProductDAOImpl;
import entities.Category;
import enumType.DAOType;

public class DAOFactory {
	public static GeneralDAO getDao(DAOType daoType){
		if(daoType == DAOType.Category) {
			  CategoryDAOImpl.getInstance();
		}else if(daoType == DAOType.Product) {
			ProductDAOImpl.getInstance();
		}
		return null;
	};
}
