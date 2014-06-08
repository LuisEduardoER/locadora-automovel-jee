package br.com.edu.managedbeans;

import br.com.edu.dao.AutomovelDao;
import br.com.edu.dto.Automovel;
import br.com.edu.dto.AutomovelPk;
import br.com.edu.exceptions.AutomovelDaoException;
import br.com.edu.jdbc.AutomovelDaoImpl;

public class AutomovelControl {

	static private AutomovelDao autoDao;

	public boolean insert(Automovel dto) throws AutomovelDaoException {

		autoDao = new AutomovelDaoImpl();

		return autoDao.insert(dto);

	}

	public boolean delete(AutomovelPk pk) throws AutomovelDaoException {
		autoDao = new AutomovelDaoImpl();

		return autoDao.delete(pk);
	}
	
	public boolean update(AutomovelPk pk, Automovel dto) throws AutomovelDaoException {
		autoDao = new AutomovelDaoImpl();

		return autoDao.update(pk, dto);
	}
	
	public Automovel[] findAll() throws AutomovelDaoException{
		
		autoDao = new AutomovelDaoImpl();
	
		return autoDao.findAll();		
	}
	
	public Automovel findAutomovelByPk(AutomovelPk pk) throws AutomovelDaoException{
		
		autoDao = new AutomovelDaoImpl();
	
		return autoDao.findByPrimaryKey(pk);		
	}

}
