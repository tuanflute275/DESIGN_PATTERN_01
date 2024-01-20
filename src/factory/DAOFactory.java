package factory;

import dao.GenericDAO;
import dao.impl.CategoryDAOImpl;
import entities.Category;

public class DAOFactory {
	public GenericDAO<Category> getDao(){
		CategoryDAOImpl.getInstance().get();
		CategoryDAOImpl.getInstance().getByName(null);
		CategoryDAOImpl.getInstance().findId(null);
		CategoryDAOImpl.getInstance().add(null);
		CategoryDAOImpl.getInstance().edit(null);
		CategoryDAOImpl.getInstance().remove(null);
		return null;
	};
}
