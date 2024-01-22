package factory;

import dao.GeneralDAO;
import dao.impl.CategoryDAOImpl;
import dao.impl.ProductDAOImpl;
import entities.Category;
import enumType.DAOType;

public class DAOFactory {
	public static <T> GeneralDAO getDao(Class<T> _class){
		if(_class == CategoryDAOImpl.class) {
			  return CategoryDAOImpl.getInstance();
		}else if(_class == ProductDAOImpl.class) {
			return ProductDAOImpl.getInstance();
		}
		return null;
	};
}
