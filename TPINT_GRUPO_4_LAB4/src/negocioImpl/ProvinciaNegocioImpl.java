package negocioImpl;

import java.util.ArrayList;

import dao.DaoProvincia;
import daoImpl.DaoProvinciaImpl;
import entidad.Provincia;
import negocio.ProvinciaNegocio;

public class ProvinciaNegocioImpl implements ProvinciaNegocio {
	
	DaoProvincia dao = new DaoProvinciaImpl();

	@Override
	public ArrayList<Provincia> listarProvincias() {
		return dao.listarProvincias();
	}
	
}
