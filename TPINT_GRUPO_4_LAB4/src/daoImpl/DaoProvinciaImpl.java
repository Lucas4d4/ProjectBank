package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import dao.DaoProvincia;
import entidad.Provincia;

public class DaoProvinciaImpl implements DaoProvincia{

	@Override
	public ArrayList<Provincia> listarProvincias() {
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();
		String query = "select * from provincias";
		PreparedStatement statement;
		ResultSet resulSet;
		Conexion conexion = Conexion.getConexion();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(query);
			resulSet = statement.executeQuery();
			while(resulSet.next()) {
				Provincia prov = new Provincia();
				prov.setId(resulSet.getInt("pro_id"));
				prov.setNombre(resulSet.getString("pro_nombre"));
				provincias.add(prov);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return provincias;
	}

}
