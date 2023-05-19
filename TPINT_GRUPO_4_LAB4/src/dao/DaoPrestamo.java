package dao;

import java.util.List;

import entidad.Prestamo;

public interface DaoPrestamo {
	public List<Prestamo> ListarPrestamos();
	public List<Prestamo> ListarPedidosPrestamos();
	public int AgregarPrestamo(Prestamo prestamo);
	public int EliminarPedidoPrestamo(String NroPedidoo);
	public String traerNroCuenta(String NroPedido);
	public float traerImporteSolicitado(String NroPedido);
	public int traerCantCuotasSolicitado(String NroPedido);
	public int insertPedidoPrestamo(Prestamo prestamo);
	public Prestamo buscarPrestamo(String dni);
}
